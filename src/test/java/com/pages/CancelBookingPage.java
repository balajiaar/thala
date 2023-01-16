package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
			}
			
			@FindBy(xpath="(//input[@type='checkbox'])[2]")
			private WebElement selectCancelId;
			@FindBy(xpath="(//input[@type='button'])[1]")
			private WebElement cancelBtnId;
			@FindBy(xpath="//label[@class='reg_error']")
			private WebElement getText;
			@FindBy(xpath="//a[text()='Booked Itinerary']")
			private WebElement bookedItinerary;
			
			@FindBy(xpath="//input[@class='input_search']")
			private WebElement searchOrderId;
			@FindBy(xpath="//input[@class='button_search']")
			private WebElement goBtn;
			@FindBy(xpath="//label[@id='search_result_error']")
			private WebElement bookingCancelSuccessMsg;
			
			public WebElement getSelectCancelId() {
				return selectCancelId;
			}
			public WebElement getGetText() {
				return getText;
			}
			public WebElement getCancelBtnId() {
				return cancelBtnId;
			}
			public WebElement getBookedItinerary() {
				return bookedItinerary;
			}
			public WebElement getSearchOrderId() {
				return searchOrderId;
			}
			public WebElement getGoBtn() {
				return goBtn;
			}
			
			
			
	public WebElement getBookingCancelSuccessMsg() {
				return bookingCancelSuccessMsg;
			}
	public void cancelOrderId(String OrderId) {
clickElement(getBookedItinerary());
sendKeys(getSearchOrderId(), OrderId);
clickElement(getGoBtn());
clickElement(getSelectCancelId());
clickElement(getCancelBtnId());
alertOk();

	}
	
	
	public void cancelExistingOrderId(String OrderId) {
		sendKeys(getSearchOrderId(), OrderId);
		clickElement(getGoBtn());
		clickElement(getSelectCancelId());
		clickElement(getCancelBtnId());
		alertOk();
	}
}
