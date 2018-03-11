package ui.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.model.FluidContainer;

/**
 * Servlet implementation class dbcontroller
 */
@WebServlet("/dbcontroller")
public class AddContainerToDB extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContainerToDB()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		FluidContainer newFluidConatiner = new FluidContainer();
		newFluidConatiner.setType(request.getParameter("type"));
		newFluidConatiner.setMaterial(request.getParameter("materiaal"));
		int capacity = 0, contents = 0;
		try
		{
			capacity = Integer.parseInt(request.getParameter("totale_inhoud"));
			contents = Integer.parseInt(request.getParameter("inhoud_gevuld"));
		}
		catch (Exception e){}
		newFluidConatiner.setCapacityInLiters(capacity);
		newFluidConatiner.setContentsInLiters(contents);
		newFluidConatiner.setContains(request.getParameter("bevat"));
		
		//db.add newFluidConatiner
		
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



//form action="AddContainerToDB" method="get">
//<label for="type">Type</label> 
//<input type="text" name="type" id="type"/>
//<!-- <select name="type" id="type">
//     <option value="placehold">placehold</option>
//     <option value="placehold">placehold</option>
//     <option value="placehold">placehold</option>
//     <option value="placehold">placehold</option>
//     <option value="placehold">placehold</option>
//</select> -->
//
// <label for="materiaal">Materiaal</label>
// <input type="text" name="materiaal" id="materiaal">
// 
// <label for="totale_inhoud">Totale Inhoud</label> 
// <input type="number" name="totale_inhoud" id="totale_inhoud">
// 
// <label for="inhoud_gevuld">Inhoud Gevuld</label> 
// <input type="number" name="inhoud_gevuld" id="inhoud_gevuld">
// 
// <label for="bevat">Bevat</label> 
// <input type="text" name="bevat" id="bevat">
//
// <input type="submit" value="Voeg toe">