package cs414.a4.rbetten;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RecordPayments {
	
	private ArrayList<Record> records = new ArrayList<Record>();
	
	public RecordPayments()
	{
	}
	
	public void addRecord(Ticket ticket, Payment payment)
	{
		Record record = new Record(ticket, payment);
		records.add(record);
	}
	
	public HashMap<Date, Double> getFinancialRecords(Date begin, Date end)
	{

		HashMap<Date, Double> dailyTotals = new HashMap<Date, Double>();
		if(records.size() > 0)
		{
			Date firstDay = records.get(0).getRecordDate();
			Date lastDay = records.get(records.size()-1).getRecordDate();
			
			if(firstDay.before(begin) || lastDay.after(end))
			{
				throw new IllegalArgumentException();
			}
			for(Record record : records)
			{
				
			}
		}
		return dailyTotals;
	}
	
}
