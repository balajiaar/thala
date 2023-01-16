package com.rough;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.base.BaseClass;

public class RoughTwo extends BaseClass {
public static void main(String[] args) throws FileNotFoundException, IOException {
	//getChromeDriver();
	getDriver("chrome");
	String propertyFileValue = getPropertyFileValue("url");
	System.out.println(propertyFileValue);
	String projectPath = getProjectPath();
	System.out.println(projectPath);

}
}
