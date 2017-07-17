package DataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDT {

	WebDriver driver;
	
	
	@Test(dataProvider="wpData")
	public void loginWp(String username, String password) throws InterruptedException {
		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://dev-212.pantheonsite.io/wp-admin");
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		Thread.sleep(3000);
//		System.out.println(driver.getTitle());
		
		Assert.assertTrue(driver.getTitle().contains("Dashboard"), "User is not able to login - Invalid credentials");
		
		System.out.println("Page verified, login succesful");
		
//		driver.quit();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@DataProvider(name="wpData")
	public Object[][] passData() {
		
		Object[][] data = new Object[2][2];
		
		data[0][0]="andrew";
		data[0][1]="password";
		
		data[1][0]="user1";
		data[1][1]="pass1";
		
		return data;
		
	}

}
