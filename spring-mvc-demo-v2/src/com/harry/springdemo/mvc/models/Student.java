package com.harry.springdemo.mvc.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String name;
	private String age;
	private String country;
	private String favoriteLanguage;
	private String[] operatingSystems;

	public static Map<String, String> countryOptions;
	public static Map<String, String> languageOptions;
	public static Map<String, String> osOptions;

	static {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("IN", "India");
		countryOptions.put("AR", "Argentina");

		languageOptions = new LinkedHashMap<>();
		languageOptions.put("C#", "C#");
		languageOptions.put("java", "java");

		osOptions = new LinkedHashMap<>();
		osOptions.put("mOS", "MAC OS");
		osOptions.put("LX", "Linux");
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", country " + country + "] " + hashCode();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

}
