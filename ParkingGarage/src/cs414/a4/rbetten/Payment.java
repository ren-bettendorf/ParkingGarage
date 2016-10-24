package cs414.a4.rbetten;

import java.util.Date;

public abstract class Payment
{
	protected double amountPaid;
	protected Date dateOfPayment;
	
	public double getAmountPaid()
	{
		return amountPaid;
	}
	
	public Date getDateOfPayment()
	{
		return dateOfPayment;
	}
}