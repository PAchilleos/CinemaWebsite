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

public class HomeandAboutPages {

	private WebDriver webDriver;
//	private Wait<WebDriver> wait;

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

		String text2 = webDriver.findElement(By.cssSelector("#contact > div > div > div.col-lg-5.ml-auto > h2"))
				.getText();
		Assert.assertEquals("Contact Details", text2);

	}

	@After
	public void aTest() {

		webDriver.quit();
		
//		webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

}
