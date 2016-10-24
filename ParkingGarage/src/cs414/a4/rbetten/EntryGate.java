package cs414.a4.rbetten;

import java.time.LocalDateTime;

public class EntryGate {
	
	private String gateName;
	private ParkingGarage garage;
	
	public EntryGate(String name, ParkingGarage garage)
	{
		this.gateName = name;
		this.garage = garage;
	}
	
	public Ticket checkinCar()
	{
		Ticket ticket = null;
		if( garage.checkGarageSpace() )
		{
			ticket = new Ticket(LocalDateTime.now());
			Car car = new Car(garage.getCarIdentifier(), ticket);
			garage.addCarToGarage(car);
		}
		return ticket;
	}
}
