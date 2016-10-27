package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class Payment
{
	protected double amountPaid;
	protected LocalDateTime dateOfPayment;
	
	public double getAmountPaid()
	{
		return amountPaid;
	}
	
	public LocalDateTime getDateOfPayment()
	{
		return dateOfPayment;
	}
}