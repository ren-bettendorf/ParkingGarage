package test;

import org.junit.Before;
import org.junit.Test;

import common.EntryGate;
import common.Ticket;
import server.ParkingGarage;

import org.junit.Assert;

public class EntryGateTest 
{
	ParkingGarage garage = new ParkingGarage(1);
	EntryGate entryGate;
	Ticket t;
	
	@Before
	public void setUp() throws Exception 
	{
		entryGate = garage.getEntranceGate();

		t = entryGate.checkinCar();
	}

	//checkinCar()
	@Test
	public void testCarCheckinTicketGood() 
	{
		Assert.assertTrue(t != null);
	}
	@Test
	public void testCarCheckinTicketNull() 
	{
		t = entryGate.checkinCar();
		Assert.assertTrue(t == null);
	}
	@Test
	public void testCarCheckinGarageSpaceGood() 
	{
		Assert.assertTrue(garage.getCarOccupancy() == 1);
	}
	@Test
	public void testCarCheckinGarageSpaceBad() 
	{
		entryGate.checkinCar();
		Assert.assertTrue(garage.getCarOccupancy() == 1);
	}

}
