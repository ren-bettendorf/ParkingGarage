package cs414.a4.rbetten;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OccupationRecord 
{
	private LocalDateTime time;
	private CarStatus status;
	private DateTimeFormatter format = DateTimeFormatter.ofPattern("MM dd yyyy H");
	
	public OccupationRecord(LocalDateTime time, CarStatus status)
	{
		this.time = LocalDateTime.of(time.getYear(), time.getMonthValue(), time.getDayOfMonth(), time.getHour(), 0);
		this.status = status;
	}

	public LocalDateTime getTime()
	{
		return time;
	}
	
	public CarStatus getCarStatus()
	{
		return status;
	}
}
