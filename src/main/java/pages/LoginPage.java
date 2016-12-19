package pages;

import org.junit.Assert;

import com.experitest.client.Client;
public class LoginPage extends BasePage{

	private String usernameField               = "Username";
    private String passwordField               = "Password";
    private String loginButton                 = "Login";
    private String loginPageMissingElementsMSG = "Failed to find All elements in Login page";
    private String loginPageMissingLoginButton = "Failed to find login element";
    
    public LoginPage(Client client) {
    	
		super(client);
    	Assert.assertTrue(loginPageMissingLoginButton,
    			waitForElement("default", loginButton));
	}

    public HomePage login(String username, String password){
        
    	elementSendText("default", usernameField, username);
    	elementSendText("default", passwordField, password);
        click("default", loginButton);
        
        return new HomePage(client);       
    }
    
	@Override
	public void checkAllElementsAreFound() {
		Assert.assertTrue(loginPageMissingElementsMSG,
				isElementFound("default", usernameField)
				& isElementFound("default", passwordField)
				& isElementFound("default", loginButton));
	}

	public void checkLoginElementIsFound() {
		
		Assert.assertTrue(loginPageMissingLoginButton, isElementFound("default", loginButton));
	}
}
