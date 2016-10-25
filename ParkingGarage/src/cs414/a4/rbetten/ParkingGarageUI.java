package cs414.a4.rbetten;

import java.util.Scanner;

public class ParkingGarageUI
{
	static Scanner input = new Scanner(System.in);
	static ParkingGarage garage;
	static int maxOccupancy;
	static boolean runApp = true;
	
    public static void main(String[] args) 
    {
    	System.out.println("Parking Garage Application has started. ");
		System.out.println("Before we officially begin though we need to get the size of the Garage.");
		System.out.println("It is important this is a positive integer!");
    	
    	inputGarageSize();
      
    	garage = new ParkingGarage(maxOccupancy);
    	while(runApp)
		{
			String userChoice = displayUserChoiceMenu();
			evaluateUserChoice(userChoice);
		}
    }
    
	private static void inputGarageSize()
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
	
    private static void evaluateUserChoice(String choice)
    {
    	System.out.println("\nEVALUATING USER CHOICE: " + choice);
    	switch(choice)
		{
			case "1":
				printOccupancyInfo();
				
				break;
			case "2":
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
			case "3":
				System.out.println("Please enter ticket number.");
				String ticketNumber = input.next();
				if( garage.getExitGate().attemptCheckoutCar(ticketNumber) )
				{
					boolean validInput = true;
					do
					{
						System.out.println("Ticket found. Please select an option to pay for ticket.");
						System.out.println("1.. Cash Payment");
						System.out.println("2.. Credit Payment");
						
						String userIn = input.next();
						
						
						Payment payment;
						switch(userIn)
						{
							case "1":
								System.out.println("How much cash was inserted? ");
								String amountPaid = input.next();
								payment = new CashPayment();
								
								validInput = true;
								break;
							case "2":
								System.out.println("Please enter the credit card number (no dashes): ");
								String ccNumber = input.next();
								System.out.println("Please enter the expiration date (mm/yyyy): ");
								Date expDate = changeToDate(input.next());
								payment = new CreditPayment(ccNumber, expDate, Date.);
								
								validInput = true;
								break;
							default:
								System.out.println("Sorry but that isn't a valid option. Please try again.");
								validInput = false;
						}
					}while ( !validInput )
					
//					System.out.println("Exit Gate Open.");
//					System.out.println("Driver leaves garage.");
//					System.out.println("Exit Gate Closes.");
//					printOccupancyInfo();
				}
				else
				{
					System.out.println("Sorry but the ticket number was not found. Please try again or ask for an Administrator.");
				}
				
				break;
			case "4": 
			
				break;
			case "5":
			
				break;
			case "6":
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
    
    private static String displayUserChoiceMenu()
    {
		System.out.println("\nGARAGE VACANCY STATUS " + garage.checkGarageSpace());
		System.out.println("Please select one of the following options:");

		System.out.println("1.. Display current availability.");
		System.out.println("2.. Dispense a ticket.");
		System.out.println("3.. Pay for ticket.");
		System.out.println("4.. Administrator: Pay for lost or damaged ticket.");  
		System.out.println("5.. Administrator Only: View usage reports.");
		System.out.println("6.. Quit.\n");
		
		String userChoice = input.next();
		
    	return userChoice;
    	
    }
	
	private static Date changeToDate(String stringToChange)
	{
		return new Date();
	}
}
