package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.report.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags=(""),name="",dryRun=false,plugin= {"json:target\\output.json"},
stepNotifications=true,
features="src\\test\\resources\\Features",
glue="com.stepdefinition")
public class TestRunner extends BaseClass {

	
	
	
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
Reporting.generateJvmReport(getProjectPath()+getPropertyFileValue("jsonPath"));
	}
}
