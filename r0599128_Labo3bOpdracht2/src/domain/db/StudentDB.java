package domain.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import domain.model.Student;

public class StudentDB implements Iterable<Student>
{
	private ArrayList<Student> studenten;
	private static StudentDB uniqueDB;

	private StudentDB()
	{
		this.studenten = new ArrayList<Student>();

		this.studenten.add(new Student("Jongen", "Greetje", 23, "Toegepaste Informatica"));
		this.studenten.add(new Student("Melaerts", "Kristien", 21, "Chemie"));
		this.studenten.add(new Student("Steegmans", "Elke", 16, "Vroedkunde"));
		this.studenten.add(new Student("Van Hee", "Jan", 18, "Verpleegkunde"));
	}
	
	public static StudentDB theDB()
	{
		if (uniqueDB == null)
		{
			uniqueDB = new StudentDB();
		}
		
		return uniqueDB;
	}
	
	public Student SearchStudent(String voornaam, String achternaam)
	{
		for (Student student : studenten)
		{
			if (student.getVoornaam() == voornaam && student.getAchternaam() == achternaam)
			{
				return student.Clone();
			}
		}
		
		return null;
	}

	@Override
	public Iterator<Student> iterator()
	{
		return new StudentIterator();
	}
	
	public class StudentIterator implements Iterator<Student>
	{
		private int i;

		public StudentIterator()
		{
			i = 0;
		}
		
		@Override
		public boolean hasNext()
		{
			return i < studenten.size();
		}

		@Override
		public Student next()
		{
			if (hasNext())
			{
				Student ret = studenten.get(i).Clone();
				i++;
				return ret;
			}
			throw new NoSuchElementException();
		}

	}

	public void add(Student newStudent)
	{
		this.studenten.add(newStudent);
	}
}
