package hibernate.demo.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating the student");
			Student tempStudent = new Student("Daffy", "Duck", "daffy@gmail.com");
			session.beginTransaction();
			System.out.println("Saving the Student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			session.getTransaction().commit();

			// Find out the student's id : primary key
			System.out.println("Saved student. Generated id : " + tempStudent.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete " + myStudent);

			System.out.println("Done");

		} finally {

		}
	}
}
