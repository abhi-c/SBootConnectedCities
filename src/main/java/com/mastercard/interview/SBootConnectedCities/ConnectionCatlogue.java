package com.mastercard.interview.SBootConnectedCities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionCatlogue {

	final Logger logger = Logger
			.getLogger(ConnectionCatlogue.class.getName());
	
	private Map<String, LinkedHashSet<String>> directConnectionsCatogue = new HashMap<>();

	private HashSet<String> checkedForConnectivity = new HashSet<>();

	public long getDirectConnectionsSize() {
		return (long) directConnectionsCatogue.size();
	}

	public void addDirectConnectionBetween(String city1, String city2) {

		LinkedHashSet<String> directlyConnected = directConnectionsCatogue
				.get(city1);

		if (directlyConnected == null) {
			directlyConnected = new LinkedHashSet<>();
			directConnectionsCatogue.put(city1, directlyConnected);
		}
		directlyConnected.add(city2);

		directlyConnected = directConnectionsCatogue.get(city2);

		if (directlyConnected == null) {
			directlyConnected = new LinkedHashSet<>();
			directConnectionsCatogue.put(city2, directlyConnected);
		}
		directlyConnected.add(city1);
	}

	public synchronized boolean isConnected(String city1, String city2,
			boolean useCleanCheckList) {

		logger.log(Level.INFO, "Catlogue" + directConnectionsCatogue);
		if (useCleanCheckList) {
			checkedForConnectivity = new HashSet<>();
		}
		Set<String> directConnectionTo = directConnectionsCatogue.get(city1);
		if (directConnectionTo == null) {
			return false;
		}

		if (directConnectionTo.contains(city2)) {
			return true;
		} else {
			checkedForConnectivity.add(city1);
			logger.log(Level.INFO, "Visited Cities" + checkedForConnectivity.toString());
			logger.log(Level.INFO, "For "+city1, directConnectionTo);
			for (String layoverAtCity : directConnectionTo) {
				if (!checkedForConnectivity.contains(layoverAtCity)) {
					if (isConnected(layoverAtCity, city2, false)) {
						checkedForConnectivity.clear();
						return true;
					}
				}
			}
			return false;
		}
	}
}