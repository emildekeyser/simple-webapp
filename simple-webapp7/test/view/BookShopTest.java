package view;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookShopTest
{
	private WebDriver driver;
	private static final String url = "http://localhost:8080/Web2_6_Labo_BookShop/";

	@Before
	public void setUp() throws Exception
	{
		System.setProperty(
				"webdriver.chrome.driver",
				"/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void test_we_can_enter_page()
	{

		driver.get(url);
		assertEquals("Book Info", driver.getTitle());
	}

	@Test
	public void test_empty_form_gives_error_msg_in_first_p()
	{

		driver.get(url);

		WebElement calculateButton = driver.findElement(By.id("calculate"));
		calculateButton.click();

		assertEquals(
				"Vul alle velden in.",
				driver.findElement(By.tagName("p")).getText());
	}

	@Test
	public void test_filling_form_correctly_gives_correct_result_page()
	{
		driver.get(url);

		WebElement titleField = driver.findElement(By.id("title"));
		titleField.sendKeys("Alles Komt Goed");

		WebElement priceField = driver.findElement(By.id("price"));
		priceField.sendKeys("10");

		WebElement numberField = driver.findElement(By.id("number"));
		numberField.sendKeys("7");

		WebElement calculateButton = driver.findElement(By.id("calculate"));
		calculateButton.click();
		
		assertEquals("Book", driver.getTitle());
		assertEquals(
				"Voor 7 exemplaren van het boek Alles Komt Goed moet je €70 betalen.",
				driver.findElement(By.tagName("p")).getText());
	}

	@After
	public void clean()
	{
		driver.close();
	}

}
