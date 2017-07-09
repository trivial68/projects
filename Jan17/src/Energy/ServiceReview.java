package Energy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ServiceReview {
	public static WebDriver wd;
	
	public ServiceReview (WebDriver wd){
		ServiceReview.wd = wd;
	}
	
	@FindBy(how=How.CSS , using="h1")
	public static WebElement header;
	
	@FindBy(how=How.ID, using="firstName")
	public static WebElement firstName;

	@FindBy(how=How.NAME, using="lastName")
	public static WebElement lastName;

	@FindBy(how=How.NAME, using="address")
	public static WebElement address;

	@FindBy(how=How.NAME, using="city")
	public static WebElement city;

	@FindBy(how=How.NAME, using="state")
	public static WebElement state;

	@FindBy(how=How.NAME, using="zip")
	public static WebElement zip;

	@FindBy(how=How.NAME, using="email")
	public static WebElement email;

	@FindBy(how=How.ID, using="phone1")
	public static WebElement phone1;

	@FindBy(how=How.ID, using="phone2")
	public static WebElement phone2;

	@FindBy(how=How.ID, using="phone3")
	public static WebElement phone3;

	@FindBy(how=How.NAME, using="submitData")
	public static WebElement submitBtn;

	@FindBy(how=How.CLASS_NAME , using="redFont")
	public static WebElement errorMsg;

}
