package cs414.a4.rbetten;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.EventObject;

import javax.swing.*;

public class ParkingGarageJFrame implements ActionListener
{
	private ParkingGarage garage;
	private int maxOccupancy;
	private static String garageOccupancyPrefix = "Cars in garage: ";
    private JButton entryButton, exitButton, adminButton;
    private JLabel occupancyLabel;
    
    private static String maxOccupancyPrefix = "Please enter maximum cars in garage: ";
    private JLabel maxOccupancyLabel;
    private JButton maxOccupancyButton;
    private JTextField maxOccupancyField;
    private static String errorStringPrefix = "Error: ";
    private static String invalidOccupancyInput = "Please enter integer greater than 0";
    
    private JLabel errorLabel;
    
    private JLabel entranceTicketLabel;
    
    private JLabel exitTicketLabel;

    //Specify the look and feel to use.  Valid values:
    //null (use the default), "Metal", "System", "Motif", "GTK+"
    final static String LOOKANDFEEL = null;

    public Component createComponents() 
    {
    	occupancyLabel = new JLabel(garageOccupancyPrefix);
        maxOccupancyLabel = new JLabel(maxOccupancyPrefix);
        errorLabel = new JLabel(errorStringPrefix);
        entranceTicketLabel = new JLabel("");
        /*
         * An easy way to put space between a top-level container
         * and its contents is to put the contents in a JPanel
         * that has an "empty" border.
         */
        JPanel pane = new JPanel(new GridBagLayout());
        
        userInitGarage();
    	createEntryButton();
        createExitButton();
        createAdminButton();
        
        GridBagConstraints constraints = new GridBagConstraints();
        
        showMaxOccupancyScene(true);
        showParkingGarageScene(false);
        showEntranceGateScene(false);
        showExitGateScene(false);
        showAdminScene(false);
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        pane.add(maxOccupancyLabel, constraints);
        
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        pane.add(maxOccupancyField, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 0;
        pane.add(maxOccupancyButton, constraints);
        
        constraints.gridx = 0;
       	constraints.gridy = 0;
        pane.add(occupancyLabel, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        pane.add(entryButton, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        pane.add(exitButton, constraints);
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        pane.add(adminButton, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        pane.add(errorLabel, constraints);
        errorLabel.setVisible(false);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        pane.add(entranceTicketLabel, constraints);
        
        pane.setBorder(BorderFactory.createEmptyBorder(
        												30,   //top
        												80,   //left
        												30,   //bottom
        												80)); //right

        return pane;
    }
    
    private void userInitGarage()
    {
    	maxOccupancyButton = new JButton("Click to save value");
    	maxOccupancyButton.addActionListener(this);
    	maxOccupancyField = new JTextField(10);
    }
    
    private void showEntranceGateScene(boolean status)
    {
    	entranceTicketLabel.setVisible(status);
    }
    
    private void showExitGateScene(boolean status)
    {
    	
    }
    
    private void showAdminScene(boolean status)
    {
    	
    }
    
    private void showMaxOccupancyScene(boolean status)
    {
    	maxOccupancyLabel.setVisible(status);
    	maxOccupancyField.setVisible(status);
    	maxOccupancyButton.setVisible(status);
    }
    
    private void createEntryButton()
    {
    	entryButton = new JButton("Entrance Gate");
        entryButton.setMnemonic(KeyEvent.VK_I);
        entryButton.addActionListener(this);
    }

    private void createExitButton()
    {
    	exitButton = new JButton("Exit Gate");
    	exitButton.setMnemonic(KeyEvent.VK_I);
    	exitButton.addActionListener(this);
    }
    
    private void createAdminButton()
    {
    	adminButton = new JButton("Admin Options");
    	adminButton.setMnemonic(KeyEvent.VK_I);
    	adminButton.addActionListener(this);
    }
    
    private void showParkingGarageScene(boolean status)
    {
    	occupancyLabel.setVisible(status);
    	if(status)
    	{
    		updateOccupancyLabel();
    	}
    	entryButton.setVisible(status);
    	exitButton.setVisible(status);
    	adminButton.setVisible(status);
    }
    
    private void updateOccupancyLabel()
    {
    	occupancyLabel.setText(garageOccupancyPrefix + garage.getCarOccupancy() + "/" + maxOccupancy);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    	errorLabel.setVisible(false);
    	if(e.getSource() == maxOccupancyButton)
    	{
    		maxOccupancyInput();
    	} 
    	else if(e.getSource() == entryButton)
    	{
    		entranceGateInput();
    	}
    	else if(e.getSource() == exitButton)
    	{
    		ExitGate gate = garage.getExitGate();
    		    		

			showEntranceGateScene(false);
			showExitGateScene(true);
			showAdminScene(false);
    	}
    	else if(e.getSource() == adminButton)
    	{

			showEntranceGateScene(false);
			showExitGateScene(false);
			showAdminScene(true);
    	}
    }
    
    private void entranceGateInput()
    {
    	if( !garage.checkGarageSpace() )
		{
			EntryGate gate = garage.getEntranceGate();
			Ticket ticket = gate.checkinCar();
			entranceTicketLabel.setText("Ticket Number: " + ticket.getUniqueID());
			
			updateOccupancyLabel();
			showEntranceGateScene(true);
			showExitGateScene(false);
			showAdminScene(false);
		}
    }
    
    private void maxOccupancyInput()
    {
		String userInput = maxOccupancyField.getText();
		try
	    {
	        maxOccupancy = Integer.parseInt(userInput);
	        if(maxOccupancy < 1)
	        {
	        	maxOccupancyField = new JTextField(10);
	        	errorLabel.setText(errorStringPrefix + invalidOccupancyInput);
	        	errorLabel.setVisible(true);
	        } 
	        else 
	        {
	        	garage = new ParkingGarage(maxOccupancy);
	        	showMaxOccupancyScene(false);
	        	showParkingGarageScene(true);
	        }
	    }
	    catch(NumberFormatException ex)
	    {
	    	maxOccupancyField = new JTextField(5);
        	errorLabel.setText(errorStringPrefix + invalidOccupancyInput);
        	errorLabel.setVisible(true);
	    }
    }

    private static void initLookAndFeel()
    {
        String lookAndFeel = null;

        if (LOOKANDFEEL != null)
        {
            if (LOOKANDFEEL.equals("Metal")) 
            {
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("System")) {
                lookAndFeel = UIManager.getSystemLookAndFeelClassName();
            } else if (LOOKANDFEEL.equals("Motif")) {
                lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            } else if (LOOKANDFEEL.equals("GTK+")) { //new in 1.4.2
                lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
            } else {
                System.err.println("Unexpected value of LOOKANDFEEL specified: "
                                   + LOOKANDFEEL);
                lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
            }

            try 
            {
                UIManager.setLookAndFeel(lookAndFeel);
            } catch (ClassNotFoundException e) 
            {
                System.err.println("Couldn't find class for specified look and feel:"
                                   + lookAndFeel);
                System.err.println("Did you include the L&F library in the class path?");
                System.err.println("Using the default look and feel.");
            } catch (UnsupportedLookAndFeelException e) 
            {
                System.err.println("Can't use the specified look and feel ("
                                   + lookAndFeel
                                   + ") on this platform.");
                System.err.println("Using the default look and feel.");
            } catch (Exception e) 
            {
                System.err.println("Couldn't get specified look and feel ("
                                   + lookAndFeel
                                   + "), for some reason.");
                System.err.println("Using the default look and feel.");
                e.printStackTrace();
            }
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() 
    {
        //Set the look and feel.
        initLookAndFeel();

        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Parking Garage Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ParkingGarageJFrame app = new ParkingGarageJFrame();
        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }


}
