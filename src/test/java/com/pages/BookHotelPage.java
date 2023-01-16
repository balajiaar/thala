package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement firstName;
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement lastName;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(xpath="//input[@name='cc_num']")
	private WebElement creditCard;
	@FindBy(xpath="//select[@name='cc_type']")
	private WebElement cardType;
	@FindBy(xpath="//select[@name='cc_exp_month']")
	private WebElement cardExpMonth;
	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement cardExpYear;
	@FindBy(xpath="//input[@name='cc_cvv']")
	private WebElement cvvNo;
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnBookNow;
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement wellSelectHotel;
	
	
	@FindBy(xpath="//label[@id='first_name_span']")
	private WebElement firstNameErrorMsg;
	@FindBy(xpath="//label[@id='last_name_span']")
	private WebElement lastNameErrorMsg;
	@FindBy(xpath="//label[@id='address_span']")
	private WebElement addressErrorMsg;
	@FindBy(xpath="//label[@id='cc_num_span']")
	private WebElement cardNoErrorMsg;
	@FindBy(xpath="//label[@id='cc_type_span']")
	private WebElement cardTypeErrorMsg;
	@FindBy(xpath="//label[@id='cc_expiry_span']")
	private WebElement cardExpiryErrorMsg;
	@FindBy(xpath="//label[@id='cc_cvv_span']")
	private WebElement cvvErrorMsg;
	
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditCard() {
		return creditCard;
	}
	public WebElement getCardType() {
		return cardType;
	}
	public WebElement getCardExpMonth() {
		return cardExpMonth;
	}
	public WebElement getCardExpYear() {
		return cardExpYear;
	}
	public WebElement getCvvNo() {
		return cvvNo;
	}
	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	
public WebElement getWellSelectHotel() {
		return wellSelectHotel;
	}

public WebElement getFirstNameErrorMsg() {
	return firstNameErrorMsg;
}
public WebElement getLastNameErrorMsg() {
	return lastNameErrorMsg;
}
public WebElement getAddressErrorMsg() {
	return addressErrorMsg;
}
public WebElement getCardNoErrorMsg() {
	return cardNoErrorMsg;
}
public WebElement getCardTypeErrorMsg() {
	return cardTypeErrorMsg;
}
public WebElement getCardExpiryErrorMsg() {
	return cardExpiryErrorMsg;
}
public WebElement getCvvErrorMsg() {
	return cvvErrorMsg;
}
public void bookHotel(String firstName,String secondName,String address,
		String cardNo,String cardType,String expMonth,String expYear,String cvvNo) {
	sendKeys(getFirstName(), firstName);
	sendKeys(getLastName(), secondName);
	sendKeys(getAddress(), address);
	sendKeys(getCreditCard(), cardNo);
	selectOptionByText(getCardType(), cardType);
	selectOptionByText(getCardExpMonth(), expMonth);
	selectOptionByText(getCardExpYear(), expYear);
	sendKeys(getCvvNo(), cvvNo);
	clickElement(getBtnBookNow());

}
public void bookHotel() {
	clickElement(getBtnBookNow());

}
}
