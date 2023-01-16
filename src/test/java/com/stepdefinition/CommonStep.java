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
 *@see CommonStep functionality cointains step definition
 *
 */

public class CommonStep extends BaseClass{
PageObjectManager pom = new PageObjectManager();

@Then("User should verify after Login success message {string}")
public void user_should_verify_after_login_success_message(String expWellMsg) {
	WebElement wellMsg = pom.getSearchHotelPage().getWellMsg();
	 String actLoginMsg = getAttributeValue(wellMsg);
Assert.assertEquals("verify after Login success message", expWellMsg, actLoginMsg);	 
	
	
	
	
}
}
