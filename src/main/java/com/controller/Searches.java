package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Model.Search;



/**
 * Servlet implementation class Search
 */
public class Searches extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @Override
	    public void service (HttpServletRequest req, HttpServletResponse resp) throws IOException {
	        Search.date = req.getParameter("date");
	        Search.source = req.getParameter("source");
	        Search.destination = req.getParameter("destination");
	        Search.persons = Integer.parseInt(req.getParameter("persons"));
	        System.out.println(Search.destination);

	        if (Search.date.equals("")) {
	            PrintWriter out = resp.getWriter();
	            out.println("Please enter a valid date");
	        }
	        else {
	            Search.day = getDay(Search.date);
	            resp.sendRedirect("search-results.jsp");
	        }
	    }

	    public String getDay(String dateInp) {
	        LocalDate dt = LocalDate.parse(dateInp);
	        return dt.getDayOfWeek().toString();
	    }
}
