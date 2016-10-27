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
	
	public String getGateName()
	{
		return gateName;
	}
	
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
