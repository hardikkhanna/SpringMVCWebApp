package com.sprindemo.jackson.jason.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String args[]) {

		try {
			// create Object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read jason file and map to java pojo
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// print first name and last name
			System.out.println("First Name  = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());

			Address tempAdd = theStudent.getAddress();

			System.out.println("Street = " + tempAdd.getStreet());
			System.out.println("City = " + tempAdd.getCity());

			for (String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
