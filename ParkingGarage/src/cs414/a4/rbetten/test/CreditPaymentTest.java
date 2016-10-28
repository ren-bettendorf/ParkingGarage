package cs414.a4.rbetten.test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cs414.a4.rbetten.CashPayment;
import cs414.a4.rbetten.CreditPayment;

public class CreditPaymentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeAmount()
	{
		String cardNumber = "1234567890123456";
		Date date = new Date(2016, 9, 9, 0, 0);
		new CreditPayment(cardNumber, date, -1.00, LocalDateTime.now());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBadCCNumber()
	{
		String cardNumber = "1234567890";
		Date date = new Date(2016, 9, 9, 0, 0);
		new CreditPayment(cardNumber, date, 1.00, LocalDateTime.now());
	}

}
