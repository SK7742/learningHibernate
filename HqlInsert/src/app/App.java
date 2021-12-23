package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		OldStudent os = new OldStudent(111, "Shivam", "Abc@gmail.com", "Narkatiaganj");
		OldStudent os2 = new OldStudent(112, "Shivam", "Abc@gmail.com", "Narkatiaganj");
		OldStudent os3 = new OldStudent(113, "Shivam", "Abc@gmail.com", "Narkatiaganj");
		
		s.save(os);
		s.save(os2);
		s.save(os3);
		t.commit();
		s.close();
		sf.close();
	}
}
