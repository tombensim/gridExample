package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import models.Creds;

import java.util.NoSuchElementException;


public class LoginPage extends BasePage{

	//Reference Objects
	@AndroidFindBy(xpath = "//*[@id='usernameTextField']")
	private MobileElement usernameField;
	@AndroidFindBy(xpath = "//*[@id='passwordTextField']")
    private MobileElement passwordField;
	@AndroidFindBy(xpath = "//*[@text='Login']")
    private MobileElement loginButton;
    
    public LoginPage(AppiumDriver driver) {
		super(driver);
	}
    // Page methods

    /*
     Tries to login to the application
    -  @params Creds, Username and Password
    */
    public void login(String username, String password) throws NoSuchElementException{
   		usernameField.sendKeys(username);
        passwordField.sendKeys(password);
		loginButton.click();
    }

}
