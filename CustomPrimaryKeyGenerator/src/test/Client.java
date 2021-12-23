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
		customGeneratorKeyTest(s,t);
		t.commit();
		s.close();
		sf.close();
	}

	private static void customGeneratorKeyTest(Session s, Transaction t) {
		Student obj = new Student(null, "Shivam", "sk@gmail.com", "Narkatiaganj");
		s.save(obj);
		t.commit();
		
	}

	

}
