package hibernate.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction tx = currentSession.beginTransaction();

		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		tx.commit();
		// return the results
		return customers;
	}

	public void saveCustomer(Customer theCustomer) {

		// get current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction tx = currentSession.beginTransaction(); // create a update query

		currentSession.saveOrUpdate(theCustomer);
		// save/update the customer finally

		tx.commit();

	}

	public Customer getCustomers(int theId) {

		// get Current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction tx = currentSession.beginTransaction();

		// now retreive/read from Database using the Primary Key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		tx.commit();
		return theCustomer;

	}

	public void deleteCustomer(int theId) {

		// get current Hibernate Session
		Session currentSession = sessionFactory.getCurrentSession();
		Transaction tx = currentSession.beginTransaction(); // create a update query

		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
		// save/update the customer finally

		tx.commit();
	}

}
