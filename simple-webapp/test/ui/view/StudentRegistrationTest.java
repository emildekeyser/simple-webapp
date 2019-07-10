package ui.view;

import static org.junit.Assert.*;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import domain.db.StudentDB;
import domain.model.Student;

public class StudentRegistrationTest
{
	private WebDriver driver;
	private String url = "http://localhost:8080/Labo7_8_9_Studenten/";

	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();

	}

	@After
	public void tearDown() throws Exception
	{
		driver.quit();
	}

//	@Test
//	public void test_als_Lege_Student_Toegevoegd_Dan_Wordt_Formulier_Opnieuw_Getoond()
//	{
//		driver.get(url + "studentForm.jsp");
//		voegStudentToe("", "", 0, "");
//		assertEquals("Voeg een student toe", driver.getTitle());
//		assertEquals("Voeg een student toe", driver.findElement(By.tagName("h2")).getText());
//	}

	@Test
	public void test_StudentForm_alles_invullen_gaat_naar_overzicht_en_toont_nieuwe_student_in_tabel()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		voegStudentToe("Kemme" + rand, "Mieke", 18, "TI");
		assertEquals("Overzicht Studenten", driver.getTitle());
		assertEquals("Overzicht studenten", driver.findElement(By.tagName("h2")).getText());
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Kemme" + rand));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "Mieke"));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "18"));
		assertTrue(paginaBevatTdMetText(driver.findElements(By.tagName("td")), "TI"));
	}

	@Test
	public void test_als_student_gezocht_die_niet_toegevoegd_is_geeft_nietgevonden()
	{
		driver.get(url + "zoekForm.jsp");
		int rand = new Random().nextInt(999999);
		zoekStudent("x" + rand, "y" + rand);
		assertEquals("Niet gevonden", driver.getTitle());
		assertEquals("Helaas, de student waarnaar je vraagt is niet gevonden.", 
				driver.findElement(By.id("foutboodschap")).getText());

	}

	@Test
	public void test_student_uit_constructor_wordt_gevonden()
	{
		driver.get(url + "zoekForm.jsp");
		zoekStudent("Steegmans", "Elke");
		assertEquals("Gevonden", driver.getTitle());
		assertEquals("Je vroeg naar volgende gegevens: Steegmans Elke (16 jaar): Vroedkunde", 
				driver.findElement(By.id("boodschap")).getText());

	}

	@Test
	public void test_student_die_nieuw_toegevoegd_is_wordt_gevonden()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		voegStudentToe("Janssens " + rand, "Jan", rand, "BLT");
		driver.get(url + "zoekForm.jsp");
		zoekStudent("Janssens " + rand, "Jan");
		assertEquals("Gevonden", driver.getTitle());
		assertEquals("Je vroeg naar volgende gegevens: Janssens " 
				+ rand 
				+ " Jan (" 
				+ rand 
				+ " jaar): BLT", driver.findElement(By.id("boodschap")).getText());

	}

	@Test(expected = NoSuchElementException.class)
	public void wel_studenten_gevonden()
	{
		driver.get(url + "StudentInfo?command=overview");
		assertEquals("Overzicht Studenten", driver.getTitle());
		assertNull(driver.findElement(By.tagName("p")));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void deleteStudent()
	{
		driver.get(url + "studentForm.jsp");
		voegStudentToe("testnaam", "testvoornaam", 1, "test");
		
		driver.get(url + "StudentInfo?command=overview");
		WebElement student = driver.findElement(By.id("testnaam"));
		student.findElement(By.id("deletButton")).click();
		assertEquals("Confirm Delete", driver.getTitle());
		driver.findElement(By.id("deleteknop")).click();
		assertEquals("Overzicht Studenten", driver.getTitle());
		assertNull(driver.findElement(By.id("testnaam")));
	}
	
	// VALIDATIE
//	public static final String NAAM_LEEG = "Naam mag niet leeg zijn.";
//	public static final String VOORNAAM_LEEG = "Voornaam mag niet leeg zijn";
//	public static final String LEEFTIJD_GEEN_GETAL = "Leeftijd moet een getal zijn";
//	public static final String LEEFTIJD_STRICT_POSITIEF = "Leeftijd moet strict positief zijn.";
//	public static final String RICHTING_LEEG = "Richting mag niet leeg zijn.";
	
	@Test
	public void lege_naam_magni()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		voegStudentToe("", "Jan", rand, "BLT");
		WebElement errorlist = driver.findElement(By.className("errors"));
		assertNotNull(errorlist);
		List<WebElement> errors = errorlist.findElements(By.tagName("li"));
		assertNotNull(errors);
		assertTrue(errors.size() > 0);
		assertTrue(findError(errors, Student.NAAM_LEEG));
	}
	
	@Test
	public void lege_voornnaam_magni()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		voegStudentToe("PiederPolder" + rand, "", rand, "BLT");
		WebElement errorlist = driver.findElement(By.className("errors"));
		assertNotNull(errorlist);
		List<WebElement> errors = errorlist.findElements(By.tagName("li"));
		assertNotNull(errors);
		assertTrue(errors.size() > 0);
		assertTrue(findError(errors, Student.VOORNAAM_LEEG));
	}
	
	@Test
	public void leeftijd_waarde_is_brol()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		driver.findElement(By.id("naam")).sendKeys("Pattaten");
		driver.findElement(By.id("voornaam")).sendKeys("Boer" + rand);
		driver.findElement(By.id("leeftijd")).sendKeys("5 pattaten");
		driver.findElement(By.id("studierichting")).sendKeys("Landbouw");
		driver.findElement(By.id("bewaar")).click();
		WebElement errorlist = driver.findElement(By.className("errors"));
		assertNotNull(errorlist);
		List<WebElement> errors = errorlist.findElements(By.tagName("li"));
		assertNotNull(errors);
		assertTrue(errors.size() > 0);
		assertTrue(findError(errors, Student.LEEFTIJD_GEEN_GETAL));
	}
	
	@Test
	public void leeftijd_moet_strict_positief_zijn()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		voegStudentToe("PiederPolder" + rand, "JANPAN", -rand, "BLT");
		WebElement errorlist = driver.findElement(By.className("errors"));
		assertNotNull(errorlist);
		List<WebElement> errors = errorlist.findElements(By.tagName("li"));
		assertNotNull(errors);
		assertTrue(errors.size() > 0);
		assertTrue(findError(errors, Student.LEEFTIJD_STRICT_POSITIEF));
	}
	
	@Test
	public void righting_leeg_magni()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		voegStudentToe("PiederPolder" + rand, "JANPAN", rand, "");
		WebElement errorlist = driver.findElement(By.className("errors"));
		assertNotNull(errorlist);
		List<WebElement> errors = errorlist.findElements(By.tagName("li"));
		assertNotNull(errors);
		assertTrue(errors.size() > 0);
		assertTrue(findError(errors, Student.RICHTING_LEEG));
	}
	
	@Test
	public void dubbel_magni()
	{
		driver.get(url + "studentForm.jsp");
		voegStudentToe("PiederPolder", "JANPAN", 5, "aa");
		driver.get(url + "studentForm.jsp");
		voegStudentToe("PiederPolder", "JANPAN", 5, "aa");
		WebElement errorlist = driver.findElement(By.className("errors"));
		assertNotNull(errorlist);
		List<WebElement> errors = errorlist.findElements(By.tagName("li"));
		assertNotNull(errors);
		assertTrue(errors.size() > 0);
		assertTrue(findError(errors, StudentDB.DUBBELE_TOEVOEGING_SUFFIX));
	}
	
	@Test
	public void update()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		String naam = "Kemme" + rand;
		voegStudentToe(naam, "Mieke", 18, "TI");
		
		WebElement knop = driver.findElement(By.id(naam)).findElement(By.id("updateButton"));
		knop.click();
		
		assertEquals("Student Update Formulier", driver.getTitle());
		WebElement naamlabel = driver.findElement(By.id("naam"));
		WebElement voornaamInput = driver.findElement(By.id("voornaam"));
		WebElement leeftijdInput = driver.findElement(By.id("leeftijd"));
		WebElement studierichtingInput = driver.findElement(By.id("studierichting"));
		assertEquals(naam, naamlabel.getAttribute("value"));
		voornaamInput.clear();
		leeftijdInput.clear();
		studierichtingInput.clear();
		voornaamInput.sendKeys("MUUKE");
		leeftijdInput.sendKeys("2000");
		studierichtingInput.sendKeys("bobbelballel");
		driver.findElement(By.id("update")).click();
		
		WebElement updatedrow = driver.findElement(By.id(naam));
		assertNotNull(updatedrow);
		List<WebElement> tds = updatedrow.findElements(By.tagName("td"));
		assertTrue(paginaBevatTdMetText(tds, "MUUKE"));
		assertTrue(paginaBevatTdMetText(tds, "2000"));
		assertTrue(paginaBevatTdMetText(tds, "bobbelballel"));
	}
	
	@Test
	public void kan_update_cancel()
	{
		driver.get(url + "studentForm.jsp");
		int rand = new Random().nextInt(999999);
		String naam = "Kemme" + rand;
		voegStudentToe(naam, "Mieke", 18, "TI");
		WebElement knop = driver.findElement(By.id(naam)).findElement(By.id("updateButton"));
		knop.click();
		knop = driver.findElement(By.id("cancel"));
		assertNotNull(knop);
		knop.click();
		assertEquals("Overzicht Studenten", driver.getTitle());
	}
	
	// UTIL
	
	private boolean findError(List<WebElement> errors, String errorMsg)
	{
		for (WebElement er : errors)
		{
			if(er.getText().contains(errorMsg))
			{
				return true;
			}
		}
		return false;
	}
	
	private void voegStudentToe(String naam, String voornaam, int leeftijd, String studierichting)
	{
		driver.findElement(By.id("naam")).sendKeys(naam);
		driver.findElement(By.id("voornaam")).sendKeys(voornaam);
		driver.findElement(By.id("leeftijd")).sendKeys(leeftijd + "");
		driver.findElement(By.id("studierichting")).sendKeys(studierichting);
		driver.findElement(By.id("bewaar")).click();

	}

	private void zoekStudent(String naam, String voornaam)
	{
		driver.findElement(By.id("naam")).sendKeys(naam);
		driver.findElement(By.id("voornaam")).sendKeys(voornaam);
		driver.findElement(By.id("zoek")).click();
	}

	private boolean paginaBevatTdMetText(List<WebElement> tds, String tekst)
	{
		for (WebElement td : tds)
		{
			if (td.getText().equals(tekst))
			{
				return true;
			}
		}
		return false;
	}

}
