package BlazeStoreValidations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlazeStoreValidations {

	
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver","/Users/apoorvakatdare/Desktop/BlazeStore/BrowserEXE/chromedriver");
		this.driver = new ChromeDriver();
		
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();

		//open browser with desried URL
		driver.get("https://theblazestore.in");
		driver.findElement(By.xpath("//*[@id=\"post-100\"]/div/div[3]/ul/li[4]/a/div[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"product-52\"]/div[2]/form/button")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/a")).click();
		//WebDriverWait wait = new WebDriverWait(driver,05);
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Proceed to checkout')]")));
		// click on the Proceed button as soon as the "proceed" button is click able
		WebElement ProceedtoCheckOut = driver.findElement(By.xpath("//header/div[@id='ast-desktop-header']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[4]/a[1]"));
		ProceedtoCheckOut.click();
		WebElement PlaceOrder = driver.findElement(By.xpath("//button[@id='place_order']"));
		PlaceOrder.submit();
	}
	
	@Test
	public void pincodeValidation() {
	
		WebElement PinCode = driver.findElement(By.id("billing_postcode"));
		PinCode.sendKeys("");
		String errormsg = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/form[2]/div[1]/ul[1]/li[5]")).getText();
		String msg = "Billing PIN is a required field.";
		
		Assert.assertEquals(errormsg, msg);
		
	}
	
	@Test
	public void AddressValidation() {
		
		WebElement StreetAddress1 = driver.findElement(By.id("billing_address_1"));
		StreetAddress1.sendKeys("");
		String errormsg = driver.findElement(By.xpath("//body/div[@id='page']/div[@id='content']/div[1]/div[1]/main[1]/article[1]/div[1]/div[1]/form[2]/div[1]/ul[1]/li[3]")).getText();
		String msg = "Billing Street address is a required field.";
		
		Assert.assertEquals(errormsg, msg);
		
	}
	
	
	
	@AfterMethod
	public void close() {
		
		driver.quit();
	}
}
