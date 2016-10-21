package cs414.a4.rbetten;

public class Car{

	private int carID;
	private boolean paymentStatus = false;
	Ticket ticket;

	public Car(int carID, Ticket ticket)
	{
		this.carID = carID;
		this.ticket = ticket;
	}
	
	public int getCarID()
	{
		return carID;
	}
	
	public boolean payForTicket()
	{
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Car) {
			return carID == ((Car) obj).getCarID();
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(carID + ":" + ticket + ":" + paymentStatus);
	}
}
