package client;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import download.Product;
import download.Warehouse;



public class WarehouseClient {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
		
		Registry registry = LocateRegistry.getRegistry();
		
		System.out.println("RMI registry bindings:");
		String[] e = registry.list();
		
		for(int i=0; i<e.length; i++) {
			System.out.println(e[i]);
		}
		
		String remoteObjectName="central_warehouse";
		Warehouse centralWarehouse = (Warehouse)registry.lookup("central_warehouse");
		
		ArrayList<String> l = new ArrayList<String>();
		l.add("pluto");
		Product p = centralWarehouse.getProduct(l);
		
		System.out.println("Desc: " + p.getDescription());
		
		
		/*
		 * version deprecated
		  rmic server.WarehouseServer
		  rmic client.WarehouseClient
		  rmiregistry
		  
		  
		  version du cours 
		  rmiregistry -J-Djava.rmi.server.codebase=http://localhost/bin/download/Warehouse &
		  
		  java -DJava.rmi.server.codebebase=file:///~/workspace/M1/M1_DP_RMI/bin/ -Djava.security.policy=../src/server/my_rmi_policy server.WarehouseServer
		  
		  java -DJava.rmi.server.codebebase=file:///~/workspace/M1/M1_DP_RMI/bin/ -Djava.security.policy=../src/server/my_rmi_policy client.WarehouseClient
		  
		  
		 */
	}

}
