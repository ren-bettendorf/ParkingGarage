package test;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import common.CreditPayment;

public class CreditPaymentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeAmount()
	{
		String cardNumber = "1234567890123456";
		LocalDateTime date = LocalDateTime.of(2016, 9, 9, 0, 0);
		new CreditPayment(cardNumber, date, -1.00, LocalDateTime.now());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBadCCNumber()
	{
		String cardNumber = "1234567890";
		LocalDateTime date = LocalDateTime.of(2016, 9, 9, 0, 0);
		new CreditPayment(cardNumber, date, 1.00, LocalDateTime.now());
	}

}
