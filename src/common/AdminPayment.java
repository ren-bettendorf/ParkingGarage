package common;

import java.time.LocalDateTime;

public class AdminPayment extends Payment
{
	private String userAddress, userName, userPhoneNumber;
	private LocalDateTime dateOwed;
	private double amountOwed;
	
	public AdminPayment(String userAddress, String userName, String userPhoneNumber, double amountOwed, LocalDateTime dateOwed)
	{
		if(userAddress == null || userName == null || userPhoneNumber == null ||  dateOwed == null)
		{
			throw new IllegalArgumentException("Null field");
		}else if(amountOwed <= 0)
		{
			throw new IllegalArgumentException("Can't owe negative amount");
		}
		this.userAddress = userAddress;
		this.userName = userName;
		this.userPhoneNumber = userPhoneNumber;
		this.amountOwed = amountOwed;
		this.dateOwed = dateOwed;
	}
	
	public double getAmountOwed()
	{
		return amountOwed;
	}
	
	public LocalDateTime getDateOwed()
	{
		return dateOwed;
	}
	
	public String getUserAddress()
	{
		return userAddress;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getUserPhoneNumber()
	{
		return userPhoneNumber;
	}
}