package common;

import java.time.LocalDateTime;

import server.ParkingGarage;

public class EntryGate {
	
	private String gateName;
	private ParkingGarage garage;
	
	public EntryGate(String name, ParkingGarage garage)
	{
		this.gateName = name;
		this.garage = garage;
	}
	
	public String getGateName()
	{
		return gateName;
	}
	
	/**
	 * Checks in a car if ther is space in the garage
	 * @return Ticket ticket from checking in car
	 */
	public Ticket checkinCar()
	{
		Ticket ticket = null;
		if( !garage.checkGarageSpace() )
		{
			ticket = new Ticket(LocalDateTime.now());
			garage.addCarToGarage(ticket);

			garage.getRecordManager().addOccupationRecord(ticket.getCheckinTime(), CarStatus.ENTER);
		}
		return ticket;
	}
}
