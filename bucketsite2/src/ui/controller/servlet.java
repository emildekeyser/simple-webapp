package ui.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.db.FluidContainerDB;
import domain.model.FluidContainer;

/**
 * Servlet implementation class dbcontroller
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private FluidContainerDB db = new FluidContainerDB();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servlet()
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
		
		if (request.getParameter("cmd").equals("overzicht"))
		{
			request.setAttribute("db", db);
			request.getRequestDispatcher("overzicht.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("db", db.getContainers());
			request.getRequestDispatcher("tabel.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{	
		String type = request.getParameter("type");
		String material = request.getParameter("materiaal");
		String capacity = request.getParameter("totale_inhoud");
		String contents = request.getParameter("inhoud_gevuld");
		String contains = request.getParameter("bevat");
		String bodStr = request.getParameter("bod");
		
		boolean fail = type.isEmpty()
				|| material.isEmpty()
				|| capacity.isEmpty()
				|| contents.isEmpty()
				|| contains.isEmpty()
				|| bodStr.isEmpty();
		
		if (fail)
		{
			RequestDispatcher dispatch = request.getRequestDispatcher("voeg_toe.jsp");
			dispatch.forward(request, response);
		}
		else
		{
			int cap = 0, cont = 0, bod = 0;
			try
			{
				cap = Integer.parseInt(capacity);
				cont = Integer.parseInt(contents);
				bod = Integer.parseInt(bodStr);
			}
			catch (Exception e){}
			
			if (FluidContainer.geldigBod(bod))
			{
				FluidContainer flc = new FluidContainer(type, material, cap, cont, contains, bod);
				this.db .addContainer(flc);
				this.doGet(request, response);
			}
			else
			{
				request.setAttribute("bod", bod);
				request.getRequestDispatcher("teKleinBod.jsp").forward(request, response);
			}
			
		}
	}

}
