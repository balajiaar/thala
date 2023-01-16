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
 *@see TC5_CancelBookingStep functionality cointains step definition
 *
 */
public class TC5_CancelBookingStep extends BaseClass {
PageObjectManager pom = new PageObjectManager();

	@Then("User should perform cancel the generated order id")
	public void user_should_perform_cancel_the_generated_order_id() {
		implicitywait(20);
	
		String orderId = pom.getBookingconfirmPage().getOrderId();
		
		pom.getCancelBookingPage().cancelOrderId(orderId);
		

	
	}
	@Then("User should verify after cancel the order id success message {string}")
	public void user_should_verify_after_cancel_the_order_id_success_message(String expCancelMsg) {
		implicitywait(20);
		WebElement bookingCancelMsg = pom.getCancelBookingPage().getBookingCancelSuccessMsg();
		String actCancelMsg = getText(bookingCancelMsg);
		Assert.assertEquals("verify after cancel the order id success message", expCancelMsg, actCancelMsg);
	}

	@Then("User should perform cancel the existing order id {string}")
	public void user_should_perform_cancel_the_existing_order_id(String orderId) {
		pom.getCancelBookingPage().cancelOrderId(orderId);
		
	
	}
	






	




}
