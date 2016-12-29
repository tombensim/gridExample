package test;

import io.appium.java_client.MobileElement;
import models.Creds;
import org.junit.BeforeClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by tom.ben-simhon on 12/27/2016.
 */
public class LoginTest extends TestBase {
    //Class private members
    private static final String VALID_USER = "company";
    private static final String VALID_PASSWORD = "company";
    private static final String INVALID_PASSWORD = "invalid";
    private static final String INVALID_USER = "invalid";

    private LoginPage loginPage = null;
    @BeforeTest
    public void setUpLoginTests() {
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testLoginWithValidCreds()
    {
        loginPage.login(VALID_USER,VALID_PASSWORD);
    }
    @Test

    public void testFailToLoginWithInvalidCreds()
    {
        loginPage.login(INVALID_USER,INVALID_PASSWORD);
        driver.findElementByXPath("//*[contains(@text,'Wrong Username']");
    }
    @AfterTest
    public void tearDownLoginTests()
    {
        driver.resetApp();
    }
}
