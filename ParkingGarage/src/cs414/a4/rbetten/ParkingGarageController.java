package cs414.a4.rbetten;

import java.util.HashSet;

public class ParkingGarageController {
	private HashSet<Car> carsInGarage = new HashSet<Car>();
	private int maxOccupancy;
	
	public ParkingGarageController(int maxOccu)
	{
		this.maxOccupancy = maxOccu;
	}
	
	public boolean checkGarageFull()
	{
		if(carsInGarage.size() == maxOccupancy)
		{
			return true;
		}
		return false;
	}
	
}
