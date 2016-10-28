package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.Date;

public class CreditPayment extends Payment
{
	private String cardNumber;
	private Date expirationDate;
	
	public CreditPayment(String cardNumber, Date expDate, double amountPaid, LocalDateTime dateOfPayment)
	{
		if(cardNumber.length() != 16)
		{
			throw new IllegalArgumentException("Bad Credit Card Number");
		}
		if(amountPaid <= 0)
		{
			throw new IllegalArgumentException("Amount paid can't be less than 0");
		}
		this.cardNumber = cardNumber;
		this.expirationDate = expDate;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
	}
	
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	public Date getExpirationDate()
	{
		return expirationDate;
	}
	
}