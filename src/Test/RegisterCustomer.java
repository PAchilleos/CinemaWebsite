package Test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegisterCustomer {

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

		// Link to Login page
		webDriver.findElement(By.cssSelector("#navbarResponsive > ul > li:nth-child(7) > a")).click();

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String text1 = webDriver
				.findElement(By.cssSelector("body > div > section > div > div > div.col-lg-5.mr-auto > div > h2"))
				.getText();
		Assert.assertEquals("Register", text1);

		WebElement field = webDriver.findElement(By.cssSelector(".registerall > p:nth-child(4) > input:nth-child(1)"));
		field.clear();
		field.sendKeys("First name");

		WebElement field2 = webDriver.findElement(By.cssSelector(".registerall > p:nth-child(5) > input:nth-child(1)"));
		field2.clear();
		field2.sendKeys("Password");

		WebElement field3 = webDriver.findElement(By.cssSelector("p.lead:nth-child(6) > input:nth-child(1)"));
		field3.clear();
		field3.sendKeys("Password");

		WebElement field4 = webDriver.findElement(By.cssSelector("p.lead:nth-child(7) > input:nth-child(1)"));
		field4.clear();
		field4.sendKeys("email1@address.com");

		webDriver.findElement(By.cssSelector("a.btn:nth-child(11) > span:nth-child(1)")).click();

		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@After
	public void aTest() {

		webDriver.quit();
	}

}