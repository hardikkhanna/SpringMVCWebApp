package com.javatpoint;

import java.util.LinkedHashMap;

public class Reservation {

	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;

	public Reservation() {

		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "BRAZIL");
		countryOptions.put("IN", "INDIA");
		countryOptions.put("US", "UNITED STATES");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}
}
