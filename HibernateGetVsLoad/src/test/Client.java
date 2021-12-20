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
		//getMethodTest(s,t);
		loadMethodTest(s,t);
		t.commit();
		s.close();
		sf.close();
	}

	private static void loadMethodTest(Session s, Transaction t) {
		//get method is eager method, it will hit the DB at line 31 so id will be printed and as this id is not exist in the DB.
				//It will throw Object not found exception at line no 31.
				Object o = s.load(Student.class, 101);
				Student st = (Student) o;
				System.out.println(st.getId());
				System.out.println(st.getName());
	}

	private static void getMethodTest(Session s, Transaction t) {
		//get method is eager method, it will hit the DB at line 26 and as this id is not exist in the DB.
		//It will throw null pointer exception but in case of load method it will handled differently.
		Object o = s.get(Student.class, 101);
		Student st = (Student) o;
		System.out.println(st.getId());
		System.out.println(st.getName());
		
	}

}
