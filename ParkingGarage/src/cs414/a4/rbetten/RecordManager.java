package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RecordManager 
{

	private ArrayList<FinancialRecord> financialRecords = new ArrayList<FinancialRecord>();
	private ArrayList<OccupationRecord> occupationRecords = new ArrayList<OccupationRecord>();
	//private ArrayList<>

	public RecordManager()
	{
	}
	
	public void addOccupationRecord(LocalDateTime ldt, CarStatus status)
	{
		OccupationRecord record = new OccupationRecord(ldt, status);
		occupationRecords.add(record);
	}

	public void addFinancialRecord(Ticket ticket, Payment payment)
	{
		FinancialRecord record = new FinancialRecord(ticket, payment);
		financialRecords.add(record);
	}
	
	public String getOccupationRecords(LocalDateTime begin, LocalDateTime end)
	{
		String returnedTotals;
		HashMap<Date, Integer> carsVisited = new HashMap<Date, Integer>();
		if(occupationRecords.size() > 0)
		{
			LocalDateTime firstDay = occupationRecords.get(0).getTime();
			LocalDateTime lastDay = occupationRecords.get(occupationRecords.size()-1).getTime();

			if(firstDay.isBefore(begin) || lastDay.isAfter(end))
			{
				throw new IllegalArgumentException();
			}
			
		}
		return null;
	}

	public String getFinancialRecords(Date begin, Date end)
	{
		String returnedTotals;
		HashMap<Date, Double> dailyTotals = new HashMap<Date, Double>();
		if(financialRecords.size() > 0)
		{
			Date firstDay = financialRecords.get(0).getRecordDate();
			Date lastDay = financialRecords.get(financialRecords.size()-1).getRecordDate();

			if(firstDay.before(begin) || lastDay.after(end))
			{
				throw new IllegalArgumentException();
			}
			for(FinancialRecord record : financialRecords)
			{
				Date recordDate = record.getRecordDate();
				double recordPayment = record.getPayment().getAmountPaid();
				if(dailyTotals.containsKey(recordDate))
				{
					double runningTotals = dailyTotals.get(recordDate) + recordPayment;
					dailyTotals.replace(recordDate, runningTotals);
				}
				else
				{
					dailyTotals.put(recordDate, recordPayment);
				}
			}
		}

		returnedTotals = changeToLines(dailyTotals);

		return returnedTotals;
	}

	private String changeToLines(HashMap<Date, Double> dailyTotals) 
	{
		String ret = "";
		for(Date day : dailyTotals.keySet())
		{
			ret += day + ", \t" + dailyTotals.get(day) + "\n";
		}
		return ret;
	}

}
