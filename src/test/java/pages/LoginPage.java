package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.NoSuchElementException;


public class LoginPage extends BasePage{

	//Reference Objects
    @AndroidFindBy(xpath = "//*[@resource-id='usernameTextField']")
    protected MobileElement usernameField;
    @AndroidFindBy(xpath = "//*[@resource-id='passwordTextField']")
    protected MobileElement passwordField;
    @AndroidFindBy(xpath = "//*[@text='Login']")
    protected MobileElement loginButton;
    
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
