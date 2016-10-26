package cs414.a4.rbetten;

import java.util.Date;

public class AdminPayment extends Payment
{
	private String userAddress, userName, userPhoneNumber;
	private Date dateOwed;
	private double amountOwed;
	
	public AdminPayment(String userAddress, String userName, String userPhoneNumber, double amountOwed, Date dateOwed)
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
	
	public Date getDateOwed()
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