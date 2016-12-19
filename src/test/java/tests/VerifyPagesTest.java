package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.experitest.client.Client;
import com.experitest.client.GridClient;

import logger.LoggerClass;
import pages.HomePage;
import pages.LoginPage;

public class VerifyPagesTest {
	
    protected Client client                  = null;
    protected GridClient grid                = null;
    private String projectDir                = "\\GridDemoDir";
    protected String testName                = "LoginTest";
    private String loginUserName             = "company";
    private String loginPassword             = "company";
    String appName                           = "cloud:com.experitest.ExperiBank";
    
    private HomePage homePage;
    private LoginPage loginPage;
    protected LoggerClass logger;

    @Parameters({"os", "TestNGName"})
    @BeforeTest
    public void setUp(String os, String TestNGName) throws InterruptedException{
    	
    	logger = new LoggerClass(TestNGName); 
    	
    	grid = new GridClient(<username>, <password>, <project>, <ip>, <port>, false);
        client = grid.lockDeviceForExecution(testName, String.format("@os='%s'", os),60, 500000);
        
        logger.writeLine("Got client for execution");
        
        logger.writeLine("Setting the project base directory");
        String projDir = System.getProperty("user.dir") + projectDir;
        client.setProjectBaseDirectory(projDir);
        
        client.setReporter("xml", "reports", "Untitled");
        
    	if (os.equals("android")){
    		appName += "/.LoginActivity";
    	}
    	
        logger.writeLine("installing ExperiBank app");
        client.install(appName, true, false);
        
        logger.writeLine("launching ExperiBank app");
        client.launch(appName, true, true);
        
          
    }
    

    @Test(description="Check Login Page")
    public void loginPage() throws InterruptedException
    {
    	loginPage = new LoginPage(client);
    	
    	logger.writeLine("validating all elements appear in LoginPage");
    	loginPage.checkAllElementsAreFound();
    	
    	logger.writeLine("Log in");
    	homePage = loginPage.login(loginUserName, loginPassword);
    	
    	logger.writeLine("Login Page Test finished successfuly");
    	
    }
    
    
    @Test(description="Check HomePage", dependsOnMethods={"loginPage"})
    public void homePage() throws InterruptedException{
    	
    	
    	logger.writeLine("check all elements are found in home page");
    	homePage.checkAllElementsAreFound();
    	
    	logger.writeLine("perform logout");
    	loginPage = homePage.logout();
    	    	
    	logger.writeLine("Logged out from home page");
    	logger.writeLine("Home Page Test finished successfuly");

    	
    }
    @AfterTest(alwaysRun=true)
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        System.out.println(client.generateReport(false));
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
