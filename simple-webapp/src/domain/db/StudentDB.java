package domain.db;
import java.util.ArrayList;
import domain.model.DomainException;
import domain.model.Student;

public class StudentDB
{
	public static final String DUBBELE_TOEVOEGING_SUFFIX = " staat al in de lijst.";

	ArrayList<Student> klasLijst;

	public StudentDB()
	{
		klasLijst = new ArrayList<Student>();
		Student student1 = new Student("Steegmans", "Elke", 16, "Vroedkunde");
		Student student2 = new Student("Jongen", "Greetje", 23, "Toegepaste Informatica");
		Student student3 = new Student("Van Hee", "Jan", 89, "Chemie");
		Student student4 = new Student("Melaerts", "Kristien", 89, "Chemie");
		voegToe(student1);
		voegToe(student2);
		voegToe(student3);
		voegToe(student4);
	}

	public void voegToe(Student student)
	{
		if (this.vind(student.getNaam(), student.getVoornaam()) != null)
		{
			throw new DomainException(student.getVoornaam() + " " + student.getNaam() + StudentDB.DUBBELE_TOEVOEGING_SUFFIX);
		}
		klasLijst.add(student);
	}

	public Student vind(String naam, String voornaam)
	{
		for (Student student : klasLijst)
		{
			if (student.heeftNaam(naam, voornaam))
			{
				return student;
			}
		}
		return null;
	}

	public ArrayList<Student> getKlas()
	{
		return this.klasLijst;
	}

	public void delete(String naam, String voornaam)
	{
		this.klasLijst.remove(this.vind(naam, voornaam));
	}

	public Student find(String naam)
	{
		for (Student student : klasLijst)
		{
			if (student.heeftNaam(naam))
			{
				return student;
			}
		}
		return null;
	}
}
