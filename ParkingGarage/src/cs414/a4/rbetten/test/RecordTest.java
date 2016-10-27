package cs414.a4.rbetten.test;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs414.a4.rbetten.FinancialRecord;

public class RecordTest {

	LocalDateTime firstLDT, secondLDT;
	
	FinancialRecord firstRecord, secondRecord;
	
	
	@Before
	public void setUp() throws Exception {
		firstLDT = LocalDateTime.now();
		secondLDT = LocalDateTime.now();
		
		//firstRecord = new Record(firstLDT, secondLDT, null);
		//secondRecord =  new Record(firstLDT, secondLDT, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void improperInstance() {
		//Record record = new Record(secondLDT, firstLDT, null);
	}
	
	@Test
	public void equalsTrue() {
		Assert.assertTrue(firstRecord.equals(secondRecord));
	}
	
	
}
