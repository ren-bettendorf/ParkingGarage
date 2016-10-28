package cs414.a4.rbetten.test;

import org.junit.Before;
import org.junit.Test;

import cs414.a4.rbetten.EntryGate;
import cs414.a4.rbetten.ParkingGarage;
import cs414.a4.rbetten.Ticket;

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
