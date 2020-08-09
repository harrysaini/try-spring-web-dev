package com.harry.springdemo.mvc.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.harry.springdemo.mvc.validations.CourseCode;

public class Customer {

	private String firstName;

	@NotNull(message = "is Required")
	@Size(min = 1, message = "is Required")
	private String lastName;

	@NotNull()
	@Min(value = 0, message = "greater than 0")
	@Max(value = 10, message = "less than 10")
	private Integer freePasses;

	@NotNull(message = "is Required")
	@Pattern(regexp = "^[a-z0-9]{5}", message = "only 5 char/digits")
	private String postalCode;

	@CourseCode(value = "TOP", message = "must start with TOP")
	private String courseCode;

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
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

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", freePasses=" + freePasses + "]";
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
