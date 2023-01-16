package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {
	
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@name='radiobutton_0']")
	private WebElement radioBtn;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(className="login_title")
	private WebElement wellSearchSuccessMsg;
	@FindBy(xpath="//label[@class='reg_error']")
	private WebElement pleaseSelectHotelErrorMsg;
	
	public WebElement getRadioBtn() {
		return radioBtn;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
public WebElement getWellSearchSuccessMsg() {
		return wellSearchSuccessMsg;
	}

public WebElement getPleaseSelectHotelErrorMsg() {
	return pleaseSelectHotelErrorMsg;
}
public void selectHotel() {
	clickElement(getRadioBtn());
	clickElement(getBtnContinue());

}
public void clickContinue() {
	clickElement(getBtnContinue());
}


}
