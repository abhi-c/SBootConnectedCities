package com.mastercard.interview.SBootConnectedCities;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionCatlogueTest {
	
	
	@Test
	public final void testAddDirectConnectionBetween() {
		ConnectionCatlogue cat = new ConnectionCatlogue();
		cat.addDirectConnectionBetween("Boston", "New York");
		cat.addDirectConnectionBetween("Philadelphia", "Newark");
		cat.addDirectConnectionBetween("Newark", "Boston");
		cat.addDirectConnectionBetween("Trenton", "Albany");	
		
		assertEquals("",6L,cat.getDirectConnectionsSize());
	}

	@Test
	public final void testIsConnected() {
		ConnectionCatlogue cat = new ConnectionCatlogue();
		cat.addDirectConnectionBetween("Boston", "New York");
		cat.addDirectConnectionBetween("Philadelphia", "Newark");
		cat.addDirectConnectionBetween("Newark", "Boston");
		cat.addDirectConnectionBetween("Trenton", "Albany");	
		
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
