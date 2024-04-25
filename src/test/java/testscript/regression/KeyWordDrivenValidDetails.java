package testscript.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKyeword;

public class KeyWordDrivenValidDetails extends BaseTest{
	
	@Test
	public void keywordDrivFrame()
	{
		 ApplicationKyeword app = new ApplicationKyeword();
		 app.openBrow();
		 app.launchApp();
		 app.type("username_textbox","reyaz0806");
		 app.type("password_textbox", "reyaz123");
		 app.click("login_button");
	}
	

}
