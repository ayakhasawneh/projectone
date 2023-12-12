package aya;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class second {
	String myWebSite = "https://www.saucedemo.com/";
	String UserName = "standard_user";
	String Password = "secret_sauce";
	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void mySetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		driver.get(myWebSite);
	}

	@Test()
	public void LoginTest() throws InterruptedException {
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginButton.click();
		

	}

	@Test(enabled = false)
	public void PrintTheNameOFTheFirstITems() {

		WebElement FirstItem = driver.findElement(By.cssSelector("a[id='item_4_title_link'] div[class='inventory_item_name ']"));

		String itemText = FirstItem.getText();

		System.out.println(itemText);
		
 
		
	}
	
	@Test()
	public void PrintTheNamesOfAllItems() {
		
		List<WebElement> allitems=	driver.findElements(By.className("inventory_item_name")); 
		
		//allitems.size();
	for(int i = 0 ; i < allitems.size();i++) {
		
		System.out.println(allitems.get(i).getText());
		
	}

	
	
	}

	@AfterTest
	public void AftermyTest() {
	}

}
