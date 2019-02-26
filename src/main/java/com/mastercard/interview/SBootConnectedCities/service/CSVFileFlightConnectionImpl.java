package com.mastercard.interview.SBootConnectedCities.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.util.ResourceUtils;

import com.mastercard.interview.SBootConnectedCities.ConnectionCatlogue;

public class CSVFileFlightConnectionImpl implements FlightConnectionService {

	private ConnectionCatlogue catlogue;

	public CSVFileFlightConnectionImpl(ConnectionCatlogue catl) {
		this.catlogue = catl;
	}

	@Override
	public boolean fetchDirectConnections(String fileWithCompulsoryTwoKeyPAir) {

		final Logger logger = Logger
				.getLogger(CSVFileFlightConnectionImpl.class.getName());

		try {

			File file = ResourceUtils.getFile(
					"classpath:static/" + fileWithCompulsoryTwoKeyPAir);

			/*
			 * ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			 * File file = new File(
			 * classLoader.getResource("static/connection.csv").getFile());
			 * 
			 * File inputF = new File(ClassLoader.getSystemClassLoader()
			 * .getResource("static/" + fileWithCompulsoryTwoKeyPAir)
			 * .getFile());
			 */
			InputStream inputFS = new FileInputStream(file);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(inputFS));

			br.lines().skip(1).map(line -> line.split(","))
					.forEach(connection -> catlogue.addDirectConnectionBetween(
							connection[0], connection[1]));

			br.close();

		} catch (IOException e) {
			logger.log(Level.SEVERE, " Cannot read file. "
					+ "It should be a CSV file in the format \"origin,destination\\n \" on each line",
					e);
			return false;
		}
		return true;
	}
}
