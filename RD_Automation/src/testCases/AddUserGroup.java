package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Main.WebDriver_Execute;

public class AddUserGroup {
	public AddUserGroup() {
		// TODO Auto-generated constructor stub
	}
	
	private static void WebDriver(WebDriver driver, WebDriverWait wait, String baseUrl) {
		driver.get(baseUrl);
	 	WebDriver_Execute.log4j.info("New driver instantiated");
	 	
	 	// Select Server
	 	try {
	 		driver.findElement(By.xpath("//div[@id='admin-button']/a/span")).click();
	 	} catch (TimeoutException te){
	 		wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='admin-button']/a/span")));
	 		driver.findElement(By.xpath("//div[@id='admin-button']/a/span")).click();
	 	} catch (Exception e) {
	 		WebDriver_Execute.log4j.error("");
	 		throw(e);
	 	}
	 	
	 	// click administration
	 	try {
	 		driver.findElement(By.xpath("//div[16]/div/div/div/ul/li[2]")).click();
	 	} catch (TimeoutException te){
	 		wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div[16]/div/div/div/ul/li[2]")));
	 		driver.findElement(By.xpath("//div[16]/div/div/div/ul/li[2]")).click();
	 	} catch (Exception e) {
	 		WebDriver_Execute.log4j.error("No 'Adminstration' button element found");
	 		throw(e);
	 	}
	 	
	 	// click 
	 	try {
	 	 	driver.findElement(By.xpath("//div[@id='sub-wrapper']/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/span")).click();
	 	} catch (TimeoutException te){
	 	 	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='sub-wrapper']/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/span")));
	 	 	driver.findElement(By.xpath("//div[@id='sub-wrapper']/div[2]/div/div/div[2]/div/div/div[3]/div/div[2]/span")).click();
	 	} catch (Exception e) {
	 	 	WebDriver_Execute.log4j.error("No 'Adminstration' button element found");
		 	throw(e);
	  	}
	 	
	 	try {
	 	 	driver.findElement(By.xpath("//div[3]/div/div/div/ul/li[6]")).click();
	 	} catch (TimeoutException te){
	 	 	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div/div/div/ul/li[6]")));
	 	 	driver.findElement(By.xpath("//div[3]/div/div/div/ul/li[6]")).click();
	 	} catch (Exception e) {
	 	 	WebDriver_Execute.log4j.error("No 'Adminstration' button element found");
		 	throw(e);
	  	}
	 	
	 	try {
	 	 	driver.findElement(By.xpath("//button")).click();
	 	} catch (TimeoutException te){
	 	 	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//button")));
	 	 	driver.findElement(By.xpath("//button")).click();
	 	} catch (Exception e) {
	 	 	WebDriver_Execute.log4j.error("No 'Adminstration' button element found");
		 	throw(e);
	  	}
	 	
	 	try {
	 	 	driver.findElement(By.xpath("//div[6]/div[2]/div/input")).sendKeys("DELETE");
	 	} catch (TimeoutException te){
	 	 	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//div[6]/div[2]/div/input")));
	 	 	driver.findElement(By.xpath("//div[6]/div[2]/div/input")).sendKeys("DELETE");
	 	} catch (Exception e) {
	 	 	WebDriver_Execute.log4j.error("No 'Adminstration' button element found");
		 	throw(e);
	  	}
	 	
	 	try {
	 	 	driver.findElement(By.xpath("//button[2]")).click();
	 	} catch (TimeoutException te){
	 	 	wait.until( ExpectedConditions.elementToBeClickable(By.xpath("//button[2]")));
	 	 	driver.findElement(By.xpath("//button[2]")).click();
	 	} catch (Exception e) {
	 	 	WebDriver_Execute.log4j.error("No 'Adminstration' button element found");
		 	throw(e);
	  	}

	}

}
