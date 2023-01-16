package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
/**
 * 
 * @author Admin
 *@date 06/12/2022
 *@see TC4_BookHotelStep functionality cointains step definition
 *
 */
public class TC4_BookHotelStep extends BaseClass{
PageObjectManager pom = new PageObjectManager();


	@Then("User should perform book hotel by select all fields {string},{string} and {string}")
	public void user_should_perform_book_hotel_by_select_all_fields_and(String firstName, String secondName, String address, io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String cardNo = map.get("Credit Card No.");
		String cardType = map.get("Credit Card Type");
		String expMonth = map.get("Expiry Month");
		String expYear = map.get("Expiry Year");
		String cvvNo = map.get("CVV Number");
		pom.getBookHotelPage().bookHotel(firstName, secondName, address, cardNo, cardType, expMonth, expYear, cvvNo);	
	}
	@Then("User should verify after book hotel success message {string} and save the generated order id")
	public void user_should_verify_after_book_hotel_success_message_and_save_the_generated_order_id(String expWellMsg) {
		implicitywait(20);
		String orderId = pom.getBookingconfirmPage().getOrderId();

		//System.out.println(orderId);
		implicitywait(20);
		WebElement wellMsgBookingConfirm = pom.getBookingconfirmPage().getWellMsgBookingConfirm();
		String actWellMsg = getText(wellMsgBookingConfirm);
		Assert.assertEquals("verify after book hotel error message", expWellMsg, actWellMsg);
	
		
	}

	@Then("User should perform book hotel by without Select any fields")
	public void user_should_perform_book_hotel_by_without_select_any_fields() {
		pom.getBookHotelPage().bookHotel();
	}
	@Then("User should verify after book hotel error message {string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_after_book_hotel_error_message_and(String expFirstNameMsg, String expLastNameMsg, String expAddressMsg, String expCardMsg, String expCardTypeMsg, String expCardExpiryMsg, String expCardCvvMsg) {
	WebElement firstName = pom.getBookHotelPage().getFirstNameErrorMsg();
	String actFirstname = getText(firstName);
	Assert.assertEquals("verify after book hotel error message", expFirstNameMsg, actFirstname);
	WebElement lastNameErrorMsg = pom.getBookHotelPage().getLastNameErrorMsg();
	String actLastname = getText(lastNameErrorMsg);
	Assert.assertEquals("verify after book hotel error message", expLastNameMsg, actLastname);
	WebElement addressErrorMsg = pom.getBookHotelPage().getAddressErrorMsg();
	String actAddressMsg = getText(addressErrorMsg);
	Assert.assertEquals("verify after book hotel error message", expAddressMsg, actAddressMsg);
	WebElement cardNoErrorMsg = pom.getBookHotelPage().getCardNoErrorMsg();
	String actCardNoMsg = getText(cardNoErrorMsg);
	Assert.assertEquals("verify after book hotel error message", expCardMsg, actCardNoMsg);
	WebElement cardTypeErrorMsg = pom.getBookHotelPage().getCardTypeErrorMsg();
	String actCardTypeMsg = getText(cardTypeErrorMsg);
	Assert.assertEquals("verify after book hotel error message", expCardTypeMsg, actCardTypeMsg);
	WebElement cardExpiryErrorMsg = pom.getBookHotelPage().getCardExpiryErrorMsg();
	String actCardExpiryMsg = getText(cardExpiryErrorMsg);
	Assert.assertEquals("verify after book hotel error message", expCardExpiryMsg, actCardExpiryMsg);
	WebElement cvvErrorMsg = pom.getBookHotelPage().getCvvErrorMsg();
	String actCardCvvMsg = getText(cvvErrorMsg);
	Assert.assertEquals("verify after book hotel error message", expCardCvvMsg, actCardCvvMsg);
	}

}
