package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quote")
public class QuoteServletError2 extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private List<String> quotes = new ArrayList<String>();

	public QuoteServletError2()
	{
		super();
		quotes.add(
				"Great is the art of beginning, but greater is the art of ending.");
		quotes.add("Love is like pi: natural, irrational, and very important.");
		quotes.add("If you're not confused, you're not paying attention.");
		quotes.add("Pick the flower when it is ready to be picked.");
		quotes.add("Only your real friends tell you when your face is dirty.");
		quotes.add(
				"I don't think much of a man who is not wiser today than he was yesterday.");
		quotes.add("Yes we can!");
		quotes.add("I Have a Dream");
		quotes.add("My work is a game, a very serious game.");
		quotes.add(
				"When you say, \'I wrote a program that crashed Windows,\' people just stare at you blankly and say, \'Hey, I got those with the system, for free.\'");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Quote</title>");
		out.println(
				"<link rel='stylesheet' href='css/sample.css' type='text/css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Quote of the moment ...</h1>");
		int position = getRandomPosition();
		String quote = quotes.get(position);
		out.println("<h2>" + quote + " </h2>");
		out.println("<p>");
		out.println("<a href='index.html'>Home</a>");
		out.println("</p>");
		out.println("</body>");
		out.println("</html>");
	}

	private int getRandomPosition()
	{
		Random random = new Random();
		return random.nextInt(quotes.size());
	}

}
