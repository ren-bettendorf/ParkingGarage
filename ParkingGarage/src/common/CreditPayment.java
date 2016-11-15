package common;

import java.time.LocalDateTime;

public class CreditPayment extends Payment
{
	private String cardNumber;
	private LocalDateTime expirationDate;
	
	public CreditPayment(String cardNumber, LocalDateTime expDate, double amountPaid, LocalDateTime dateOfPayment)
	{
		// Credit Card Numbers must have 16 characters
		if(cardNumber.length() != 16)
		{
			throw new IllegalArgumentException("Bad Credit Card Number");
		}
		// Disallow a negative payment
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
	
	public LocalDateTime getExpirationDate()
	{
		return expirationDate;
	}
	
}