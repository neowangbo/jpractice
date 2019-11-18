package com.b5wang.jpractice.testing.cucumber;

import org.junit.Assert;

import com.b5wang.jpractice.testing.cucumber.IsFridayToday;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestIsFridayToday {
	
	private String today;
	
	private String isFriday;
	
	/**
	 * Given steps are used to describe the initial context of the system - the scene of the scenario. 
	 * It is typically something that happened in the past.
	 * When Cucumber executes a Given step, it will configure the system to be in a well-defined state, 
	 * such as creating and configuring objects or adding data to a test database.
	 * */
	@Given("today is Sunday")
	public void today_is_Sunday() {
		today = "Sunday";
	}

	/**
	 * When steps are used to describe an event, or an action. This can be a person interacting with the system, 
	 * or it can be an event triggered by another system.
	 *  
	 * */
	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_Friday_yet() {
		isFriday = IsFridayToday.today(today);
	}

	
	/**
	 * Then steps are used to describe an expected outcome, or result.
	 * Then step should use an assertion to compare the actual outcome (what the system actually does) 
	 * to the expected outcome (what the step says the system is supposed to do).
	 * */
	@Then("I should be told {string}")
	public void i_should_be_told(String expectedAnswer) {
		Assert.assertEquals(expectedAnswer, isFriday);
	}
	
	@Given("today is Friday")
	public void today_is_Friday() {
		today = "friday";
	}
}
