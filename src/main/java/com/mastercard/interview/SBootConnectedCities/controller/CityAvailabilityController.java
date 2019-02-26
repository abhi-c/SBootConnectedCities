package com.mastercard.interview.SBootConnectedCities.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.interview.SBootConnectedCities.ConnectionCatlogue;
import com.mastercard.interview.SBootConnectedCities.service.CSVFileFlightConnectionImpl;
import com.mastercard.interview.SBootConnectedCities.service.FlightConnectionService;

@RestController
public class CityAvailabilityController {

	@RequestMapping(value = "/isConnected", method = RequestMethod.GET)
	public boolean isConnected(String origin, String destination) {
		ConnectionCatlogue cat = new ConnectionCatlogue();
//		cat.addDirectConnectionBetween("Boston", "New York");
//		cat.addDirectConnectionBetween("Philadelphia", "Newark");
//		cat.addDirectConnectionBetween("Newark", "Boston");
//		cat.addDirectConnectionBetween("Trenton", "Albany");	
		
		FlightConnectionService serv = new CSVFileFlightConnectionImpl(cat);
		serv.fetchDirectConnections("connection.csv");
		
		return cat.isConnected(origin, destination, true);
	}
}
