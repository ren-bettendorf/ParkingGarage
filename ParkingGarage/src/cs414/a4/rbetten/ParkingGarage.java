package cs414.a4.rbetten;

import java.util.HashSet;

public class ParkingGarage
{
	private HashSet<Ticket> ticketsInGarage = new HashSet<Ticket>();
	private EntryGate entryGate;
	private ExitGate exitGate;
	private int maxOccupancy;
	private int carIdentifier = 1;
	
	public ParkingGarage(int maxOccu)
	{
		this.maxOccupancy = maxOccu;
		this.entryGate = new EntryGate("Entrance Gate", this);
		this.exitGate = new ExitGate("Exit Gate", this);
	}
	
	public boolean checkGarageSpace()
	{
		if(ticketsInGarage.size() == maxOccupancy)
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
		return ticketsInGarage.size();
	}
	
	public int getCarIdentifier()
	{
		return carIdentifier;
	}
	
	public HashSet<Ticket> getTickets()
	{
		return ticketsInGarage;
	}
	
	public void addCarToGarage(Ticket ticket)
	{
		ticketsInGarage.add(ticket);
	}
	
	public void removeCarFromGarage(Ticket ticket)
	{
		ticketsInGarage.remove(ticket);
		
	}
	
}
