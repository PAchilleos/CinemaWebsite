package Test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.support.ui.Select;

public class EmailOnAboutPage {

	private WebDriver webDriver;
	// private Wait<WebDriver> wait;

	@Before
	public void bTest() {

		webDriver = new ChromeDriver();

	}

	@Test
	public void Test() throws InterruptedException {

		// Open home page
		webDriver.navigate().to("https://pachilleos.github.io/CinemaWebsite/");

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String text1 = webDriver.findElement(By.cssSelector("body > div > header > div > div > h1")).getText();
		Assert.assertEquals("QA Cinema", text1);

		// Link to About page
		webDriver.findElement(By.cssSelector("#navbarResponsive > ul > li:nth-child(6) > a")).click();

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement field = webDriver.findElement(By.cssSelector("#fname"));
		field.clear();
		field.sendKeys("First name");

		WebElement field2 = webDriver.findElement(By.cssSelector("#lname"));
		field2.clear();
		field2.sendKeys("Last name");
		
		WebElement field3 = webDriver.findElement(By.cssSelector("#email"));
		field3.clear();
		field3.sendKeys("email1@address.com");
		
		
		Select dropdown = new Select(webDriver.findElement(By.cssSelector("#subject")));
		dropdown.selectByVisibleText("Other");
		
		WebElement field4 = webDriver.findElement(By.cssSelector("#textArea"));
		field4.clear();
		field4.sendKeys("Please let me know how I can review your cinema");		
		
		webDriver.findElement(By.cssSelector("#submit")).click();
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void aTest() {

		webDriver.quit();

	}

}
