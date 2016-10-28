package cs414.a4.rbetten.test;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rbetten.CashPayment;
import cs414.a4.rbetten.EntryGate;
import cs414.a4.rbetten.ExitGate;
import cs414.a4.rbetten.ParkingGarage;
import cs414.a4.rbetten.Payment;
import cs414.a4.rbetten.Ticket;

public class ExitGateTest {
	
	ParkingGarage garage = new ParkingGarage(10);
	ExitGate exitGate;
	EntryGate entryGate;
	Ticket ticketGood, ticketBad;
	int occupancy;
	Payment payment;
	@Before
	public void setUp() throws Exception 
	{
		exitGate = garage.getExitGate();
		entryGate = garage.getEntranceGate();
		
		ticketGood = entryGate.checkinCar();
		ticketBad = new Ticket(LocalDateTime.of(2016, 1, 1, 1, 1));
		occupancy = garage.getCarOccupancy();
		payment = new CashPayment(10.00, LocalDateTime.now());
	}
	
	//attemptCheckoutCar(String ticketID)
	@Test
	public void testCheckoutCarPass()
	{
		Assert.assertTrue(exitGate.attemptCheckoutCar(ticketGood.getUniqueID()));
	}
	@Test
	public void testCheckoutCarFail()
	{
		Assert.assertFalse(exitGate.attemptCheckoutCar(ticketBad.getUniqueID()));
	}
	
	//removeCarFromGarage(String ticketID, Payment payment)
	@Test
	public void testRemoveCarPass()
	{
		exitGate.removeCarFromGarage(ticketGood.getUniqueID(), payment);
		Assert.assertTrue(garage.getCarOccupancy() == 0);
	}
	@Test
	public void testRemoveCarFail()
	{
		exitGate.removeCarFromGarage(ticketBad.getUniqueID(), payment);
		Assert.assertFalse(garage.getCarOccupancy() == 0);
	}
	
	//amountDueOnTicket(String ticketID)
	@Test
	public void testAmountDue() 
	{
		Assert.assertTrue(exitGate.amountDueOnTicket(ticketGood.getUniqueID()) == 1.00);
	}

}
