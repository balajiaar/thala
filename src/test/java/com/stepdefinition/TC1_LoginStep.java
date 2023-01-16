package com.stepdefinition;
import java.io.FileNotFoundException;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



/**
 * 
 * @author Admin
 *@date 06/12/2022
 *@see TC1_LoginStep functionality cointains step definition
 *
 */
public class TC1_LoginStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	
	
	@Given("User is on the adactin page")
	public void user_is_on_the_adactin_page() throws FileNotFoundException, IOException {
		
		
	}
	@When("User should perform Login {string} and {string}")
	public void user_should_perform_login_and(String userName, String password) {
		pom.getLoginPage().login(userName, password);
		
	}
	

	
	@When("User should perform Login {string} and {string} with Enter key")
	public void user_should_perform_login_and_with_enter_key(String userName, String password) {
		pom.getLoginPage().loginWithEnterKey(userName, password);
	}
	
	
	
	@Then("User should verify after Login with invalid credential error message contains {string}")
	public void user_should_verify_after_login_with_invalid_credential_error_message_contains(String expErrorMsg) {
		WebElement txtErrorMsg = pom.getLoginPage().getTxtErrorMsg();
		String actMsg = getText(txtErrorMsg);
		boolean contains = actMsg.contains(expErrorMsg);
		Assert.assertTrue("verify after Login with invalid credential error message", contains);
	}







	
	
	
	}





