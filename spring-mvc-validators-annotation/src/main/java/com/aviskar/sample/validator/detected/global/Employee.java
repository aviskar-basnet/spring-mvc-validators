package com.aviskar.sample.validator.detected.global;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Employee {

	@NotEmpty
	private String name;

	@Range(min = 1, max = 24)
	private int workingHr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorkingHr() {
		return workingHr;
	}

	public void setWorkingHr(int workingHr) {
		this.workingHr = workingHr;
	}
}
