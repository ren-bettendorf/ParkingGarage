package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;

public class Record 
{
	private Ticket ticket;
	private Payment payment;
	public Record(Ticket ticket, Payment payment)
	{
		this.ticket = ticket;
		this.payment = payment;
	}

	public Ticket getTicket()
	{
		return ticket;
	}
	
	public Payment getPayment()
	{
		return payment;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Record) {
			Record rec = (Record)obj;
			return ( ticket.equals(rec.getTicket()) );
		}
		return false;
	}
}
