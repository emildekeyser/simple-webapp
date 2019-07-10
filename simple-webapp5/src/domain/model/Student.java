package domain.model;

public class Student
{
	private String voornaam;
	private String achternaam;
	private int leeftijd;
	private String studierichting;
	
	public Student(String achternaam, String voornaam, int leeftijd,
			String studierichting)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.leeftijd = leeftijd;
		this.studierichting = studierichting;
	}
	
	public Student()
	{
		this("", "", 0, "");
	}
	
	public String getVoornaam()
	{
		return voornaam;
	}
	public void setVoornaam(String voornaam)
	{
		this.voornaam = voornaam;
	}
	public String getAchternaam()
	{
		return achternaam;
	}
	public void setAchternaam(String achternaam)
	{
		this.achternaam = achternaam;
	}
	public int getLeeftijd()
	{
		return leeftijd;
	}
	public void setLeeftijd(int leeftijd)
	{
		this.leeftijd = leeftijd;
	}
	public String getStudierichting()
	{
		return studierichting;
	}
	public void setStudierichting(String studierichting)
	{
		this.studierichting = studierichting;
	}
	
	public Student Clone()
	{
		return new Student(this.getAchternaam(), this.getVoornaam(), this.getLeeftijd(), this.getStudierichting());
	}
}
