package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BasePage{
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@class='welcome_menu']")
	WebElement welcomeMenuText;
	@FindBy(xpath="//select[@name='location']")
	WebElement location_dropDrown;
	@FindBy(xpath="//select[@name='hotels']")
	WebElement hotel_dropDrown;
	@FindBy(xpath="//select[@name='room_type']")
	WebElement roomType_dropDrown;
	@FindBy(xpath="//select[@name='room_nos']")
	WebElement nofRooms_dropDrown;
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDate;
	@FindBy(xpath="//input[@name='datepick_out']")
	WebElement checkOutDate;
	@FindBy(xpath="//select[@name='adult_room']")
	WebElement adultsPerRoom;
	@FindBy(xpath="//select[@name='child_room']")
	WebElement childrenPerRoom;
	@FindBy(xpath="//input[@name='Submit']")
	WebElement searchButton;
	
	public void welcomeMenuText(String text)
	{
		verifyText(welcomeMenuText, text);
	}
	public void location_dropDrown(String option)
	{
		selectFromDropDown(location_dropDrown, option);
	}
	public void hotel_dropDrown(String option)
	{
		selectFromDropDown(hotel_dropDrown, option);
	}
	public void roomType_dropDrown(String option)
	{
		selectFromDropDown(roomType_dropDrown, option);
	}
	public void nofRooms_dropDrown(String option)
	{
		selectFromDropDown(nofRooms_dropDrown, option);
	}
	public void checkInDate(String date)
	{
		clear(checkInDate);
		type(checkInDate,date);
	}
	public void checkOutDate(String date)
	{
		type(checkOutDate, date);
	}
	public void adultsPerRoom(String option)
	{
		selectFromDropDown(adultsPerRoom, option);
	}
	public void childrenPerRoom(String option)
	{
		selectFromDropDown(childrenPerRoom, option);
	}
	public void searchButton()
	{
		searchButton.click();
	}
}
