package pages;

import org.junit.Assert;

import com.experitest.client.Client;

public class HomePage extends BasePage{
	
	private String makePayment               = "MakePayment";
    private String mortgageRequest           = "MortgageRequest";
    private String exspenseReport            = "ExpenseReport";
    private String logout                    = "Logout";
    private String homePageMissingElems      = "Failed to find All elements in home page";
    
	public HomePage(Client client) {
		
		super(client);
		Assert.assertTrue("Make payment button is not visible", 
				waitForElement("default", makePayment));
	}
	
    public LoginPage logout() throws InterruptedException {
        
        click("default", logout);        
        return new LoginPage(client);
        
    }
	@Override
	public void checkAllElementsAreFound() {
		
		Assert.assertTrue(homePageMissingElems, 
				isElementFound("default", makePayment) &
				isElementFound("default", logout) &
				isElementFound("default", exspenseReport) &
				isElementFound("default", mortgageRequest));
	}
    
}
