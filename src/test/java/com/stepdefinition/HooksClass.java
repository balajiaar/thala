package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
/**
 * 
 * @author Admin
 *@date 06/12/2022
 *@see HooksClass cointains Before class and After class
 *
 */
public class HooksClass extends BaseClass {
@Before
public void beforeScenario() throws FileNotFoundException, IOException {
	getDriver(getPropertyFileValue("browser"));
	appUrl(getPropertyFileValue("url"));
	maximize();
	
}



@After
public void afterScenario(Scenario scenario) {
scenario.attach(screenshotInBytes(), "images/png", "Every Scenario");
closeAllWindow();
}
}
