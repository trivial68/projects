import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaseStudyDownload {

	WebDriver driver;
	WebDriverWait wait;
	String Name;
	String Surname;
	String Company;
	String Email;
	String Phone;
	String Industry;
	
	@Before
	public void Setup() {
		System.setProperty("webdrive.chrome.driver", "usr/local/bin/chromedriver");
		driver = new ChromeDriver();
//		driver.get("http://www.kenandy.com/resources/case-studies/");
		driver.get("http://clouderp.kenandy.com/062016KenandyCS_DelMonte_Download.html?Source=Website&?Sub-Source=Asset%20Download&Source-Detail=2016%20Case%20Study%20-%20Del%20Monte%20Website");
		wait = new WebDriverWait(driver, 2);
	}
	
	@After
	public void TearDown() {
      driver.quit();
	}
	
	@Test
	public void Test1() {
		Name = "1";
		Surname = "1";
		Company = "1";
		Email = "1@2.com";
		Phone = "1";
		Industry = "Automotive";
		
//		driver.findElement(By.xpath("//*[@id='content']/section/div/div/div/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("FirstName")).sendKeys(Name);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("LastName")).sendKeys(Surname);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("Company")).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("Email")).sendKeys("1@2.com");
		driver.findElement(By.id("Phone")).sendKeys("1");
		driver.findElement(By.id("Industry")).sendKeys("Automotice");
		driver.findElement(By.className("mktoButton")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("here")).click();
		
	}
}
