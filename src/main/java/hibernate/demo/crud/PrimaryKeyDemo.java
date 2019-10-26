package hibernate.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			Student tempStudent1 = new Student("Nishant", "Rakha", "nishant.rakha@gmail.com");
			Student tempStudent2 = new Student("Oshin", "Dhaliwal", "oshin.dhaliwal@gmail.com");
			Student tempStudent3 = new Student("Mohit", "Raheja", "mohit.raheja@gmail.com");
			session.beginTransaction();
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.getTransaction().commit();

		} finally {
			factory.close();

		}
	}
}
