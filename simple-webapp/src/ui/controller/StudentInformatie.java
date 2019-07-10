package ui.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.db.StudentDB;
import domain.model.DomainException;
import domain.model.Student;

@WebServlet("/StudentInfo")
public class StudentInformatie extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	StudentDB klas = new StudentDB();

	public StudentInformatie()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processCommmand(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		processCommmand(request, response);
	}

	protected void processCommmand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String param = request.getParameter("command");
		String command = param != null ? param : "home";
		String destination;
		
		switch (command)
		{
			case "home" :
				destination = "index.html";
				break;
			case "overview":
				destination = getOverview(request, response);
				break;
			case "add":
				destination = addStudent(request, response);
				break;
			case "find":
				destination = findStudent(request, response);
				break;
			case "deleteconfirm":
				destination = getConfirmationPage(request, response);
				break;
			case "delete":
				destination = deleteStudent(request, response);
				break;
			case "updateForm":
				destination = updateForm(request, response);
				break;
			case "update":
				destination = update(request, response);
				break;
			default :
				destination = "index.html";
				break;
		}
		
		request.getRequestDispatcher(destination).forward(request, response);
	}

	private String update(HttpServletRequest request, HttpServletResponse response)
	{
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String leeftijd = request.getParameter("leeftijd");
		String studierichting = request.getParameter("studierichting");
		Student studentToUpdate = this.klas.find(naam);
		
		if (studentToUpdate == null)
		{
			return "nietGevonden.jsp";
		}
		
		ArrayList<String> errors = new ArrayList<>();
		try {studentToUpdate.setVoornaam(voornaam);}
		catch (DomainException e) {errors.add(e.getMessage());}
		
		try {studentToUpdate.setLeeftijd(Integer.parseInt(leeftijd));}
		catch (NumberFormatException e) {errors.add(Student.LEEFTIJD_GEEN_GETAL);}
		catch (Exception e) {errors.add(Student.LEEFTIJD_STRICT_POSITIEF);}
		
		try {studentToUpdate.setStudierichting(studierichting);}
		catch (DomainException e) {errors.add(e.getMessage());}	
		
		if(errors.isEmpty())
		{
			return getOverview(request, response);
		}
		else
		{
			request.setAttribute("errors", errors);
			request.setAttribute("student", studentToUpdate);
			return "studentUpdateForm.jsp";
		}
	}

	private String updateForm(HttpServletRequest request, HttpServletResponse response)
	{
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		Student toUpdate = klas.vind(naam, voornaam);
		if (toUpdate == null)
		{
			return "nietGevonden.jsp";
		}
		else
		{
			request.setAttribute("student", toUpdate);
			return "studentUpdateForm.jsp";
		}
	}

	private String deleteStudent(HttpServletRequest request, HttpServletResponse response)
	{
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		if(klas.vind(naam, voornaam) == null)
		{
			return "nietGevonden.jsp";
		}
		else
		{
			klas.delete(naam, voornaam);
			return getOverview(request, response);
			
		}
	}

	private String getConfirmationPage(HttpServletRequest request, HttpServletResponse response)
	{
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		if (klas.vind(naam, voornaam) == null)
		{
			return "nietGevonden.jsp";
		}
		else
		{
			request.setAttribute("naam", naam);
			request.setAttribute("voornaam", voornaam);
			return "confirmationDialog.jsp";
		}
	}

	private String findStudent(HttpServletRequest request, HttpServletResponse response)
	{
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String ret;
		
		if (naam == null || voornaam == null)
		{
			ret = "nietGevonden.jsp";
		}
		else
		{
			Student student = klas.vind(naam, voornaam);
			if (student == null)
			{
				ret = "nietGevonden.jsp";
			}
			else
			{
				ret = "gevonden.jsp";
				request.setAttribute("student", student);
			}
		}
		return ret;
	}

	private String addStudent(HttpServletRequest request, HttpServletResponse response)
	{
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String leeftijd = request.getParameter("leeftijd");
		String studierichting = request.getParameter("studierichting");
		Student newStudent = new Student();
		ArrayList<String> errors = new ArrayList<>();
		
		try {newStudent.setNaam(naam);}
		catch (DomainException e) {errors.add(e.getMessage());}
		
		try {newStudent.setVoornaam(voornaam);}
		catch (DomainException e) {errors.add(e.getMessage());}

		try {newStudent.setLeeftijd(Integer.parseInt(leeftijd));}
		catch (NumberFormatException e) {errors.add(Student.LEEFTIJD_GEEN_GETAL);}
		catch (Exception e) {errors.add(Student.LEEFTIJD_STRICT_POSITIEF);}

		try {newStudent.setStudierichting(studierichting);}
		catch (DomainException e) {errors.add(e.getMessage());}	
		
		if(errors.isEmpty())
		{
			try
			{
				this.klas.voegToe(newStudent);
			}
			catch (Exception e)
			{
				errors.add(e.getMessage());
			}
		}
		
		if(errors.isEmpty())
		{
			return getOverview(request, response);
		}
		else
		{
			request.setAttribute("errors", errors);
			request.setAttribute("student", newStudent);
			request.setAttribute("leeftijd", leeftijd);
			return "studentForm.jsp";
		}
	}

	private String getOverview(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("studenten", klas.getKlas());
		return "studentOverview.jsp";
	}

}
