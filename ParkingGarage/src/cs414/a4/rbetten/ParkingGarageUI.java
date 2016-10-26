package cs414.a4.rbetten;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
				ExitGate exit = garage.getExitGate();
				if( exit.attemptCheckoutCar(ticketNumber) )
				{
					double amountDue = exit.amountDueOnTicket(ticketNumber);
					boolean validInput = true;
					do
					{
						System.out.println("Ticket found. Ticket amount due is : " + amountDue);
						System.out.println("1.. Cash Payment");
						System.out.println("2.. Credit Payment");
						System.out.println("3.. Need help from an Administrator.");
						
						String userIn = input.next();
						LocalDateTime ldt = LocalDateTime.now();
						Date today = new Date(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth());
						double amountPaid = 0.00;
						Payment payment;
						switch(userIn)
						{
							case "1":
								do
								{
									System.out.println("How much cash was inserted (must be > 0 and is truncated to two decimal places)? ");
									String temp = input.next();
									try
									{
										amountPaid = Double.parseDouble(temp);
									}catch (NumberFormatException e) {
									    System.out.println("Sorry but there was a problem with that number. Please try again.");
									}
								}while(amountPaid <= 0);
								payment = new CashPayment(amountPaid, today);
								
								validInput = true;
								break;
							case "2":
								System.out.println("Please enter the credit card number (no dashes): ");
								String ccNumber = input.next();
								
							    Date expDate = null;
							    boolean validDate = true;
							    do
								{

									DateFormat df = new SimpleDateFormat("MM/yyyy"); 
								    try {
								        System.out.println("Please enter the expiration date (MM/YYYY): ");
								        expDate = df.parse(input.next());
								        validInput = true;
								    } catch (ParseException e) {
								    	System.out.println("Sorry but there was a problem with that entry. Please try again.");
								    	validInput = false;
								    }
								}while( !validDate );
								
								do
								{
									System.out.println("How much cash was inserted (must be > 0 and is truncated to two decimal places)? ");
									String temp = input.next();
									try
									{
										amountPaid = Double.parseDouble(temp);
									}catch (NumberFormatException e) {
									    System.out.println("Sorry but there was a problem with that number. Please try again.");
									}
								}while(amountPaid <= 0);
								
								
								payment = new CreditPayment(ccNumber, expDate, amountPaid, today);
								
								validInput = true;
								break;
							case "3":
								
								validInput = true;
								break;
							default:
								System.out.println("Sorry but that isn't a valid option. Please try again.");
								validInput = false;
						}
						
						amountDue -= amountPaid;
					}while ( !validInput &&  amountDue > 0);
					
					if(amountDue < 0)
					{
						System.out.println("You have been refunded: " + (-1 * amountDue) );
					}
						
					System.out.println("Exit Gate Open.");
					System.out.println("Driver leaves garage.");
					System.out.println("Exit Gate Closes.");
					exit.removeCarFromGarage(ticketNumber);
					printOccupancyInfo();
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
