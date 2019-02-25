package com.mastercard.interview.SBootConnectedCities.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityAvailabilityController {
	
	@RequestMapping(value = "/isConnected", method = RequestMethod.GET)
	public boolean isConnected(String origin, String destination) {
		return true;
	}
}
