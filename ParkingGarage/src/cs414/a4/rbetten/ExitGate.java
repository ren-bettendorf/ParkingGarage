package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

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
	
	public boolean attemptCheckoutCar(String ticketID)
	{
		Ticket ticket = findTicket(ticketID);
		if( ticket != null)
		{
			if( ticket.getPaymentStatus() )
			{
				payForTicket( ticket );
			}
			return true;
		}
		return false;
	}
	
	private Ticket findTicket(String ticketID)
	{
		HashSet<Ticket> tickets = garage.getTickets();
		Ticket t = null;
		for(Ticket ticket : tickets)
		{
			if( ticket.getUniqueID().equals(ticketID) )
			{
				t = ticket;
				break;
			}
		}
		
		return t;
	}
	
	public void removeCarFromGarage(String ticketID)
	{
		garage.removeCarFromGarage(findTicket(ticketID));
	}
	
	public double amountDueOnTicket(String ticketID) 
	{
		Ticket t = findTicket(ticketID);
		LocalDateTime ldt = LocalDateTime.now();
		LocalDateTime tempDateTime = LocalDateTime.from( t.getCheckinTime() );
		double amountDue = tempDateTime.until( ldt, ChronoUnit.HOURS);
		
		
		return amountDue;
	}
	
}
