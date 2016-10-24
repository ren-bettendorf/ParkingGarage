package cs414.a4.rbetten;

import java.util.Date;

public class CreditPayment extends Payment
{
	private String cardNumber;
	private String expirationDate;
	
	public CreditPayment(String cardNumber, String expirationDate, double amountPaid, Date dateOfPayment)
	{
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.amountPaid = amountPaid;
		this.dateOfPayment = dateOfPayment;
	}
	
	public String getCardNumber()
	{
		return cardNumber;
	}
	
	public String getExpirationDate()
	{
		return expirationDate;
	}
	
}