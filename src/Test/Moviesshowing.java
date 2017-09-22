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

public class Moviesshowing {

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

		// Movies coming soon
		webDriver.findElement(By.cssSelector("body > div > section > div:nth-child(1) > ul > li:nth-child(3) > button")).click();

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String text2 = webDriver.findElement(By.cssSelector("body > div > section > div:nth-child(3) > div.row > div.col-lg-5.ml-auto > h2"))
				.getText();
		Assert.assertEquals("Films Coming Soon", text2);

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		// Movies now showing
		webDriver.findElement(By.cssSelector("body > div > section > div:nth-child(1) > ul > li.active > button")).click();

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String text3 = webDriver.findElement(By.cssSelector("body > div > section > div:nth-child(2) > div.row > div.col-lg-5.ml-auto > h2"))
				.getText();
		Assert.assertEquals("Films Showing", text3);

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	}

	@After
	public void aTest() {

		webDriver.quit();
		
//		webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	}

}
