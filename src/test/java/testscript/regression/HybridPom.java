package testscript.regression;

import java.util.HashMap;

import javax.lang.model.element.Element;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;
import util.UtilKit;


public class HybridPom extends BaseTest{
	
	@Test(dataProvider = "getData")
	public void loginTest(HashMap<String, String> data)
	
	{
		//LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
		LoginPage lp = new LoginPage();
		lp.username_textbox(data.get("username"));
		//lp.username_textbox(data.get("username"));
		lp.password_textbox(data.get("password"));
		lp.login_button();
		
		SearchHotelPage sp = new SearchHotelPage();
		sp.verifyTitle(data.get("Expected Title1"));
		sp.welcomeMenuText(data.get("welcome text"));
		sp.location_dropDrown(data.get("Location"));
		sp.hotel_dropDrown(data.get("Hotels"));
		sp.roomType_dropDrown(data.get("Room Type"));
		sp.nofRooms_dropDrown(data.get("Number of Rooms"));
		sp.checkInDate(data.get("Check In Date"));
		sp.checkOutDate(data.get("Check Out Date"));
		sp.adultsPerRoom(data.get("Adults per Room"));
		sp.childrenPerRoom(data.get("Children per Room"));
		sp.searchButton();
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object data[][] = new Object[1][1];
		data[0][0]=UtilKit.getTestDataFromExcel("TC-102");
		return data;
	}
	
	
}
