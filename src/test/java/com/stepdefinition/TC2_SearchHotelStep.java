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
 *@see TC2_SearchHotelStep functionality cointains step definition
 *
 */

public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	@Then("User should perform search hotel by using all selected fields {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_perform_search_hotel_by_using_all_selected_fields_and(String location1, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultPerRoom, String childPerRoom) {
	pom.getSearchHotelPage().searchHotel(location1, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultPerRoom, childPerRoom);
	}
	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String expMsg) {
		WebElement wellSearchSuccessMsg = pom.getSelectHotelPage().getWellSearchSuccessMsg();
		String actMsg = getText(wellSearchSuccessMsg);
		Assert.assertEquals("verify after search hotel success message", expMsg, actMsg);
	}
	
	@Then("User should perform search hotel by using mandatory fields {string},{string},{string},{string} and {string}")
	public void user_should_perform_search_hotel_by_using_mandatory_fields_and(String location1, String noOfRooms, String checkInDate, String checkOutDate, String adultPerRoom) {
	pom.getSearchHotelPage().searchHotel(location1, noOfRooms, checkInDate, checkOutDate, adultPerRoom);
	}
	
	

	@Then("User should perform search hotel by using date checking {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_perform_search_hotel_by_using_date_checking_and(String location1, String hotels, String roomType, String noOfRooms, String checkInDate, String checkOutDate, String adultPerRoom, String childPerRoom) {
		pom.getSearchHotelPage().searchHotel(location1, hotels, roomType, noOfRooms, checkInDate, checkOutDate, adultPerRoom, childPerRoom);
	}
	@Then("User should verify after search hotel error message with {string},{string}")
	public void user_should_verify_after_search_hotel_error_message_with(String checkInError, String checkOutError) {
		WebElement checkInErrorMsg = pom.getSearchHotelPage().getCheckInErrorMsg();
		String actMsgIn = getText(checkInErrorMsg);
		WebElement checkOutErrorMsg = pom.getSearchHotelPage().getCheckOutErrorMsg();
		String actMsgOut = getText(checkOutErrorMsg);
		Assert.assertEquals("verify after search hotel error message", actMsgIn, checkInError);
		Assert.assertEquals("verify after search hotel error message", actMsgOut, checkOutError);
	}
	
	@Then("User should perform search hotel by without entry any fields")
	public void user_should_perform_search_hotel_by_without_entry_any_fields() {
		pom.getSearchHotelPage().searchHotel();
	}
	@Then("User should verify after search hotel error message {string}")
	public void user_should_verify_after_search_hotel_error_message(String expLocationMsg) {
		WebElement locationErrorMsg = pom.getSearchHotelPage().getLocationErrorMsg();
		String actLocationMsg = getText(locationErrorMsg);
		Assert.assertEquals("verify after search hotel error message", actLocationMsg, expLocationMsg);
	}













		



}
