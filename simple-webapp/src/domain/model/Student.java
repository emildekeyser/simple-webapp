package domain.model;

import java.util.ArrayList;

public class Student
{

	public static final String NAAM_LEEG = "Naam mag niet leeg zijn.";
	public static final String VOORNAAM_LEEG = "Voornaam mag niet leeg zijn";
	public static final String LEEFTIJD_GEEN_GETAL = "Leeftijd moet een getal zijn";
	public static final String LEEFTIJD_STRICT_POSITIEF = "Leeftijd moet strict positief zijn.";
	public static final String RICHTING_LEEG = "Richting mag niet leeg zijn.";

	private String naam;
	private String voornaam;
	private int leeftijd;
	private String studierichting;

	public Student()
	{
		this.naam = "";
		this.voornaam = "";
		this.leeftijd = 0;
		this.studierichting = "";
	}

	public Student(String naam, String voornaam, int leeftijd, String studierichting)
	{
		this.setNaam(naam);
		this.setVoornaam(voornaam);
		this.setLeeftijd(leeftijd);
		this.setStudierichting(studierichting);
	}

	public String getNaam()
	{
		return naam;
	}
	public void setNaam(String naam)
	{
		if (naam.isEmpty())
		{
			throw new DomainException(Student.NAAM_LEEG);
		}
		this.naam = naam;
	}
	public String getVoornaam()
	{
		return voornaam;
	}
	public void setVoornaam(String voornaam)
	{
		if (voornaam.isEmpty())
		{
			throw new DomainException(Student.VOORNAAM_LEEG);
		}
		this.voornaam = voornaam;
	}
	public int getLeeftijd()
	{
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd)
	{
		if (leeftijd <= 0)
		{
			throw new DomainException(Student.LEEFTIJD_STRICT_POSITIEF);
		}
		this.leeftijd = leeftijd;
	}
	public String getStudierichting()
	{
		return studierichting;
	}
	public void setStudierichting(String studierichting)
	{
		if (studierichting.isEmpty())
		{
			throw new DomainException(Student.RICHTING_LEEG);
		}
		this.studierichting = studierichting;
	}

	public String format()
	{
		return getNaam() + " " + getVoornaam() + " (" + getLeeftijd() + " jaar): " + getStudierichting();
	}

	public boolean heeftNaam(String naam, String voornaam)
	{
		return naam.equals(this.getNaam()) && voornaam.equals(this.getVoornaam());
	}

	public boolean heeftNaam(String naam)
	{
		return this.naam.equals(naam);
	}
	
	public Student clone()
	{
		Student s = new Student();
		s.setNaam(this.naam);
		s.setVoornaam(this.voornaam);
		s.setLeeftijd(this.leeftijd);
		s.setStudierichting(this.studierichting);
		return s;
	}
}
