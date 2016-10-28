package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;

public class ParkingGarage
{
	private HashSet<Ticket> ticketsInGarage = new HashSet<Ticket>();
	private RecordManager recordManager = new RecordManager();
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
	
	public RecordManager getRecordManager()
	{
		return recordManager;
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
	
	@SuppressWarnings("deprecation")
	public String runOccupationReports(Date begin, Date end)
	{
		LocalDateTime beginLDT = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDate(), 0, 0);

		LocalDateTime endLDT = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDate(), 0, 0);
		return recordManager.getOccupationRecords(beginLDT, endLDT);
		
	}
	
	@SuppressWarnings("deprecation")
	public String runFinancialReports(Date begin, Date end)
	{

		LocalDateTime beginLDT = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDate(), 0, 0);

		LocalDateTime endLDT = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDate(), 0, 0);
		return recordManager.getFinancialRecords(beginLDT, endLDT);
	}
	
}
