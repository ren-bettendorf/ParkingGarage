package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.HashSet;

public class FinancialRecord 
{
	private Ticket ticket;
	private Payment payment;
	public FinancialRecord(Ticket ticket, Payment payment)
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
	
	public Date getRecordDate()
	{
		return payment.getDateOfPayment();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FinancialRecord) {
			FinancialRecord rec = (FinancialRecord)obj;
			return ( ticket.equals(rec.getTicket()) );
		}
		return false;
	}
}
