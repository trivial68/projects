import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {

	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
	String username;
	
	@Before
	public void TestSetup() throws IOException {
		System.setProperty("webdrive.chrome.driver", "usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://dev-212.pantheonsite.io/wp-admin");
		wait = new WebDriverWait(driver, 1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@After
	public void TearDown() {
		driver.quit();
	}
	
	
	@Test
	public void Test1() throws IOException {
		File src = new File("/Users/Admin/Documents/Developer/QA/Automation/TestFrameworks/TestData/input.xls");
		FileInputStream input = new FileInputStream(src);
		workbook = new HSSFWorkbook(input);
		sheet = workbook.getSheetAt(0);
		
		//Login field
		cell = sheet.getRow(1).getCell(0);
		username = cell.getStringCellValue();
		driver.findElement(By.id("user_login")).sendKeys(username);			
		//Password field
		cell = sheet.getRow(1).getCell(1);
		driver.findElement(By.id("user_pass")).sendKeys(cell.getStringCellValue());
		driver.findElement(By.id("wp-submit")).click();
		//Message to be written
		String message;
		message = driver.findElement(By.id("wp-admin-bar-my-account")).getText();
		//Cell to write
		sheet.getRow(1).createCell(2).setCellValue(message);
		FileOutputStream fileOutput = new FileOutputStream(src);	
		workbook.write(fileOutput);
		driver.get("http://dev-212.pantheonsite.io/wp-login.php?action=logout&_wpnonce=9308979fde");
		driver.close();			
		fileOutput.close();
	}
	
	@Test
	public void Test2() throws IOException {
		File src = new File("/Users/Admin/Documents/Developer/QA/Automation/TestFrameworks/TestData/input.xls");
		FileInputStream input = new FileInputStream(src);
		workbook = new HSSFWorkbook(input);
		sheet = workbook.getSheetAt(0);
		
		//Login field
		cell = sheet.getRow(2).getCell(0);
		username = cell.getStringCellValue();
		driver.findElement(By.id("user_login")).sendKeys(username);			
		//Password field
		cell = sheet.getRow(2).getCell(1);
		driver.findElement(By.id("user_pass")).sendKeys(cell.getStringCellValue());
		driver.findElement(By.id("wp-submit")).click();
		//Message to be written
		String message;
		message = driver.findElement(By.id("wp-admin-bar-my-account")).getText();
		//Cell to write
		sheet.getRow(2).createCell(2).setCellValue(message);
		FileOutputStream fileOutput = new FileOutputStream(src);	
		workbook.write(fileOutput);
		driver.get("http://dev-212.pantheonsite.io/wp-login.php?action=logout&_wpnonce=9308979fde");
		driver.close();			
		fileOutput.close();
	}
	
	@Test
	public void Test3() throws IOException {
		File src = new File("/Users/Admin/Documents/Developer/QA/Automation/TestFrameworks/TestData/input.xls");
		FileInputStream input = new FileInputStream(src);
		workbook = new HSSFWorkbook(input);
		sheet = workbook.getSheetAt(0);
		
		//Login field
		cell = sheet.getRow(3).getCell(0);
		username = cell.getStringCellValue();
		driver.findElement(By.id("user_login")).sendKeys(username);			
		//Password field
		cell = sheet.getRow(3).getCell(1);
		driver.findElement(By.id("user_pass")).sendKeys(cell.getStringCellValue());
		driver.findElement(By.id("wp-submit")).click();
		//Message to be written
		String message;
		message = driver.findElement(By.id("wp-admin-bar-my-account")).getText();
		//Cell to write
		sheet.getRow(3).createCell(2).setCellValue(message);
		FileOutputStream fileOutput = new FileOutputStream(src);	
		workbook.write(fileOutput);
		driver.get("http://dev-212.pantheonsite.io/wp-login.php?action=logout&_wpnonce=9308979fde");
		driver.close();			
		fileOutput.close();
	}
}
