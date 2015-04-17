package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Main.WebDriver_Execute;

public class Discovery_Matter extends TestCase {
		  private String name;
		  private String custodianUser;
		  private String custodianFirst;
		  private String custodianLast;
		  private String custodiansImport;
		  private String dataSourcesImport;
		  private Discovery_Matter_DataSource dataSourceEDM;
		  private EDA eda;
		  private String criteria;
		  
		  //constructor
		  public Discovery_Matter (String name, String custodianUser, String custodianFirst, String custodianLast, String custodiansImport, String dataSourcesImport, Discovery_Matter_DataSource dataSourceEDM, String criteria, EDA eda){
			this.setName(name);
			this.custodiansImport = custodiansImport;
			this.dataSourcesImport = dataSourcesImport;
			this.criteria = criteria;
			this.dataSourceEDM= dataSourceEDM;
			this.eda = eda;
			this.custodianUser = custodianUser;
			this.custodianFirst = custodianFirst;
		    this.custodianLast = custodianLast;	
		  }
		  
		  public void WebDriver(WebDriver driver, WebDriverWait wait, String baseUrl){
			        WebDriver_Execute.log4j.info("Matter creation started");
			        //go to matter setup
			        try {
			        	driver.get(baseUrl + "/web/global/matters/create.jsp");
			        } catch (Exception e) {
			        	WebDriver_Execute.log4j.error("Unable to go to the matter creation page (baseUrl + /web/global/matters/create.jsp)");
			        }
				    
				    //eDM wizard
				  //select category
			        try {
			        	driver.findElement(By.xpath("(//a[contains(text(),'select')])[1]")).click(); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'select')])[1]")));
				    	driver.findElement(By.xpath("(//a[contains(text(),'select')])[1]")).click();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("category button element not found");
				    }
				    
				    //select company
			        try {
			        	driver.findElement(By.xpath("(//a[contains(text(),'select')])[6]")).click(); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(text(),'select')])[6]")));
				    	driver.findElement(By.xpath("(//a[contains(text(),'select')])[6]")).click();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Company button element not found");
				    }
				    
				    //name the eDM
				    
				    try {
				    	 driver.findElement(By.name("name")).clear();
						 driver.findElement(By.name("name")).sendKeys(getName()); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.name("name")));
				    	 driver.findElement(By.name("name")).clear();
						 driver.findElement(By.name("name")).sendKeys(getName());
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("eDM name input element not found");
				    }
				    try {
				    	driver.findElement(By.name("mySubmit")).click(); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.elementToBeClickable(By.name("mySubmit")));
				    	driver.findElement(By.name("mySubmit")).click();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("mySubmit button element not found");
				    }
				    //wait for eDM setup and click continue when it is visible
				    try {
				    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));
				    	driver.findElement(By.linkText("Continue")).click(); 
				    } catch (TimeoutException te) {
				    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));
					    driver.findElement(By.linkText("Continue")).click();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Continue button element not found");
				    }
				    
				    try {
				    driver.switchTo().defaultContent();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Could not switch to default content");
				    }
				    //wait for and click on custodians page
				    /* 
				    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='wizardMain']/div[2]/a[3]/span")));
				    JavascriptExecutor wijWiz = (JavascriptExecutor) driver;
				    //go to third item in the wijwizard (custodians), index starts at 0
				    wijWiz.executeScript("$(\"#wizardMain\").wijwizard(\"show\", 2);");
				    */
				    
				    //driver.findElement(By.xpath("//ul[@id='listContainer']/li[3]")).click();
				    JavascriptExecutor wijWiz = (JavascriptExecutor) driver;
				    if (custodianUser != null && !custodianUser.isEmpty() && custodianFirst != null && !custodianFirst.isEmpty() 
				    		&& custodianLast != null && !custodianLast.isEmpty()){
				    //add custodian
				    try {
					    wijWiz.executeScript("X1.currentViewModel.wizard.custodians.onAddCustodianClick();");
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Script could not be executed (add custodian click)");
				    }
					//driver.switchTo().frame(driver.findElement(By.id("modalAddCustodians")));
				    //driver.findElement(By.id("addCustodian")).click();
				    try {
				    	driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div/input")).clear();
					    driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div/input")).sendKeys(custodianUser); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalAddCustodians']/div/div/input")));
				    	driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div/input")).clear();
					    driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div/input")).sendKeys(custodianUser);
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Custodian username input element not found");
				    }
				    try {
				    	driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[3]/input")).clear();
					    driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[3]/input")).sendKeys(custodianFirst); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalAddCustodians']/div/div[3]/input")));
				    	driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[3]/input")).clear();
					    driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[3]/input")).sendKeys(custodianFirst);
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Custodian First Name input element not found");
				    }
				    
				    try {
				    	driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[4]/input")).clear();
					    driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[4]/input")).sendKeys(custodianLast);
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modalAddCustodians']/div/div[4]/input")));
				    	driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[4]/input")).clear();
					    driver.findElement(By.xpath("//div[@id='modalAddCustodians']/div/div[4]/input")).sendKeys(custodianLast);
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Custodian Last Name input element not found");
				    }
				    try {
				    	driver.findElement(By.xpath("(//button[@type='button'])[7]")).click(); 
				    } catch (TimeoutException te) {
				    	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[7]")));
				    	driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("create custodian button element not found");
				    }
				    try {
				    	driver.switchTo().defaultContent();
				    } catch (Exception e) {
				    	WebDriver_Execute.log4j.error("Could not switch from frame to default content");
				    }
				    } //end if
				    
				    if (custodiansImport != null && !custodiansImport.isEmpty()) {
				    //import custodian
				   
				    wijWiz.executeScript("X1.currentViewModel.wizard.custodians.onImportCustodiansClick();");	
				    //driver.findElement(By.id("importCustodians")).click();
				    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/x1d/web/local/admin/custodians/import-xls.jsp')]")));
				    driver.findElement(By.name("file")).sendKeys(custodiansImport);
				    driver.findElement(By.xpath("//input[@value='Import']")).click();
				    driver.findElement(By.xpath("//a[@id='createNewCompany']/span")).click();
				    //switch back to main
				    driver.switchTo().defaultContent();
				    }
				    //go to datasource page 
				    driver.findElement(By.xpath("//ul[@id='listContainer']/li[4]")).click();
				    if (dataSourcesImport != null && !dataSourcesImport.isEmpty()) {
				    driver.findElement(By.id("importDataSource")).click();
				    //import datasources
				    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/x1d/web/local/admin/mountpoints/import-xls.jsp')]")));
				    driver.findElement(By.name("file")).sendKeys(dataSourcesImport);
				    driver.findElement(By.xpath("//input[@value='Import']")).click();
				    driver.findElement(By.xpath("//a[@id='createNewCompany']/span")).click();
				    //switch back to main
				    driver.switchTo().defaultContent();
				  //wait for grid to update with datasource
				    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='dataSourcesGridContainer']/tbody/tr/td[3]/div")));
				    }
				    //add datasource
				    if (dataSourceEDM.getName() != null && !dataSourceEDM.getName().isEmpty()){
				    dataSourceEDM.WebDriver(driver);
				    }
				    
				    //finish!
				    driver.findElement(By.xpath("//div[@id='wizardMain']/div[2]/a[3]/span")).click();
				    //end of wizard
				    driver.findElement(By.xpath("//button[@type='button']")).click();
				    //create criteria
				    driver.findElement(By.linkText("Criteria")).click();
				    driver.findElement(By.xpath("//div[@id='sub-wrapper']/div[3]/button")).click();
				    driver.findElement(By.id("name")).clear();
				    driver.findElement(By.id("name")).sendKeys(criteria);
				    driver.findElement(By.name("mySubmit")).click();
				    driver.findElement(By.xpath("//div[@id='main-tabs-wrapper']/div[2]/a[5]/span")).click();
				    //create eda
				    if (eda.getEdaName() != null && !eda.getEdaName().isEmpty()){
				    	eda.WebDriver(driver);
				    }
				    WebDriver_Execute.log4j.info("Matter creation finished");
			  }

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		  
} // class

