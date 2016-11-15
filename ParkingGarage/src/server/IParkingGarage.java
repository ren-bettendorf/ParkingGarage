package server;

import java.time.LocalDateTime;
import common.Ticket;

public interface IParkingGarage extends java.rmi.Remote {

	public boolean checkGarageSpace() throws java.rmi.RemoteException;
	public void addCarToGarage(Ticket ticket)throws java.rmi.RemoteException;
	public void removeCarFromGarage(Ticket ticket)throws java.rmi.RemoteException;
	
	/**
	 * Creates the Occupation Report for a period of dates
	 * @param begin beginning date
	 * @param end ending date
	 * @return Occupation Report
	 */
	public String runOccupationReports(LocalDateTime begin, LocalDateTime end)throws java.rmi.RemoteException;
	
	/**
	 * Creates the Financial Report for a period of dates
	 * @param begin beginning date
	 * @param end ending date
	 * @return Financial Report
	 */
	public String runFinancialReports(LocalDateTime begin, LocalDateTime end) throws java.rmi.RemoteException;
}
