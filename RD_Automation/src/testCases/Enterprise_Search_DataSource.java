package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Enterprise_Search_DataSource {
	private String name;
	private String dataSource;
	private String connectorType;
	
	//constructor
	public Enterprise_Search_DataSource (String name, String dataSource, String connectorType) {
		this.name = name;
		this.dataSource = dataSource;
		this.connectorType = connectorType;
	}
	
	public String getName(){
		return name;
	}
	
	public void WebDriver(WebDriver driver) throws InterruptedException{
			//add datasource
		    driver.findElement(By.xpath("//a[@id='add-data-sources-tooltip-btn']/span")).click();
		    //select connector from wij combobox
		    Thread.sleep(1000);
		    JavascriptExecutor des = (JavascriptExecutor) driver;
		    des.executeScript("return $('#dataSourcesTypes').wijcombobox({selectedIndex:"+connectorType+"}).get(0);");
		    driver.findElement(By.xpath("//button[@id='add-data-source-btn']")).click();
		    //switch to connector setup iframe
		    //for files
		    
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, '/x1d/web/local/admin/mountpoints/save-file.jsp')]")));
		    //insert file datasource info
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys(name);
		    driver.findElement(By.id("uri")).clear();
		    driver.findElement(By.id("uri")).sendKeys(dataSource);
		    driver.findElement(By.xpath("//button[@onclick='FileUtil.createMp()']")).click();
		    //switch back to main
		    driver.switchTo().defaultContent();    
	 }

}
