package com.mastercard.interview.SBootConnectedCities.service;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

import com.mastercard.interview.SBootConnectedCities.ConnectionCatlogue;

public class CSVFileFlightConnectionImplTest {

	@Test
	public final void testFetchDirectConnectionsFileExists() {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		File file = new File(classLoader.getResource("connection.csv").getFile());
		assertEquals(true, file.exists());
	}
	

	@Test
	public final void testFetchDirectConnections() {
		ConnectionCatlogue cat = new ConnectionCatlogue();
		FlightConnectionService serv = new CSVFileFlightConnectionImpl(cat);
		serv.fetchDirectConnections("connection.csv");
		
		assertEquals("",true,cat.isConnected("Boston", "New York", true));
		assertEquals("",true,cat.isConnected("Boston", "Newark", true));
		assertEquals("",true,cat.isConnected("Boston", "Philadelphia", true));
		assertEquals("",true,cat.isConnected("Boston", "Philadelphia", true));
		assertEquals("",false,cat.isConnected("Boston", "Trenton", true));
		assertEquals("",false,cat.isConnected("Philadelphia", "Albany", true));
		assertEquals("",false,cat.isConnected("Albany", "Newark", true));
		assertEquals("",true,cat.isConnected("Boston", "Philadelphia", true));
	
	}

}
