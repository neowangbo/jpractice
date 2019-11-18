package com.b5wang.jpractice.testing.cucumber;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestEmployee {

	private Employee employee = new Employee();
	
	private boolean isFitEmployee;
	
	private boolean isLeader;
	
	
	@Given("gender is male")
	public void gender_is_male() {
		employee.setGender("M");
	}
	
	@And("age is within 30 and 40")
	public void age_is_within_30_and_40() {
		employee.setAge(40);
	}
	
	@And("it is not married yet")
	public void it_is_not_married_yet() {
		employee.setMarried(false);
	}
	
	@When("I ask whether it is a fit employee")
	public void i_ask_whether_it_is_a_fit_employee() {
		isFitEmployee = employee.isFitEmployee();
	}
	
	@When("I ask whether it can become a leader")
	public void i_ask_whether_it_can_become_a_leader() {
		isLeader = employee.isLeader();
	}
	
	@Then("it is a fit employee")
	public void it_is_a_fit_employee() {
		Assert.assertEquals(isFitEmployee, true);
	}
	
	
	@Then("it should not be a leader")
	public void it_should_not_be_a_leader() {
		Assert.assertEquals(isLeader, false);
	}
}
