package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import download.Product;
import download.Warehouse;


public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {

	private Map<String,Product> products;
	private Product backup;
	
	public WarehouseImpl(Product backup) throws RemoteException {
		products = new HashMap<String, Product>();
		this.backup = backup;
	}
	
	public void add(String keyword, Product product) {
		products.put(keyword,  product);
		products.get(keyword).setLocation(this);
	}
	
	public double getPrice(String description) throws RemoteException {
		for (Product p: products.values()) {
			if (p.getDescription().equals(description)) return p.getprice();
		}
		
		return backup == null ? 0 : backup.getprice();
	}

	public Product getProduct(List<String> keywords) throws RemoteException {
		for(String keyword: keywords) {
			Product p = products.get(keyword);
			if(p!=null) return p;
		}
		return backup;
	}


}
