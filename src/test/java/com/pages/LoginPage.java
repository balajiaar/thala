package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
			}
		@FindBy(id="username")
		private WebElement txtUserName;
		@FindBy(id="password")
		private WebElement txtPassword;
		@FindBy(id="login")
		private WebElement btnLogin;
		@FindBy(xpath="//div[@class='auth_error']")
		private WebElement txtErrorMsg;

		public WebElement getTxtUserName() {
			return txtUserName;
		}
		public WebElement getTxtPassword() {
			return txtPassword;
		}
		public WebElement getBtnLogin() {
			return btnLogin;
		}
		
	
public WebElement getTxtErrorMsg() {
			return txtErrorMsg;
		}
public void login(String userName,String password) {
sendKeys(getTxtUserName(), userName);
sendKeys(getTxtPassword(), password);
clickElement(getBtnLogin());
}

public void loginWithEnterKey(String userName,String password) {
	sendKeys(getTxtUserName(), userName);
	sendKeysWithEnter(getTxtPassword(), password);
}
}
