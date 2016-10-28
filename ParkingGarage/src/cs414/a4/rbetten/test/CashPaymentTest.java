package cs414.a4.rbetten.test;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import cs414.a4.rbetten.CashPayment;

public class CashPaymentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegativeAmount()
	{
		new CashPayment(-1.00, LocalDateTime.now());
	}

}
