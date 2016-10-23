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
			ticket.setPaymentStatus(true);
		}
		
	}
	
	public void attemptCheckoutCar(Car car)
	{
		if( car.getTicket().getPaymentStatus() )
		{
			payForTicket( car.getTicket() );
		}
		garage.removeCarFromGarage(car);
	}
	
}
