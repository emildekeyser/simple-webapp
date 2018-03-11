package ui.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.StudentDB;
import domain.model.Student;

/**
 * Servlet implementation class StudentInfo
 */
@WebServlet("/StudentInfo")
public class StudentInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentInfo()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String achternaam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		
		System.out.println("achternaam:");
		System.out.println(achternaam);
		System.out.println("voornaam:");
		System.out.println(voornaam);
		
		Student st = StudentDB.theDB().SearchStudent(voornaam, achternaam);
		
		if(st == null)
		{
			RequestDispatcher dispatch = request.getRequestDispatcher("nietgevonden.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			request.setAttribute("student", st);
			RequestDispatcher dispatch = request.getRequestDispatcher("gevonden.jsp");
			dispatch.forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{	
		Student newStudent = new Student();
		newStudent.setVoornaam(request.getParameter("voornaam"));
		newStudent.setAchternaam(request.getParameter("achternaam"));
		int leeftijd = 0;
		try
		{
			leeftijd = Integer.parseInt(request.getParameter("leeftijd"));
		}
		catch (Exception e)
		{
			leeftijd = 0;
		}
		newStudent.setLeeftijd(leeftijd);
		newStudent.setStudierichting(request.getParameter("richting"));
		
		boolean valid = !newStudent.getAchternaam().isEmpty();
		valid &= !newStudent.getVoornaam().isEmpty();
		valid &= newStudent.getLeeftijd() > 0;
		valid &= !newStudent.getStudierichting().isEmpty();
		
		if (valid)
		{
			StudentDB.theDB().add(newStudent);
			RequestDispatcher dispatch = request.getRequestDispatcher("overview.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatch = request.getRequestDispatcher("studentForm.jsp");
			dispatch.forward(request, response);
		}
	}

}
