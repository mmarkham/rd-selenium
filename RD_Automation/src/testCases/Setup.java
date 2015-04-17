package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Main.WebDriver_Execute;

public class Setup extends TestCase {
	private boolean init;
	private String matterLocation;
	private String companyName;
	private String indexLocation;
	private String numSmallIndex;
	private String numMediumIndex;
	private String numLargeIndex;
	 
	//constructor
	public Setup (boolean init, String matterLocation, String companyName, String indexLocation, String numSmallIndex, String numMediumIndex, String numLargeIndex){
		this.init = init;
   	  	this.matterLocation = matterLocation;
   	  	this.companyName = companyName;
   	  	this.indexLocation = indexLocation;
   	  	this.numSmallIndex = numSmallIndex;
   	  	this.numMediumIndex = numMediumIndex;
   	  	this.numLargeIndex = numLargeIndex;
     }
     
	public Setup() {
		// TODO Auto-generated constructor stub
	}

	//WebDriver method
	 public void WebDriver(WebDriver driver, WebDriverWait wait, String baseUrl) {
		 if (init == true) { 
			 System.out.println("INSIDE SETUP");
			 //go to RD initial setup
			 driver.get(baseUrl);
			 WebDriver_Execute.log4j.info("New driver instantiated");
			 try {
			 	driver.findElement(By.xpath("//input[@value='Next']")).click();
			 } catch (TimeoutException te){
			 	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Next']")));
			 	driver.findElement(By.xpath("//input[@value='Next']")).click();
			 } catch (Exception e) {
			 	WebDriver_Execute.log4j.error("No 'Next' button element found");
			 	throw(e);
			 }
			 	WebDriver_Execute.log4j.info("Product configuration initiating");
			    //company name
			    driver.findElement(By.id("company-name")).clear();
			 try {
			    driver.findElement(By.id("company-name")).sendKeys(companyName);
			 } catch (TimeoutException te) {
			    wait.until( ExpectedConditions.elementToBeClickable(By.id("company-name")));
			    driver.findElement(By.id("company-name")).sendKeys(companyName);
			 } catch (Exception e) {
			 	WebDriver_Execute.log4j.error("No 'Next' button element found");
			 	throw(e);
			 }
			    
			 try {
			    driver.findElement(By.xpath("(//input[@value='Add'])[2]")).click();
			 } catch (TimeoutException te) {
			    wait.until( ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Add'])[2]")));
			    driver.findElement(By.xpath("(//input[@value='Add'])[2]")).click();
			 } catch (Exception e) {
			    WebDriver_Execute.log4j.error("Add button element not found");
			 	throw(e);
			 }
			    
			 //wait for element company to be added to the table
			 try {
		 		Thread.sleep(1000);
		 	} catch (InterruptedException e) {
		 		// TODO Auto-generated catch block
		 		WebDriver_Execute.log4j.error("sleep interrupted exception");
		 	}
		
			//matter path
			 	driver.findElement(By.name("global.matter.path")).clear();
			try {
			    driver.findElement(By.name("global.matter.path")).sendKeys(matterLocation);
			} catch (TimeoutException te) {
			    wait.until( ExpectedConditions.visibilityOfElementLocated(By.name("global.matter.path")));
			    driver.findElement(By.name("global.matter.path")).sendKeys(matterLocation);
			} catch (Exception e) {
			    WebDriver_Execute.log4j.error("Matter location input not found");
			 	throw(e);
			 } 
			    
			    try {
			    	driver.findElement(By.xpath("//td[@id='uid19-td-2']/div/form/div[3]/input[2]")).click();
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='uid19-td-2']/div/form/div[3]/input[2]")));
			    	driver.findElement(By.xpath("//td[@id='uid19-td-2']/div/form/div[3]/input[2]")).click();
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("Next button element not found");
			 		throw(e);
			 	}
			    
			    //set number of indexes (by size)
			    try {
			    	new Select(driver.findElement(By.name("index.count.small"))).selectByVisibleText(numSmallIndex);
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.name("index.count.small")));
			    	new Select(driver.findElement(By.name("index.count.small"))).selectByVisibleText(numSmallIndex);
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("small index element not found");
			 		throw(e);
			 	}
			    try {
			    	 new Select(driver.findElement(By.name("index.count.medium"))).selectByVisibleText(numMediumIndex);
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.name("index.count.medium")));
			    	 new Select(driver.findElement(By.name("index.count.medium"))).selectByVisibleText(numMediumIndex);
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("medium index element not found");
			 		throw(e);
			 	}
			    try {
			    	new Select(driver.findElement(By.name("index.count.large"))).selectByVisibleText(numLargeIndex);
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.name("index.count.large")));
			    	new Select(driver.findElement(By.name("index.count.large"))).selectByVisibleText(numLargeIndex);
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("large index element not found");
			 		throw(e);
			 	}
			   
			    
			    //enable index types
			    driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/div/div/div[2]/input")).clear();
			    
			    
			    try {
			    	driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/div/div/div[2]/input")).sendKeys(indexLocation);
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/table/tbody/tr/td/div/div/div[2]/input")));
			    	driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/div/div/div[2]/input")).sendKeys(indexLocation);
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("Index location input not found");
			 		throw(e);
			 	}
			    try {
			    	driver.findElement(By.xpath("//div/div/div/div[2]/input")).click();
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/div[2]/input")));
			    	driver.findElement(By.xpath("//div/div/div/div[2]/input")).click();
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("small index checkbox not found");
			 		throw(e);
			 	}
			    try {
			    	driver.findElement(By.xpath("//div/div/div/div[2]/input[2]")).click();
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/div[2]/input[2]")));
			    	driver.findElement(By.xpath("//input[2]")).click();
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("medium index checkbox not found");
			 		throw(e);
			 	}
			    try {
			    	driver.findElement(By.xpath("//input[3]")).click();
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/div[2]/input[3]")));
			    	driver.findElement(By.xpath("//div/div/div/div[2]/input[3]")).click();
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("Large index checkbox not found");
			 		throw(e);
			 	}
			    try {
			    	driver.findElement(By.xpath("//input[4]")).click();
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div/div[2]/input[4]")));
			    	driver.findElement(By.xpath("//div/div/div/div[2]/input[4]")).click();
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("EDA index checkbox not found");
			 		throw(e);
			 	}
			    
			    //finish setup
			    try {
			    	driver.findElement(By.xpath("//input[@value='Finish']")).click(); 
			    } catch (TimeoutException te) {
			    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Finish']")));
			    	driver.findElement(By.xpath("//input[@value='Finish']")).click();
			    } catch (Exception e) {
			    	WebDriver_Execute.log4j.error("Finish button element not found");
			    }
			    WebDriver_Execute.log4j.info("Product configuration finished");
			}//end if
		 }//end webdriver
}
