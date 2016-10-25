package cs414.a4.rbetten;

import java.util.Scanner;

public class ParkingGarageUI
{
	static Scanner input = new Scanner(System.in);
	static ParkingGarage garage;
	static int maxOccupancy;
	
    public static void main(String[] args) 
    {
    	System.out.print("Parking Garage Application has started. "
				  + "Before we officially begin though we need to get the size of the Garage.\n");
    	
    	do 
    	{	
    		System.out.println("It is important this is a positive integer!");
    		while ( !input.hasNextInt() ) 
    		{
    			System.out.println("Sorry but that isn't a positive integer. Try again!");
    			input.next(); 
    		}
    		maxOccupancy = input.nextInt();
    	} while (maxOccupancy < 1);
      
    	garage = new ParkingGarage(maxOccupancy);
    	
    	int userChoice = displayUserChoiceMenu();
    	evaluateUserChoice(userChoice);
    }
    
    private static void evaluateUserChoice(int choice)
    {
    	
    }
    
    private static int displayUserChoiceMenu()
    {
    	int userChoice;
    	do 
    	{
    		while ( !input.hasNextInt() ) 
    		{
        		System.out.println("Please select one of the following options: \n");
                System.out.println("1.. Display current availability.");
                System.out.println("2.. Dispense a ticket.");
                System.out.println("3.. Pay for ticket.");
                System.out.println("4.. Administrator: Pay for lost or damaged ticket.");  
                System.out.println("5.. Administrator Only: View usage reports.");
                System.out.println("6.. Quit.\n");
    		}
    		userChoice = input.nextInt();
    	} while (userChoice > 0 && userChoice < 7);
    	
    	return userChoice;
    	
    }
}
