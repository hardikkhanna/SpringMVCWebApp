package hibernate.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			int id = 4;
			
			//Alternate way
			/*Student myStudent = session.get(Student.class, id);
			session.delete(myStudent);
			session.getTransaction().commit();*/
			
			session.createQuery("delete from Student s where s.firstName = 'mohit'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			

		} finally {
			factory.close();
		}

	}

}
