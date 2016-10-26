package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class RecordPayments {
	
	private HashSet<Record> records = new HashSet<Record>();
	private HashMap<Date, Double> dayTotals = new HashMap<Date, Double>();
	
	public RecordPayments()
	{
	}
	
	public void addRecord(Ticket ticket, Payment payment)
	{
		Record record = new Record(ticket, payment);
		records.add(record);
	}
	
}
