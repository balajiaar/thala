package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingconfirmPage extends BaseClass {
	public BookingconfirmPage() {
		PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//input[@name='order_no']")
			private WebElement getOderId;
			@FindBy(xpath="//a[text()='Booked Itinerary']")
			private WebElement bookedItinerary;
			@FindBy(xpath="//td[text()='Booking Confirmation ']")
			private WebElement wellMsgBookingConfirm;
			
			public WebElement getGetOderId() {
				return getOderId;
			}
			
			public WebElement getBookedItinerary() {
			return bookedItinerary;
			}
			
		
			public WebElement getWellMsgBookingConfirm() {
				return wellMsgBookingConfirm;
			}

			public String getOrderId() {
				String orderId = getAttributeValue(getGetOderId());
				return orderId;
}


}
