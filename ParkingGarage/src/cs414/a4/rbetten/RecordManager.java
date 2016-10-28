package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		String returnedTotals = "";
		HashMap<LocalDateTime, Integer> carsVisited = new HashMap<LocalDateTime, Integer>();
		HashMap<LocalDateTime, Integer> carsLeft = new HashMap<LocalDateTime, Integer>();
		if(occupationRecords.size() > 0)
		{
			LocalDateTime firstDay = occupationRecords.get(0).getTime();
			LocalDateTime lastDay = occupationRecords.get(occupationRecords.size()-1).getTime();

			int numVisited = 0;
			int numLeft = 0;
			for(OccupationRecord record : occupationRecords)
			{
				LocalDateTime ldt = record.getTime();
				if(ldt.isBefore(firstDay) || ldt.isAfter(lastDay))
				{
					continue;
				}
				CarStatus status = record.getCarStatus();
				if( status == CarStatus.ENTER)
				{
					if( carsVisited.containsKey(ldt) )
					{
						numVisited = carsVisited.get(ldt) + 1;
					}
					else
					{
						numVisited = 1;
					}

					carsVisited.put(ldt, numVisited);
				}
				else
				{
					if( carsLeft.containsKey(ldt) )
					{
						numLeft = carsLeft.get(ldt) + 1;
					}
					else
					{
						numLeft = 1;
					}

					carsLeft.put(ldt, numLeft);
				}
			}
		}
		
		returnedTotals = changeOccupationToLines(carsVisited, carsLeft);
		return returnedTotals;
	}

	public String getFinancialRecords(LocalDateTime begin, LocalDateTime end)
	{
		String returnedTotals;
		HashMap<LocalDateTime, Double> dailyTotals = new HashMap<LocalDateTime, Double>();
		if(financialRecords.size() > 0)
		{
			LocalDateTime firstDay = financialRecords.get(0).getRecordDate();
			LocalDateTime lastDay = financialRecords.get(financialRecords.size()-1).getRecordDate();

			for(FinancialRecord record : financialRecords)
			{
				LocalDateTime recordDate = record.getRecordDate();
				if(recordDate.isBefore(firstDay) || recordDate.isAfter(lastDay))
				{
					continue;
				}
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

		returnedTotals = changeFinancialToLines(dailyTotals);

		return returnedTotals;
	}
	
	private String changeOccupationToLines(HashMap<LocalDateTime, Integer> entered, HashMap<LocalDateTime, Integer> left)
	{
		String ret = "Cars Entered Garage: \nTimestamp\t\tTotal Entered Garage\n";
		for(LocalDateTime day : entered.keySet())
		{
			ret += day + ", \t" + entered.get(day) + "\n";
		}
		ret += "Cars Left Garage: \nTimestamp\t\tTotal Left Garage\n";
		for(LocalDateTime day : left.keySet())
		{
			ret += day + ", \t" + left.get(day) + "\n";
		}
		ret += "\n\n";
		return ret;
	}

	private String changeFinancialToLines(HashMap<LocalDateTime, Double> dailyTotals) 
	{
		String ret = "Financial Records: \n\nDay\tTotal Made\n";
		for(LocalDateTime day : dailyTotals.keySet())
		{
			ret += day + ", \t" + dailyTotals.get(day) + "\n";
		}
		return ret;
	}

}
