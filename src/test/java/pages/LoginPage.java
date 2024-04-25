package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	
	//WebElements
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='username']")
		WebElement username_textbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_textbox;
	
	@FindBy(xpath="//input[@name='login']")
	 WebElement login_button;
	
	
	//Actions on the WebElement
	
	
	public void username_textbox(String text)
	{
		username_textbox.sendKeys(text);
		//type(username_textbox,text);
	}
	public void password_textbox(String text)
	{
		password_textbox.sendKeys(text);
	}
	public void login_button()
	{
	login_button.click();
	}

}
