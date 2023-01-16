package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
			}
			@FindBy(id="location")
			private WebElement dDnLocation;
			@FindBy(id="hotels")
			private WebElement dDnHotel;
			@FindBy(id="room_type")
			private WebElement dDnRoomType;
			@FindBy(id="room_nos")
			private WebElement dDnNoOfRooms;
			@FindBy(xpath="//input[@name='datepick_in']")
			private WebElement txtCheckInDate;
			@FindBy(xpath="//input[@name='datepick_out']")
			private WebElement txtCheckOutDate;
			@FindBy(id="adult_room")
			private WebElement dDnAdultPerRoom;
			@FindBy(xpath="//select[@name='child_room']")
			private WebElement dDnChildPerRoom;
			@FindBy(id="Submit")
			private WebElement bthSearch;
			@FindBy(id="username_show")
			private WebElement wellMsg;
			@FindBy(xpath="//span[@id='checkin_span']")
			private WebElement checkInErrorMsg;
			@FindBy(xpath="//*[@id=\"checkout_span\"]")
			private WebElement checkOutErrorMsg;
			@FindBy(xpath="//*[@id=\"location_span\"]")
			private WebElement locationErrorMsg;
			
			public WebElement getWellMsg() {
				return wellMsg;
			}
			public WebElement getdDnLocation() {
				return dDnLocation;
			}
			public WebElement getdDnHotel() {
				return dDnHotel;
			}
			public WebElement getdDnRoomType() {
				return dDnRoomType;
			}
			public WebElement getdDnNoOfRooms() {
				return dDnNoOfRooms;
			}
			public WebElement getTxtCheckInDate() {
				return txtCheckInDate;
			}
			public WebElement getTxtCheckOutDate() {
				return txtCheckOutDate;
			}
			public WebElement getdDnAdultPerRoom() {
				return dDnAdultPerRoom;
			}
			public WebElement getdDnChildPerRoom() {
				return dDnChildPerRoom;
			}
			public WebElement getBthSearch() {
				return bthSearch;
			}
			
			
	public WebElement getLocationErrorMsg() {
				return locationErrorMsg;
			}
	public WebElement getCheckInErrorMsg() {
				return checkInErrorMsg;
			}
			public WebElement getCheckOutErrorMsg() {
				return checkOutErrorMsg;
			}
	public void searchHotel(String location1,String hotels,String roomType,String noOfRooms,
			String checkInDate,String checkOutDate,String adultPerRoom,String childPerRoom) {

		selectOptionByText(getdDnLocation(), location1);
		selectOptionByText(getdDnHotel(), hotels);
		selectOptionByText(getdDnRoomType(), roomType);
		selectOptionByText(getdDnNoOfRooms(), noOfRooms);
		getTxtCheckInDate().clear();
		sendKeys(getTxtCheckInDate(), checkInDate);
		getTxtCheckOutDate().clear();
		sendKeys(getTxtCheckOutDate(), checkOutDate);
		
		selectOptionByText(getdDnAdultPerRoom(), adultPerRoom);
		selectOptionByText(getdDnChildPerRoom(), childPerRoom);
		clickElement(getBthSearch());	
	}
	public void searchHotel(String location1,String noOfRooms,
			String checkInDate,String checkOutDate,String adultPerRoom) {


		selectOptionByText(getdDnLocation(), location1);
		selectOptionByText(getdDnNoOfRooms(), noOfRooms);
		
		sendKeys(getTxtCheckInDate(), checkInDate);
		sendKeys(getTxtCheckOutDate(), checkOutDate);
		
		selectOptionByText(getdDnAdultPerRoom(), adultPerRoom);
		clickElement(getBthSearch());
	}
	public void searchHotel() {
		
		clickElement(getBthSearch());		
	}
	
	
	
}
