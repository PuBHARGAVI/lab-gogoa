package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.deploy.net.URLEncoder;

import model.Flight;
import services.FareCalculator;



@WebServlet(urlPatterns= {"/flight"})
public class FlightController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public FlightController() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numberOfPersons=Integer.parseInt(request.getParameter("persons"));
		String classtype=request.getParameter("class");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		String triptype=request.getParameter("trip");

		int rates;
		if(classtype.equals("executive")){
			rates=7500;
		}
		else {
			rates=5000;
		}
		LocalDate start=LocalDate.parse(from);		
		LocalDate end;
		if(to.equals("")) {
			System.out.println("hi");
			end=null;
		}
		else {
			System.out.println("hi1");
			end=LocalDate.parse(to);
		}
	
		System.out.println(triptype);
		Flight flight=new Flight(numberOfPersons,rates,classtype,start,end,triptype);

		flight.setNoOfPersons(numberOfPersons);
		flight.setRates(rates);
		flight.setClassType(classtype);
		flight.setFrom(start);
		flight.setTo(end);
		String msg="";
		if(!(flight.getFrom().isBefore(flight.getTo()))) {
			System.out.println("enter correct dates");
			}
		else{
		FareCalculator fare=new FareCalculator();
		double rate=fare.book(flight);
		request.setAttribute("flight", flight);
		request.setAttribute("flightfare", rate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/flightView.jsp");
		dispatcher.forward(request, response);
		}
	}

}
