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
	
	public void attemptCheckinCar()
	{
		if( !garage.checkGarageFull() )
		{
			Car car = new Car(garage.getCarIdentifier(), dispenseTicket());
			garage.addCarToGarage(car);
		}
	}
	
	private Ticket dispenseTicket()
	{
		return new Ticket(LocalDateTime.now());
	}
}
