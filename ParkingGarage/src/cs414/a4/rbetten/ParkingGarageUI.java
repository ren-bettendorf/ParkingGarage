package cs414.a4.rbetten;

import java.util.Scanner;

public class ParkingGarageUI
{
	static Scanner input = new Scanner(System.in);
	static ParkingGarage garage;
	static int maxOccupancy;
	boolean runApp = true;
	
    public static void main(String[] args) 
    {
    	System.out.println("Parking Garage Application has started. "
		System.out.println("Before we officially begin though we need to get the size of the Garage.");
		System.out.println("It is important this is a positive integer!");
    	
    	inputGarageSize();
      
    	garage = new ParkingGarage(maxOccupancy);
    	while(runApp)
		{
			int userChoice = displayUserChoiceMenu();
			evaluateUserChoice(userChoice);
		}
    }
    
	private void inputGarageSize()
	{
		do 
    	{	
    		while ( !input.hasNextInt() ) 
    		{
    			System.out.println("Sorry but that isn't a positive integer. Try again!");
    			input.next(); 
    		}
    		maxOccupancy = input.nextInt();
    	} while (maxOccupancy < 1);
	}
	
    private static void evaluateUserChoice(int choice)
    {
    	switch(choice)
		{
			case 1:
				printOccupancyInfo();
				
				break;
			case 2:
				if( !garage.checkGarageSpace() )
				{
					System.out.println("Space is available. Dispensing ticket");
					Ticket ticket = garage.getEntranceGate().checkinCar();
					System.out.println("Please take ticket. Entry Gate opening!");
					System.out.println("Ticket Number: " + ticket.getUniqueID());
					System.out.println("Ticket taken. Driver enters garage");
					System.out.println("Entrance Gate closing");
					printOccupancyInfo();
					
				}
				else
				{
					System.out.println("Sorry garage is currently full. Please wait for a spot to open up!");
				}
				
				break;
			case 3:
				System.out.println("Please enter ticket number");
				
				
				break;
			case 4: 
			
				break;
			case 5:
			
				break;
			case 6:
				System.out.println("Exiting Application...");
				runApp = false;
				
				break;
			default:
				System.out.println("I'm sorry but something went wrong with your choice. Please try again.");
				
				break;
		}
    }
	
	private static void printOccupancyInfo()
	{
		System.out.println("");
		if( !garage.checkGarageSpace() )
		{
			System.out.println("GARAGE VACANCY");
			System.out.println("Currently " + garage.getCarOccupancy() + "/" + maxOccupancy + " spots filled");
		}
		else
		{
			System.out.println("GARAGE FULL");
			System.out.println("All " + maxOccupancy + " spots currently filled");
		}
	}
    
    private static int displayUserChoiceMenu()
    {
    	int userChoice;
    	do 
    	{
    		do
    		{
				System.out.println("Please select one of the following options: \n");
				System.out.println("GARAGE VACANCY STATUS " + garage.checkGarageSpace());
				System.out.println("");
				
                System.out.println("1.. Display current availability.");
                System.out.println("2.. Dispense a ticket.");
                System.out.println("3.. Pay for ticket.");
                System.out.println("4.. Administrator: Pay for lost or damaged ticket.");  
                System.out.println("5.. Administrator Only: View usage reports.");
                System.out.println("6.. Quit.\n");
				
    		} while ( !input.hasNextInt() );
			
    		userChoice = input.nextInt();
			
    	} while (userChoice > 0 && userChoice < 7);
    	
    	return userChoice;
    	
    }
}
