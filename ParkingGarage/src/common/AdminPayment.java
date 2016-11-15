package common;

import java.time.LocalDateTime;

public class AdminPayment extends Payment
{
	private String userAddress, userName, userPhoneNumber;
	private LocalDateTime dateOwed;
	private double amountOwed;
	
	public AdminPayment(String userAddress, String userName, String userPhoneNumber, double amountOwed, LocalDateTime dateOwed)
	{
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
	
	public String userAddress()
	{
		return userAddress;
	}
	
	public String userName()
	{
		return userName;
	}
	
	public String userPhoneNumber()
	{
		return userPhoneNumber;
	}
}