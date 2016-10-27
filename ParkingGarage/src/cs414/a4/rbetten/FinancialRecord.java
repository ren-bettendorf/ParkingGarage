package cs414.a4.rbetten;

import java.util.Date;

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
