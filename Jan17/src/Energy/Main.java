package Energy;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Main {

	public static WebDriver wd;
	public static String URL = "http://www.energy-telecom.portnov.com/ServiceReview/quote.php";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		wd = new FirefoxDriver();
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		wd.close();
	}

	@Before
	public void setUp() throws Exception {
		wd.get(URL);
		PageFactory.initElements(wd, ServiceReview.class);
		assertEquals("Energy-Telecom Service Review", ServiceReview.header.getText());
	}

	@After
	public void tearDown() throws Exception {
		//wd.close();
	}

	@Test
	public void validInfo() throws InterruptedException {
		ServiceReview.firstName.sendKeys("John");
		ServiceReview.lastName.sendKeys("Doe");
		ServiceReview.address.sendKeys("123 Flower st.");
		ServiceReview.city.sendKeys("Albuquerke");
		ServiceReview.state.sendKeys("CA");
		ServiceReview.zip.sendKeys("94040");
		ServiceReview.email.sendKeys("1@2.com");
		ServiceReview.phone1.sendKeys("650");
		ServiceReview.phone2.sendKeys("234");
		ServiceReview.phone3.sendKeys("0000");
		ServiceReview.submitBtn.click();
	}
	
	@Test
	public void invalidInfo1() throws InterruptedException {
		ServiceReview.firstName.sendKeys("John");
		ServiceReview.lastName.sendKeys("Doe");
		ServiceReview.address.sendKeys("123 Flower st.");
		ServiceReview.city.sendKeys("Albuquerke");
		ServiceReview.state.sendKeys("CA");
		ServiceReview.zip.sendKeys("94040");
		ServiceReview.email.sendKeys("1@2.com");
		ServiceReview.phone1.sendKeys("000");
		ServiceReview.phone2.sendKeys("234");
		ServiceReview.phone3.sendKeys("0000");
		ServiceReview.submitBtn.click();
		assertEquals("* Please enter a valid Phone Number", ServiceReview.errorMsg.getText());
	}
	
	@Test
	public void invalidInfo2() throws InterruptedException {
		ServiceReview.firstName.sendKeys("");
		ServiceReview.lastName.sendKeys("Doe");
		ServiceReview.address.sendKeys("123 Flower st.");
		ServiceReview.city.sendKeys("Albuquerke");
		ServiceReview.state.sendKeys("CA");
		ServiceReview.zip.sendKeys("94040");
		ServiceReview.email.sendKeys("1@2.com");
		ServiceReview.phone1.sendKeys("650");
		ServiceReview.phone2.sendKeys("234");
		ServiceReview.phone3.sendKeys("0000");
		ServiceReview.submitBtn.click();
		assertEquals("* Please enter your First Name", ServiceReview.errorMsg.getText());

	}
	
	@Test
	public void invalidInfo3() throws InterruptedException {
		ServiceReview.firstName.sendKeys("John");
		ServiceReview.lastName.sendKeys("Doe");
		ServiceReview.address.sendKeys("");
		ServiceReview.city.sendKeys("Albuquerke");
		ServiceReview.state.sendKeys("CA");
		ServiceReview.zip.sendKeys("94040");
		ServiceReview.email.sendKeys("1@2.com");
		ServiceReview.phone1.sendKeys("650");
		ServiceReview.phone2.sendKeys("234");
		ServiceReview.phone3.sendKeys("0000");
		ServiceReview.submitBtn.click();
		assertEquals("* Please enter your Street Address", ServiceReview.errorMsg.getText());

	}
	
	@Test
	public void invalidInfo4() throws InterruptedException {
		ServiceReview.firstName.sendKeys("John");
		ServiceReview.lastName.sendKeys("Doe");
		ServiceReview.address.sendKeys("123 Flower st.");
		ServiceReview.city.sendKeys("Albuquerke");
		ServiceReview.state.sendKeys("CA");
		ServiceReview.zip.sendKeys("94040");
		ServiceReview.email.sendKeys("eee");
		ServiceReview.phone1.sendKeys("650");
		ServiceReview.phone2.sendKeys("234");
		ServiceReview.phone3.sendKeys("0000");
		ServiceReview.submitBtn.click();
		assertEquals("* Please enter a valid Email address (e.g., mymail@test.com)", ServiceReview.errorMsg.getText());

	}
	
	@Test
	public void invalidInfo5() throws InterruptedException {
		ServiceReview.firstName.sendKeys("John");
		ServiceReview.lastName.sendKeys("Doe");
		ServiceReview.address.sendKeys("123 Flower st.");
		ServiceReview.city.sendKeys("Albuquerke");
		ServiceReview.state.sendKeys("CA");
		ServiceReview.zip.sendKeys("94040");
		ServiceReview.email.sendKeys("1@2.com");
		ServiceReview.phone1.sendKeys("kkk");
		ServiceReview.phone2.sendKeys("234");
		ServiceReview.phone3.sendKeys("0000");
		ServiceReview.submitBtn.click();
		assertEquals("* Please enter your Phone Number", ServiceReview.errorMsg.getText());
	}
}
