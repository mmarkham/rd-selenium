package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Enterprise_Search {
	private String name;
	private String dataSourcesImport;
	private Enterprise_Search_DataSource dataSourceES;
	private String criteria;
	
	//constructor
	public Enterprise_Search (String name, String dataSourcesImport, Enterprise_Search_DataSource dataSourcesES, String criteria) {
      this.name = name;
      this.dataSourcesImport = dataSourcesImport;
      this.dataSourceES = dataSourcesES;
      this.criteria = criteria;
	}

	public void WebDriver(WebDriver driver, WebDriverWait wait, String baseUrl) throws InterruptedException { 
		  	driver.get(baseUrl + "/web/global/es/create.jsp");
		  	//select category
		    driver.findElement(By.xpath("(//a[contains(text(),'select')])[1]")).click();
		    //select company
		    driver.findElement(By.xpath("(//a[contains(text(),'select')])[6]")).click();
		    driver.findElement(By.name("name")).clear();
		    driver.findElement(By.name("name")).sendKeys(name);
		    driver.findElement(By.name("mySubmit")).click();
		    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));
		    driver.findElement(By.linkText("Continue")).click();
		    driver.findElement(By.linkText("Data Sources")).click();
		    //import datasources
		    driver.findElement(By.xpath("//a[@id='import-data-sources']/span")).click();
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/x1d/web/local/admin/mountpoints/import-xls.jsp')]")));
		    driver.findElement(By.name("file")).sendKeys(dataSourcesImport);
		    driver.findElement(By.xpath("//input[@value='Import']")).click();
		    driver.findElement(By.xpath("//a[@id='createNewCompany']/span")).click();
		    //switch back to main
		    driver.switchTo().defaultContent();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@id='dataSourcesGrid']/tbody/tr/td/div")));
		  //wait for datasource to show up in the grid
		    //add datasource
		    if (dataSourceES.getName() != null && !dataSourceES.getName().isEmpty()) {
		    dataSourceES.WebDriver(driver);
		    }   
		        driver.findElement(By.xpath("//a[contains(text(),'Refresh')]")).click();
		        //enable distribution
		    	driver.findElement(By.xpath("//a[@id='actions-data-sources-tooltip-btn']")).click();
		    	driver.findElement(By.xpath("//li[@id='toolTip-enableAll']/a/span[2]")).click();
		    	//create criteria
		    	driver.findElement(By.linkText("Criteria")).click();
		    	driver.findElement(By.xpath("//div[@id='sub-wrapper']/div[3]/button")).click();
		    	driver.findElement(By.id("name")).clear();
		    	driver.findElement(By.id("name")).sendKeys(criteria);
		    	driver.findElement(By.name("mySubmit")).click();
		    	//go back to DS page
		    	driver.findElement(By.linkText("Data Sources")).click();
		    	driver.findElement(By.id("selectedMainTab")).click();
		   
	  }

}
