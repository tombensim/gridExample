package pages;

import com.experitest.client.Client;

public abstract class BasePage {
	protected Client  client;

    protected BasePage(Client client){
        this.client = client;
    }
    protected void click(String zone, String element){
    	
        client.click(zone, element, 0, 1);
    }
    protected void elementSendText(String zone, String element, String text){
    	
    	client.elementSendText(zone, element, 0, text);
    }
    
    protected boolean isElementFound(String zone, String element){
        return client.isElementFound(zone, element, 0);
    }
    
    protected void waitForElement(String zone, String element){
        client.waitForElement(zone, element, 0, 10000);
    }
    
    public abstract void checkAllElementsAreFound();
}
