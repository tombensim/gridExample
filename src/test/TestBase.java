package test;

import com.experitest.appium.SeeTestAndroidDriver;
import com.experitest.appium.SeeTestAndroidElement;
import com.experitest.appium.SeeTestCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tom.ben-simhon on 12/26/2016.
 * Test Base Class holds all members required to run a test, and details general capabilities
 * For the Driver
 */
public class TestBase {

    private final String projectBaseDirectory;
    private String testName;
    private String host;
    private int port;
    private String reportDirectory;
    private String reportFormat;
    protected SeeTestAndroidDriver<SeeTestAndroidElement> driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private DesiredCapabilities caps;

    //Constructors
    public  TestBase(DesiredCapabilities caps){
        this.caps = caps;
        host = "localhost";
        port = 8889;
        reportDirectory = "reports";
        reportFormat = "xml";
        driver = null;
        projectBaseDirectory = "C:\\Users\\tom.ben-simhon\\workspace\\project4";
    }
    public TestBase(){
        this(null);
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Appium Capabilities
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");

        /* Appium Studio Additional
                 Here we place all of the additonal capabilites that will be used to automatically generate reports, and dynamicall select Device
          */
        //Reporting Configurations
        capabilities.setCapability(SeeTestCapabilityType.REPORT_DIRECTORY, reportDirectory);
        capabilities.setCapability(SeeTestCapabilityType.REPORT_FORMAT, reportFormat);
        capabilities.setCapability(SeeTestCapabilityType.TEST_NAME, testName);

        //Dynamic Device Query capabilities
        capabilities.setCapability(SeeTestCapabilityType.DEVICE_QUERY, "@name='LGE Nexus 5'");
        capabilities.setCapability(SeeTestCapabilityType.INSTRUMENT_APP, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

//        capabilities.setCapability(SeeTestCapabilityType.PROJECT_BASE_DIRECTORY, projectBaseDirectory);
        driver = new SeeTestAndroidDriver<SeeTestAndroidElement>(new URL("http://" + host + ":" + port), capabilities);

    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}

