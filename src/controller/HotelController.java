package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Hotel;
import services.FareCalculator;




@WebServlet(urlPatterns={"/hotel"})
public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
    public HotelController() {
        super();
     }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int numberOfPersons=Integer.parseInt(request.getParameter("persons"));
		String roomtype=request.getParameter("roomtype");
		String occupancy=request.getParameter("occupancy");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		LocalDate fromDate=LocalDate.parse(from);
		LocalDate toDate=LocalDate.parse(to);
		
		int rates;
		if(roomtype.equals("AC")){
			rates=1500;
		}
		else
			rates=1000;
		
		System.out.println(numberOfPersons);
		System.out.println(roomtype);
		System.out.println(rates);
		System.out.println(occupancy);
		Hotel hotel=new Hotel(numberOfPersons,roomtype,rates,occupancy,fromDate,toDate);
		if(!(hotel.getFromdate().isBefore(hotel.getTodate()))){
			System.out.println("enter correct dates");
			}
		else {
		
		hotel.setNoOfPersons(numberOfPersons);
		hotel.setRates(rates);
		hotel.setRoomType(roomtype);
		hotel.setFromdate(fromDate);
		hotel.setTodate(toDate);
	
		FareCalculator  fare=new FareCalculator();
		double rate=fare.book(hotel);
		System.out.println(rate);
		request.setAttribute("hotel", hotel);
		request.setAttribute("hotelfare", rate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/hotelOutputView.jsp");
		dispatcher.forward(request, response);
		}
	}
	
}
