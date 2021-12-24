package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Admin;
import beans.HardwareEmployee;
import beans.SoftwareEmployee;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		SoftwareEmployee se = new SoftwareEmployee(111, "Shivam", "sk@gmail.com", 4000, "Java");
		HardwareEmployee he = new HardwareEmployee(112, "Satyam", "s@gmail.com", 20000, 4);
		Admin ad = new Admin(113, "Sundram", "sk@outlook.com", 50000, "IT");
		
		s.save(se);
		s.save(he);
		s.save(ad);
		t.commit();
		s.close();
		sf.close();
	}
}
