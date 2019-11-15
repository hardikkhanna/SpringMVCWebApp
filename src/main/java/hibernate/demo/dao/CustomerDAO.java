package hibernate.demo.dao;

import java.util.List;

import hibernate.demo.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomers();
	public List<Customer> updateCustomers();
}
