package Main;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.xstream.XStream;

import testCases.*;
import IO.IO;
import Main.*;

public class WebDriver_Execute{
	private StringBuffer verificationErrors = new StringBuffer();
	public static WebDriver driver;
	public static final Logger log4j = LogManager.getLogger(WebDriver_Execute.class);         

	public WebDriver_Execute(TestCase t) throws IOException, ClassNotFoundException {
		IO io = new IO();
		//io.readConfig();
		//WebDriver execution
        String baseUrl = "http://mm-64serv12.qa.x1dev.com:8181/x1d"; 
        ProfilesIni profile = new ProfilesIni(); // Setting browser profile 
        FirefoxProfile qaprofile = profile.getProfile("QATesting");// Setting browser profile
        qaprofile.setPreference("webdriver_enable_native_events", false);// Setting browser profile
        driver = new FirefoxDriver(qaprofile);
        
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    TestCase c = t;
	    t.WebDriver(driver, wait, baseUrl);
	    //XStream xstream = new XStream();
	    //Setup setup = new Setup();
	    //xs.alias("Setup", Setup.class);
		
	    ///setup = (Setup)xstream.fromXML(io.readFile("auto_config.xml"));
	    
	    
	    //setup.WebDriver(driver, wait, baseUrl);
	    //del.WebDriverDelete(driver, wait, baseUrl);
	    //WebDriverSetup  
       // for (Setup setup : RootContext.setupList) {
        //    setup.WebDriverSetup(driver, wait, baseUrl);
	    // }
	    
       /* //WebDriverEDM
        for (EDM edm : RootContext.edmList) {
  	        edm.WebDriverEDM(driver, wait, baseUrl);
        }
  	    //WebDriverES

        for (ES es : RootContext.esList) {
            try {
				es.WebDriverES(driver, wait, baseUrl);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
         }*/
        
        System.out.println("Automation finished!");
        driver.quit();
	  }//end Construct

	@After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
}
	
	


