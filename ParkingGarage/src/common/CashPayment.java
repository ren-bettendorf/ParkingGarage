package common;

import java.time.LocalDateTime;

public class CashPayment extends Payment
{
	public CashPayment(double amountPaid, LocalDateTime dateOfPayment)
	{
		// Disallow a negative payment
		if(amountPaid <= 0)
		{
			throw new IllegalArgumentException("Amount paid can't be less than 0");
		}
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
	}
	
}