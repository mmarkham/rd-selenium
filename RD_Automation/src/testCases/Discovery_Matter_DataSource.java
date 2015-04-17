package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Discovery_Matter_DataSource {
	private String name;
	private String dataSource;
	private String connectorType;
	  
	//constructor
	public Discovery_Matter_DataSource (String name, String dataSource, String connectorType) {
		this.name = name;
		this.dataSource = dataSource;
		this.connectorType = connectorType; 
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	  
	public void WebDriver(WebDriver driver){
		    driver.findElement(By.id("addDataSource")).click();
		    //add datasource modal
		    //select elements on  wij combobox
		    JavascriptExecutor ds = (JavascriptExecutor) driver;
		    ds.executeScript("return $('#modalAddDataSourceSelectCustodian').wijcombobox({selectedIndex:0}).get(0);");
		    ds.executeScript("return $('#modalAddDataSourceSelectDataSource').wijcombobox({selectedIndex:"+connectorType+"}).get(0);");
		    //configure
		    driver.findElement(By.xpath("(//button[@type='button'])[11]")).click();
		    //switch to connector setup iframe
		    //for files
		   
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/x1d/web/local/admin/mountpoints/save-')]")));
		    	//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/x1d/web/local/admin/mountpoints/save-file.jsp')]")));
		    		    
		        //insert file datasource info
		    driver.findElement(By.id("name")).clear();
		   	driver.findElement(By.id("name")).sendKeys(getName());
		   	driver.findElement(By.id("uri")).clear();
		   	driver.findElement(By.id("uri")).sendKeys(dataSource);
		   	driver.findElement(By.xpath("//button[@onclick='FileUtil.createMp()']")).click();
	    	driver.switchTo().defaultContent();	    
	  }
}
