package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Client {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		s.get(Student.class, 2); //Line x
		
		//Create Student Object
		Student st = new Student();
		st.setAddress("Raxaul");
		st.setEmail("sk@gmail.com");
		st.setId(2);
		st.setName("Shivam");
		//s.update(st); //At Line x get method returns object of student in session object and here update method will throw an exception
		s.merge(st);
		t.commit();
		s.close();
		sf.close();
	}

}
