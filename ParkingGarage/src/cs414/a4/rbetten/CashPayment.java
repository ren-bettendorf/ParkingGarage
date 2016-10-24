package cs414.a4.rbetten;

import java.util.Date;

public class CashPayment extends Payment
{
	public CashPayment(double amountPaid, Date dateOfPayment)
	{
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
	}
	
}