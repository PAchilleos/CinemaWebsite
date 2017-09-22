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

public class Meettheteam {

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

		// Link to Meet the team page
		webDriver.findElement(By.cssSelector("#navbarResponsive > ul > li:nth-child(8) > a")).click();

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String text1 = webDriver
				.findElement(By.cssSelector("body > div > header > div > h1"))
				.getText();
		Assert.assertEquals("Meet The Team", text1);
			
		
		//Link back to the homepage
		
		webDriver.findElement(By.cssSelector("#navbarResponsive > ul > li:nth-child(5) > a")).click();

		webDriver.manage().window().maximize();

		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String text2 = webDriver.findElement(By.cssSelector("body > div > header > div > div > h1")).getText();
		Assert.assertEquals("QA Cinema", text2);
	
		
	}

	@After
	public void aTest() {

		webDriver.quit();
	}

}