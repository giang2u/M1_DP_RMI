package server;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import download.Product;



public class WarehouseServer {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		System.out.println("Constructing...");
		WarehouseImpl centralWarehouse = new WarehouseImpl(new Book("BackupBook","123456",66.99));
		
		centralWarehouse.add("toaster", new Product("Blackwell Toaster",23.95));
		
		
		System.out.println("Binding server to reg");
		Registry registry = LocateRegistry.getRegistry();
		registry.bind("central_warehouse", centralWarehouse);
		
		System.out.println("Waiting for invocations from clients... ");
		
	}

}
