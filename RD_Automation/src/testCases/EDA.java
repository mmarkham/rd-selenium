package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EDA extends TestCase{
	private String edaName;
	private String edaDS;
	
	//constructor
	public EDA (String edaName, String edaDS) {
		this.setEdaName(edaName);
		this.edaDS = edaDS;
	}
	
	public String getEdaName() {
		return edaName;
	}
	
	public void setEdaName(String edaName) {
		this.edaName = edaName;
	}
	
	public void WebDriver(WebDriver driver){
		    driver.findElement(By.xpath("//div[@id='eda-ds-content']/div[2]/button")).click();
		    driver.findElement(By.id("name")).clear();
		    driver.findElement(By.id("name")).sendKeys(getEdaName());
		    driver.findElement(By.id("uri")).clear();
		    driver.findElement(By.id("uri")).sendKeys(edaDS);
		    driver.findElement(By.xpath("//button[@onclick=\"FileUtil.createMp('eda')\"]")).click();
		    driver.findElement(By.xpath("//div[@id='main-tabs-wrapper']/div[2]/a[3]/span")).click();
		    driver.findElement(By.linkText("Data Sources")).click();
	}
}
