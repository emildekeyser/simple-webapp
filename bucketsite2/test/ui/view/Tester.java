package ui.view;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tester
{

	private ChromeDriver driver;
	private static final String url = "http://localhost:8080/1TX10_DeKeyserEmil/";

	@Before
	public void setUp() throws Exception
	{
		System.setProperty(
				"webdriver.chrome.driver",
				"/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception
	{
		driver.quit();
	}

	@Test
	public void test_index_show_calculated_value()
	{
		driver.get(url);
		
		WebElement avgValueP = driver.findElement(By.tagName("output"));
		try
		{
			assertTrue(Double.parseDouble(avgValueP.getText()) >= 0);
		}
		catch (Exception e)
		{
			fail(e.getMessage());
		}
	}
	
	@Test
	public void overview_is_generated()
	{
		driver.get(url + "servlet");
		
		List<WebElement> elements = driver.findElements(By.tagName("td"));
		assertTrue(elements.size() > 5); //er is meer als 1 item in de lijst
	}
	
	@Test
	public void form_adds_to_db()
	{
		String[] vals = {"tester", "tester", "10", "5", "tester"};
		
		driver.get(url + "voeg_toe.jsp");
		
		WebElement type = driver.findElement(By.id("type"));
		WebElement materiaal = driver.findElement(By.id("materiaal"));
		WebElement totale_inhoud = driver.findElement(By.id("totale_inhoud"));
		WebElement inhoud_gevuld = driver.findElement(By.id("inhoud_gevuld"));
		WebElement bevat = driver.findElement(By.id("bevat"));
		WebElement submit = driver.findElement(By.id("submit"));
		
		type.sendKeys(vals[0]);
		materiaal.sendKeys(vals[1]);
		totale_inhoud.sendKeys(vals[2]);
		inhoud_gevuld.sendKeys(vals[3]);
		bevat.sendKeys(vals[4]);
		submit.click();
		
		List<WebElement> lastRow = driver.findElements(By.tagName("tr"));
		lastRow = lastRow.get(lastRow.size() - 1).findElements(By.tagName("td"));
		assertEquals(vals.length, lastRow.size());
		
		vals[2] += "L"; 
		vals[3] += "L"; 
		for (int i = 0; i < vals.length; i++)
		{
			assertEquals(vals[i], lastRow.get(i).getText());
		}
	}

}





























