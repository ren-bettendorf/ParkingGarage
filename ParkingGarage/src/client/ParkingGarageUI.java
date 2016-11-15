package client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import common.AdminPayment;
import common.CashPayment;
import common.CreditPayment;
import common.ExitGate;
import common.Payment;
import common.Ticket;
import server.ParkingGarage;

public class ParkingGarageUI
{
	static Scanner input = new Scanner(System.in);
	static ParkingGarage garage;
	static int maxOccupancy;
	static boolean runApp = true;

	public static void main(String[] args) 
	{
		// Welcome message
		System.out.println("Parking Garage Application has started. ");
		System.out.println("Before we officially begin though we need to get the size of the Garage.");
		System.out.println("It is important this is a positive integer!");

		// Method to get the Parking Garage size
		inputGarageSize();

		// Creates Parking Garage to be used
		garage = new ParkingGarage(maxOccupancy);

		// Main App Loop
		while(runApp)
		{
			String userChoice = displayUserChoiceMenu();
			evaluateUserChoice(userChoice);
		}
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
			// Check if space for another car
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
			String ticketNumber = input.nextLine();
			ExitGate exit = garage.getExitGate();

			// Check to see if the car has paid for their ticket
			if( exit.attemptCheckoutCar(ticketNumber) )
			{

				Payment payment = null;
				double amountDue = exit.amountDueOnTicket(ticketNumber);

				// User given option to pay with cash, card, or admin problems
				System.out.println("Ticket found. Ticket amount due is : " + amountDue);
				System.out.println("1.. Cash Payment");
				System.out.println("2.. Credit Payment");
				System.out.println("3.. Need help from an Administrator.");

				String userIn = input.nextLine();
				LocalDateTime ldt = LocalDateTime.now();
				LocalDateTime today = LocalDateTime.of(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(), 0);
				double amountPaid = 0.00;

				switch(userIn)
				{
				case "1":

					// Figures out how much user has paid
					amountPaid = getAmountUserPaid();
					// If user paid a negative amount catch the error
					try
					{
						payment = new CashPayment(amountPaid, today);
					}catch(IllegalArgumentException e)
					{
						System.out.println("Sorry there was a problem with your payment");
					}
					break;
				case "2":
					// Collect credit card number
					System.out.println("Please enter the credit card number (no dashes): ");
					String ccNumber = input.nextLine();

					LocalDateTime expDate = null;
					boolean validDate = true;
					// Loop to get a correct date in correct Format
					do
					{
						DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/yyyy"); 
						try 
						{
							System.out.println("Please enter the expiration date (MM/YYYY): ");
							expDate = (LocalDateTime) df.parse(input.nextLine());
							validDate = true;
						} catch (Exception e) {
							System.out.println("Sorry but there was a problem with that entry. Please try again.");
							validDate = false;
						}
					}while( !validDate );

					amountPaid = getAmountUserPaid();
					// If user paid a negative amount catch the error
					try
					{
						payment = new CreditPayment(ccNumber, expDate, amountPaid, today);
					}
					catch(Exception e)
					{
						System.out.println("There was a problem with your payment");
						amountPaid= 0;
					}

					break;
				case "3":
					payment = createAdminPayment(ldt, amountDue);
					amountDue = 0;
					break;
				default:
					System.out.println("Sorry but that isn't a valid option. Please try again.");
					break;
				}

				amountDue -= amountPaid;

				if(amountDue <= 0 && payment != null)
				{
					// Refund if paid more than necessary
					if(amountDue < 0)
					{
						System.out.println("You have been refunded: " + (-1 * amountDue) );
					}
					System.out.println("Exit Gate Open.");
					System.out.println("Driver leaves garage.");
					System.out.println("Exit Gate Closes.");
					exit.removeCarFromGarage(ticketNumber, payment);
					printOccupancyInfo();

				}else 
				{
					System.out.println("I'm sorry but the ticket wasn't paid in full. Please see an Admin to sort out");
				}


			}
			else
			{
				System.out.println("Sorry but the ticket number was not found. Please try again or ask for an Administrator.");
			}

			break;
		case "4": 
			boolean validDate = true;
			LocalDateTime begin = null;
			DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 

			// Loop to get a correct date in correct Format
			do
			{
				System.out.println("Please enter the beginning query date (MM/dd/yyyy): ");
				try
				{
					begin = (LocalDateTime) df.parse(input.nextLine());
					validDate = true;
				}
				catch(Exception e)
				{
					System.out.println("Sorry but that date isn't recognized.");
					validDate = false;
				}
			}while ( !validDate );

			LocalDateTime end = null;

			// Loop to get a correct date in correct Format
			do
			{	
				System.out.println("Please enter the expiration date (MM/dd/YYYY): ");
				try
				{
					end = (LocalDateTime) df.parse(input.nextLine());
					validDate = true;
				}
				catch(Exception e)
				{
					System.out.println("Sorry but that date isn't recognized.");
					validDate = false;
				}
			}while( !validDate );


			// Print out the reports!
			System.out.print(garage.runOccupationReports(begin, end));
			System.out.print(garage.runFinancialReports(begin, end));
			break;
		case "5":
			// Leave app
			System.out.println("Exiting Application...");
			runApp = false;

			break;
		default:
			System.out.println("I'm sorry but something went wrong with your choice. Please try again.");
			break;
		}
	}

	/**
	 * Gets the garage size
	 */
	private static void inputGarageSize()
	{
		// Loop to get a correct date in correct Format
		do 
		{	
			while ( !input.hasNextInt() ) 
			{
				System.out.println("Sorry but that isn't a positive integer. Try again!");
				input.nextLine(); 
			}
			maxOccupancy = input.nextInt();
		} while (maxOccupancy < 1);
	}

	/**
	 * Print out Occupancy Info
	 */
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

	/**
	 * Displays choices user can make and gets the user input
	 * @return userChoice
	 */
	private static String displayUserChoiceMenu()
	{
		System.out.println("\nGARAGE VACANCY STATUS " + !garage.checkGarageSpace());
		System.out.println("Please select one of the following options:");

		System.out.println("1.. Display current availability.");
		System.out.println("2.. Dispense a ticket.");
		System.out.println("3.. Pay for ticket.");
		System.out.println("4.. Administrator Only: View usage reports.");  
		System.out.println("5.. Quit.\n");

		String userChoice = input.nextLine();

		return userChoice;
	}

	/**
	 * Creates an admin payment
	 * @param ldt
	 * @param amountDue
	 * @return
	 */
	private static Payment createAdminPayment(LocalDateTime ldt, double amountDue)
	{
		input.nextLine();
		System.out.println("Please enter the address");
		String userAddress = input.nextLine();
		System.out.println("Please enter the name");
		String userName = input.nextLine();
		System.out.println("Please enter the phone number");
		String userPhoneNumber = input.nextLine();

		Payment payment = new AdminPayment(userAddress, userName, userPhoneNumber, amountDue, ldt);
		return payment;
	}

	/**
	 * Gets the amount the user pays by asking user how much they paid
	 * @return
	 */
	private static double getAmountUserPaid()
	{
		double amountPaid = 0;
		do
		{
			System.out.println("How much cash was inserted (must be > 0 and is truncated to two decimal places)? ");
			String temp = input.nextLine();
			try
			{
				amountPaid = Double.parseDouble(temp);
			}catch (NumberFormatException e) {
				System.out.println("Sorry but there was a problem with that number. Please try again.");
			}
		}while(amountPaid <= 0);
		return amountPaid;
	}

}
