package services;

import model.Bus;
import model.Flight;
import model.Hotel;
import model.Train;
import controller.BusController;
import java.time.*;
// Type your code
public class FareCalculator extends Booking{
	public double book(Hotel hotel) {
		if(hotel.getFromdate().isBefore(hotel.getTodate())) {
			if(hotel.getNoOfPersons()==1 && hotel.getOccupancy().equals("single")) {
				return booking(hotel.getNoOfPersons(),hotel.getRates());
			}
			else if(hotel.getNoOfPersons()>=2 && hotel.getOccupancy().equals("double")) {
				return booking(hotel.getNoOfPersons(),hotel.getRates());
			}
		}
		return 0.00;
	}
	public double book(Flight flight) {
		if(flight.getTriptype().equals("round-trip")&& flight.getFrom().isBefore(flight.getTo())) {
			return booking(flight.getNoOfPersons(),flight.getRates());	
		}
		else if(flight.getTriptype().equals("one-way")) {
			return booking(flight.getNoOfPersons(),flight.getRates());
		}
		return 0.00;
	}
	public double book(Train train) {
		return booking(train.getNoOfPersons(),train.getRates());
	}
	public double book(Bus bus) {
		return booking(bus.getNoOfPersons(),bus.getRates());
	}
}