package testNG.concepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.postgresql.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGPractice {
	WebDriver driver;
	 
@BeforeMethod()
public void openBrowser( ) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Test
@Parameters({"url"})
public void getTitleOfPage(String url) {
	driver.get(url);
	String title = driver.getTitle();
	Assert.assertEquals(title, "TEK SCHOOL");
	
}
	
@AfterMethod
public void quit() {
	driver.quit();
}
	
	
	
	
	
	
	
}
