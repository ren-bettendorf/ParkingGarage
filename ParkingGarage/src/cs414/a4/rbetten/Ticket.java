package cs414.a4.rbetten;

import java.time.LocalDateTime;

public class Ticket {
	
	private LocalDateTime checkinTime;
	private boolean paymentStatus = false;
	
	
	public Ticket(LocalDateTime checkinTime)
	{
		this.checkinTime = checkinTime;
	}
	
	public LocalDateTime getCheckinTime()
	{
		return checkinTime;
	}

	
	public boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
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
