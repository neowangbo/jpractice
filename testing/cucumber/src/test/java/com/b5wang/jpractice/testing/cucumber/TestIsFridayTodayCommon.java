package com.b5wang.jpractice.testing.cucumber;

import org.junit.Assert;

import com.b5wang.jpractice.testing.cucumber.IsFridayToday;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestIsFridayTodayCommon {
	
	private String today;
	
	private String isFriday;
	
	@Given("today is {string}")
	public void today_is(String today) {
		this.today = today;
	}
	
	@When("I ask if it's Friday yet")
	public void i_ask_if_it_s_Friday_yet() {
		isFriday = IsFridayToday.today(today);
	}
	
	@Then("The answer should be {string}")
	public void the_answer_should_be(String expectedAnswer) {
		Assert.assertEquals(expectedAnswer, isFriday);
	}
}
