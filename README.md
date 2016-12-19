## GridExample
This project consists of testNG test written for the EriBank application, and designed to show a demo for SeeTest Cloud Grid feature,
please use this example as a refernce when attempting to use the Grid feature.

This project was written with [page-object-design-pattern](http://www.seleniumhq.org/docs/06_test_design_considerations.jsp#page-object-design-pattern).

## Grid Feature
The idea behind the [Grid](https://docs.experitest.com/display/public/SC/Manage+Test+Requests) is that we are able to exute one testNG suite, which will launch 5 IOS tests and 5 android tests, by reserving a device using the [os query](https://docs.experitest.com/display/public/SA/WaitForDevice), and the grid will automatically assign a device to the test, and run the test, if the license includes less than 10 grid nodes, or the cloud has less than the required devices, then the test will be queued untill a device is available.

## Concept
The project consists of the following files:  
![ScreenShot](https://raw.github.com/KhaledAbbasExperitest/GridExample/master/ProjectScreenShots/ProjectFiles.PNG)  

1.pages directory - should include a page object for each page in your application:  
  (``*``) BasePage - this page should act as a base class for your application pages.  
  (``*``) HomePage - page object that represents our home page.  
  (``*``) LoginPage - page object that represents our login page.
	
2.test package - should include all your tests:  
  (``*``) VerifyPagesTest - this test will perfrom Login and Logout, and verify expected elements are found in the Home and Login pages
	
3.Logger package:  
  (``*``) LoggerClass - includes a logger class that will record the test actions to a local file.  
	
4.GridDemoDir:  
  (``*``) SeeTest [object repository](https://docs.experitest.com/display/public/SA102/Objects+Repository) used in our test  

## Used SeeTest commands:  
The project used few SeeTest commands, you are advised to visit [this page](https://docs.experitest.com/display/public/SA/Working+With+Test+Commands) for exploring the wide range of commands available in SeeTest  
1. [setProjectBaseDirectory](https://docs.experitest.com/display/public/SA/SetProjectBaseDirectory)  
2. [setReporter](https://docs.experitest.com/display/public/SA/SetReporter)  
3. [install](https://docs.experitest.com/display/public/SA/Install)  
4. [launch](https://docs.experitest.com/display/public/SA/Launch)  
5. [click](https://docs.experitest.com/display/public/SA/Click)  
6. [elementSendText](https://docs.experitest.com/display/public/SA/ElementSendText)  
7. [waitForElement](https://docs.experitest.com/display/public/SA/WaitForElement)  
8. [isElementFound](https://docs.experitest.com/display/public/SA/IsElementFound)  
9. lockDeviceForExecution  

## Installing SeeTest cloud  
Please follow the guide [Setting up](https://docs.experitest.com/display/public/SC/Setting+Up)  

## Project Setup  
1. Create new maven project using Java IDE.(Eclipse neon was used for this project)  
2. Fork this project.  
3. use the pom file, or create your own but make sure to add the following dependency:  
```
  <dependencies>
   <dependency>
    <groupId>com.experitest</groupId>
    <artifactId>SeeTestClient</artifactId>
    <version>10.2.46</version>
    </dependency>
  </dependencies>
```
4. Run the command maven update project, to fetch the dependencies.  
5. Add the testNG plugin to your java IDE.  

## Running the test  
1. Ensure that you have SeeTest cloud version >= 10.2  
2. Ensure you have the following dependencies:  
![ScreenShot](https://raw.github.com/KhaledAbbasExperitest/GridExample/master/ProjectScreenShots/Dependencies.PNG)  
3. Enter your credentials in the verifyPagesTest  
4. Right Click on the file testng.seetestGrid.xml file, and run as TestNGSuite.  
