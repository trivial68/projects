package DataDriven;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WPLogin {

	@Test
	public void loginWp() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://dev-212.pantheonsite.io/wp-login.php?redirect_to=http%3A%2F%2Fdev-212.pantheonsite.io%2Fwp-admin%2F&reauth=1");
	}
}
