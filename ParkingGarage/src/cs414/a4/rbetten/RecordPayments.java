package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.HashSet;

public class RecordPayments {
	
	private HashSet<Record> records = new HashSet<Record>();
	
	public RecordPayments()
	{
	}
	
	public void addRecord(Ticket ticket)
	{
		Record record = new Record(ticket.getCheckinTime(), LocalDateTime.now());
		records.add(record);
	}
	
}
