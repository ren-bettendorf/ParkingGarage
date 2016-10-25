package cs414.a4.rbetten;

import java.time.LocalDateTime;

public class ExitGate {
	
	private String gateName;
	private ParkingGarage garage;
	
	public ExitGate(String name, ParkingGarage garage)
	{
		this.gateName = name;
		this.garage = garage;
	}
	
	public void payForTicket(Ticket ticket)
	{
		if( !ticket.getPaymentStatus() )
		{
			// Needs to be refactored when we implement the UI
			ticket.setPaymentStatus(true);
		}
		
	}
	
	public void attemptCheckoutCar(Ticket ticket)
	{
		if( ticket.getPaymentStatus() )
		{
			payForTicket( ticket );
		}
		garage.removeCarFromGarage(ticket);
	}
	
}
