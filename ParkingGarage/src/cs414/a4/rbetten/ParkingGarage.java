package cs414.a4.rbetten;

import java.util.HashSet;

public class ParkingGarage
{
	private HashSet<Ticket> carsInGarage = new HashSet<Ticket>();
	private EntryGate entryGate;
	private ExitGate exitGate;
	private int maxOccupancy;
	private int carIdentifier = 1;
	private RecordPayments payments = new RecordPayments();
	
	public ParkingGarage(int maxOccu)
	{
		this.maxOccupancy = maxOccu;
		this.entryGate = new EntryGate("Entrance Gate", this);
		this.exitGate = new ExitGate("Exit Gate", this);
	}
	
	public boolean checkGarageSpace()
	{
		if(carsInGarage.size() == maxOccupancy)
		{
			return true;
		}
		return false;
	}
	
	public int getMaxCarOccupancy()
	{
		return maxOccupancy;
	}
	
	public EntryGate getEntranceGate()
	{
		return entryGate;
	}
	
	public ExitGate getExitGate()
	{
		return exitGate;
	}
	
	public int getCarOccupancy()
	{
		return carsInGarage.size();
	}
	
	public int getCarIdentifier()
	{
		return carIdentifier;
	}
	
	public void addCarToGarage(Ticket ticket)
	{
		carsInGarage.add(ticket);
	}
	
	public void removeCarFromGarage(Ticket ticket)
	{
		carsInGarage.remove(ticket);
		payments.addRecord(ticket);
		
	}
	
}
