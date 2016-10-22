package cs414.a4.rbetten;

import java.util.HashSet;

public class ParkingGarage
{
	private HashSet<Car> carsInGarage = new HashSet<Car>();
	private int maxOccupancy;
	private int carIdentifier = 1;
	
	public ParkingGarage(int maxOccu)
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
	
	public int getCarIdentifier()
	{
		return carIdentifier;
	}
	
	public void addCarToGarage(Car car)
	{
		carsInGarage.add(car);
		carIdentifier++;
	}
	
	public void removeCarFromGarage(Car car)
	{
		carsInGarage.remove(car);
	}
	
}
