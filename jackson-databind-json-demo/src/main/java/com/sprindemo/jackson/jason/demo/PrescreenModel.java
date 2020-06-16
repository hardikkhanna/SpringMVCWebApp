package com.sprindemo.jackson.jason.demo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PrescreenModel {

	private static String Coverage;
	private static String County;
	private static int Age;
	private static String Pregnant;
	private static int income;
	private static String incometype;

	public static String isCoverage() {
		return Coverage;
	}

	public static void setCoverage(String coverage) {
		Coverage = coverage;
	}

	public static String getCounty() {
		return County;
	}

	public static void setCounty(String county) {
		County = county;
	}

	public static int getAge() {
		return Age;
	}

	public static void setAge(int age) {
		Age = age;
	}

	public static String isPregnant() {
		return Pregnant;
	}

	public static void setPregnant(String pregnant) {
		Pregnant = pregnant;
	}

	public static int getIncome() {
		return income;
	}

	public static void setIncome(int income) {
		PrescreenModel.income = income;
	}

	public static String getIncometype() {
		return incometype;
	}

	public static void setIncometype(String incometype) {
		PrescreenModel.incometype = incometype;
	}

}
