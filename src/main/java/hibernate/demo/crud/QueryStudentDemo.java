package hibernate.demo.crud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			// Query the Student class
			List<Student> theStudents = session.createQuery("from Student").list();

			// Display the Student class
			displaysStudents(theStudents);

			// Query Students on the basis of lastName
			theStudents = session.createQuery("from Student s where s.lastName='khanna'").list();

			// Display the Students
			System.out.println("\n\nStudents who have last name of khanna ");
			displaysStudents(theStudents);

			// Query Students on the basis of OR operator
			theStudents = session.createQuery("from Student s where s.lastName='khanna'" + " OR s.firstName = 'hardik'").list();
					
			//Display the Students
			System.out.println("\n\nFiltered on the basis of OR Operator");
			displaysStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
			System.out.println("\n\n Query on the basis of LIKE operator");
			
			//Display the Query
			displaysStudents(theStudents);
			
			System.out.println("Done!");
			
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

	private static void displaysStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
