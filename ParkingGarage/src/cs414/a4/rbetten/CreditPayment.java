package cs414.a4.rbetten;

import java.util.Date;

public class CreditPayment extends Payment
{
	private String cardNumber;
	private Date expirationDate;
	
	public CreditPayment(String cardNumber, Date expDate, double amountPaid, Date dateOfPayment)
	{
		if(cardNumber.length() == 16)
		{
			throw new IllegalArgumentException();
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