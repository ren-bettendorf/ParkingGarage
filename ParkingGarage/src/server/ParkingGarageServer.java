package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ParkingGarageServer extends UnicastRemoteObject {
	private String url;

	public ParkingGarageServer(String url) throws RemoteException {
		this.url = url;
		try {
			ParkingGarageImpl garage = new ParkingGarageImpl(10);
			Naming.rebind(url, garage);
			System.out.println("Bank server running...");
		} catch (RemoteException re) {
			System.out.println("Trouble: " + re);
		} catch (MalformedURLException murle) {
			System.out.println("Trouble: " + murle);
		}
	}

	// run the program using
	// java CalculatorServer <host> <port>

	public static void main(String args[]) {
		String url = new String("rmi://" + args[0] + ":" + args[1] + "/ParkingGarage");
		try {
			new ParkingGarageServer(url);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
