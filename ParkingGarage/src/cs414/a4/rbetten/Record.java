package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;

public class Record {
	
	private int dayIn, dayOut;
	private Month monthIn, monthOut;
	private HashSet<Integer> hoursIn = new HashSet<Integer>();
	
	public Record(LocalDateTime checkin, LocalDateTime checkout, Payment payment)
	{
		if(checkin.compareTo(checkout) > 0)
		{
			throw new IllegalArgumentException("Checkout time is before checkin time");
		}
		
		for(int hourStart = checkin.getHour(); hourStart <= checkout.getHour(); hourStart++)
		{
			this.hoursIn.add(hourStart);
		}
		
		this.dayIn = checkin.getDayOfYear();
		this.dayOut = checkout.getDayOfYear();
		
		this.monthIn = checkin.getMonth();
		this.monthOut = checkin.getMonth();
		
	}

	public int getDayIn() {
		return dayIn;
	}


	public int getDayOut() {
		return dayOut;
	}


	public Month getMonthIn() {
		return monthIn;
	}


	public Month getMonthOut() {
		return monthOut;
	}
	
	public HashSet<Integer> getHoursIn()
	{
		return hoursIn;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Record) {
			Record rec = (Record)obj;
			return (( dayIn == rec.getDayIn() ) && ( dayOut == rec.getDayOut() ) && ( monthIn.equals(rec.getMonthIn()) ) 
					&& ( monthOut.equals(rec.getMonthOut()) ) && ( hoursIn.equals(rec.getHoursIn())));
		}
		return false;
	}
}
