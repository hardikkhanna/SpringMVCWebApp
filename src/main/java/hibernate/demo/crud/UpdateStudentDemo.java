package hibernate.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			int id = 5;
			Student theStudent = session.get(Student.class, id);
			
			theStudent.setEmail("upadte.gmail.com");
			
			session.getTransaction().commit();
			
//			theStudent = session.createQuery("update Student s set s.firstName = 'newname' where s.firstName = 'mohit'");
//			
//			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("update Student s set s.firstName = 'newname' where s.firstName = 'Daffy'").executeUpdate();
			
			session.getTransaction().commit();
			

		} finally {

		}
	}

}
