package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Ticket {
	
	private LocalDateTime checkinTime;
	private String uniqueID;
	private boolean paymentStatus = false;
	
	
	public Ticket(LocalDateTime checkinTime)
	{
		this.checkinTime = checkinTime;
		this.uniqueID = checkinTime.toString().replaceAll("[^0-9]", "");
	}
	
	public LocalDateTime getCheckinTime()
	{
		return checkinTime;
	}

	public String getUniqueID()
	{
		return uniqueID;
	}
	
	public boolean getPaymentStatus() 
	{
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) 
	{
		this.paymentStatus = paymentStatus;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if(!(obj == null) && obj instanceof Ticket) 
		{
			Ticket tic = (Ticket)obj;
			return this.checkinTime.equals(tic.getCheckinTime());
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return checkinTime.toString();
	}
}
