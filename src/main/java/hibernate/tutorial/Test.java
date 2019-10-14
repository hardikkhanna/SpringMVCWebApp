package hibernate.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String uname = "hbstudent";
		String pass = "hbstudent";
		
		try{
			
			System.out.println("Connecting to database "+jdbcUrl);
			Connection conn = DriverManager.getConnection(jdbcUrl, uname, pass);
			System.out.println("Successfuly connected to database");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
