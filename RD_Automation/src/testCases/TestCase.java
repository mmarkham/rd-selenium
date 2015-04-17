package testCases;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {

	public TestCase() {
		// TODO Auto-generated constructor stub
	}
	
	public void WebDriver(WebDriver driver, WebDriverWait wait, String baseUrl){
		
	}
	
	public int getPropertiesCount() {
	    return getClass().getDeclaredFields().length;
	}
	
	public Field[] getProperties(){
		return getClass().getDeclaredFields();	
	}

}
