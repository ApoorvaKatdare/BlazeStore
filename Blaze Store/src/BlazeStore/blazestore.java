package BlazeStore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class blazestore {
	
	public static WebDriver driver = null;
	@SuppressWarnings("deprecation")
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/apoorvakatdare/Desktop/BlazeStore/BrowserEXE/chromedriver");
		WebDriver driver = new ChromeDriver();
		
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
		//*[@id="post-24"]/div/div/div[2]/div/div/a
		//*[@id="post-24"]/div/div/div[2]/div/div/a
		
		
		
		WebElement Firstname = driver.findElement(By.id("billing_first_name"));
		Firstname.sendKeys("Apoorva");
		
		WebElement Lastname = driver.findElement(By.id("billing_last_name"));
		Lastname.sendKeys("Katdare");
		WebElement Companyname = driver.findElement(By.id("billing_company"));
		Companyname.sendKeys("My Company");
		//Select Country = new Select(driver.findElement(By.className("select2-selection select2-selection--single")));
		///Country.selectByVisibleText("India");
		WebElement StreetAddress1 = driver.findElement(By.id("billing_address_1"));
		StreetAddress1.sendKeys("B-11/16, Popular Nagar Warje");
		WebElement StreetAddress2 = driver.findElement(By.id("billing_address_2"));
		StreetAddress2.sendKeys("Near Bombay banglore bay pass");
		WebElement Town = driver.findElement(By.id("billing_city"));
		Town.sendKeys("Pune");
		//Select State = new Select(driver.findElement(By.className("select2-selection select2-selection--single")));
		//State.selectByVisibleText("Maharashtra");
		WebElement PinCode = driver.findElement(By.id("billing_postcode"));
		PinCode.sendKeys("411058");
		WebElement PhoneNumber = driver.findElement(By.id("billing_phone"));
		PhoneNumber.sendKeys("9200000111");
		WebElement EmailID = driver.findElement(By.id("billing_email"));
		EmailID.sendKeys("ask@gmail.com");
		WebElement OrderNotes = driver.findElement(By.id("order_comments"));
		OrderNotes.sendKeys("Send it by noon in week days");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='place_order']")));
		WebElement PlaceOrder = driver.findElement(By.xpath("//button[@id='place_order']"));
		PlaceOrder.submit();
		
		//driver.get("Thank you. Your order has been received.");
		driver.findElement(By.xpath("//th[contains(text(),'Payment method:')]"));
		
		if(driver.findElement(By.xpath("//td[contains(text(),'Cash on delivery')]")).getText().equals("Cash on delivery"))
		{
			System.out.println(" Order Placed with Cash on Delivery");
		}
		else
		{
			System.out.println("Order placed with differenct payment mode");
		}
		
		driver.close();
		
	
		
		
		
		

		//closing the browser
		//driver.close();
	}

}
