package com.gdevlast.counceltracker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by gsharma on 08/03/18.
 */

public class Customer
{
	private static ArrayList<Customer> customers = new ArrayList<>();
	private static HashMap<String, Customer> customerMap = new HashMap<>();
	private String name;
	private ArrayList<CustomerInteraction> interactions = new ArrayList<>();

	public Customer(String name)
	{
		this.name = name;
	}

	public String getName() { return name; }

	public ArrayList<CustomerInteraction> getInteractions() { return interactions; }

	public void addInteraction(CustomerInteraction interction) { interactions.add(interction); }

	public static ArrayList<Customer> getCustomers() { return customers; }

	public static void addCustomer(Customer c)
	{
		customers.add(c);
		customerMap.put(c.getName(), c);
	}

	public static Customer getCustomer(String name) { return customerMap.get(name); }
}
