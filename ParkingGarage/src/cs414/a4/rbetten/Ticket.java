package cs414.a4.rbetten;

import java.time.LocalDateTime;

public class Ticket {
	
	private LocalDateTime checkinTime;
	private LocalDateTime checkoutTime;
	private boolean paymentStatus = false;
	
	
	public Ticket(LocalDateTime checkinTime)
	{
		this.checkinTime = checkinTime;
	}
	
	public LocalDateTime getCheckinTime()
	{
		return checkinTime;
	}
	
	public void setCheckoutTime(LocalDateTime ldt)
	{
		if(checkinTime.compareTo(ldt) < 0)
		{
			this.checkoutTime = ldt;
		}
	}
	
	public void setPaymentStatus(boolean status)
	{
		this.paymentStatus = status;
	}
	
	public boolean getPaymentStatus()
	{
		return this.paymentStatus;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Ticket) {
			return checkinTime.equals(((Ticket) obj).getCheckinTime());
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		return checkinTime.toString();
	}
}
