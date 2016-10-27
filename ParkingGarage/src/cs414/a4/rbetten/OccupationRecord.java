package cs414.a4.rbetten;

import java.time.LocalDateTime;

public class OccupationRecord 
{
	private LocalDateTime time;
	private CarStatus status;
	
	public OccupationRecord(LocalDateTime time, CarStatus status)
	{
		this.time = time;
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
