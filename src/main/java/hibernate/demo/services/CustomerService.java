package hibernate.demo.services;

import java.util.List;

import hibernate.demo.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomers(int theId);
	
}
