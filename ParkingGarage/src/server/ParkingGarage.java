package server;

import java.time.LocalDateTime;
import java.util.HashSet;

import common.EntryGate;
import common.ExitGate;
import common.RecordManager;
import common.Ticket;

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
	
	/**
	 * Creates the Occupation Report for a period of dates
	 * @param begin beginning date
	 * @param end ending date
	 * @return Occupation Report
	 */
	public String runOccupationReports(LocalDateTime begin, LocalDateTime end)
	{
<<<<<<< HEAD:ParkingGarage/src/server/ParkingGarage.java
		LocalDateTime beginLDT = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth(), 0, 0);

		LocalDateTime endLDT = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 0, 0);
=======
		LocalDateTime beginLDT = LocalDateTime.of(begin.getYear() + 1900, begin.getMonth() + 1, begin.getDate(), 0, 0);

		LocalDateTime endLDT = LocalDateTime.of(end.getYear() + 1900, end.getMonth() + 1, end.getDate(), 0, 0);
>>>>>>> c54d15fa9ac6a9dd234dc7f72a2fc583a5588218:ParkingGarage/src/cs414/a4/rbetten/ParkingGarage.java
		return recordManager.getOccupationRecords(beginLDT, endLDT);
		
	}
	
	/**
	 * Creates the Financial Report for a period of dates
	 * @param begin beginning date
	 * @param end ending date
	 * @return Financial Report
	 */
	public String runFinancialReports(LocalDateTime begin, LocalDateTime end)
	{
		LocalDateTime beginLDT = LocalDateTime.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth(), 0, 0);

<<<<<<< HEAD:ParkingGarage/src/server/ParkingGarage.java
		LocalDateTime endLDT = LocalDateTime.of(end.getYear(), end.getMonth(), end.getDayOfMonth(), 0, 0);
=======
		LocalDateTime beginLDT = LocalDateTime.of(begin.getYear() + 1900, begin.getMonth() + 1, begin.getDate(), 0, 0);

		LocalDateTime endLDT = LocalDateTime.of(end.getYear() + 1900, end.getMonth() + 1, end.getDate(), 0, 0);
>>>>>>> c54d15fa9ac6a9dd234dc7f72a2fc583a5588218:ParkingGarage/src/cs414/a4/rbetten/ParkingGarage.java
		return recordManager.getFinancialRecords(beginLDT, endLDT);
	}
	
}
