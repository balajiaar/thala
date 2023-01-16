package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Admin
 *@date 06/12/2022
 *@see TC3_SelectHotelStep functionality cointains step definition
 *
 */
public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	@Then("User should perform select hotel by hotel name")
	public void user_should_perform_select_hotel_by_hotel_name() {
		pom.getSelectHotelPage().selectHotel();
	}
	@Then("User should verify after select hotel success message {string}")
	public void user_should_verify_after_select_hotel_success_message(String expWellMsg) {
		implicitywait(20);
	WebElement wellSelectHotel = pom.getBookHotelPage().getWellSelectHotel();
	String actMsg = getText(wellSelectHotel);
	
		Assert.assertEquals("verify after select hotel success message", expWellMsg, actMsg);
	}

	@Then("User should perform select hotel by without select hotel name")
	public void user_should_perform_select_hotel_by_without_select_hotel_name() {
		pom.getSelectHotelPage().clickContinue();
	}
	@Then("User should verify after select hotel error message {string}")
	public void user_should_verify_after_select_hotel_error_message(String expMsg) {
		WebElement pleaseSelectHotelErrorMsg = pom.getSelectHotelPage().getPleaseSelectHotelErrorMsg();
		String actMsg = getText(pleaseSelectHotelErrorMsg);
		Assert.assertEquals("verify after select hotel error message", actMsg, expMsg);
	}






}
