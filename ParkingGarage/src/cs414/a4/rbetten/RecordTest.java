package cs414.a4.rbetten;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RecordTest {

	LocalDateTime firstLDT, secondLDT;
	
	Record firstRecord, secondRecord;
	
	
	@Before
	public void setUp() throws Exception {
		firstLDT = LocalDateTime.now();
		secondLDT = LocalDateTime.now();
		
		firstRecord = new Record(firstLDT, secondLDT);
		secondRecord =  new Record(firstLDT, secondLDT);
	}

	@Test(expected = IllegalArgumentException.class)
	public void improperInstance() {
		@SuppressWarnings("unused")
		Record record = new Record(secondLDT, firstLDT);
	}
	
	@Test
	public void equalsTrue() {
		Assert.assertTrue(firstRecord.equals(secondRecord));
	}
	
	
}
