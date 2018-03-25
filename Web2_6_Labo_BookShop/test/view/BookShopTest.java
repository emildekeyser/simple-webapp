package view;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookShopTest
{
	private WebDriver driver;

	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/Web2_6_Labo_BookShop/");
	}

	@Test
	public void test()
	{

		WebElement calculateButton = driver.findElement(By.id("titel"));
		calculateButton.click();

		assertEquals("Course Info", driver.getTitle());
		driver.close();
	}

}
