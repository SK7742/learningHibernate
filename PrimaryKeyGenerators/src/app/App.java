package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.BookMovie;

public class App {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		BookMovie m = new BookMovie();
		//m.setId(1);
		m.setMovie("PK");
		m.setSeatNo(10);
		m.setShowTime("2PM");
		s.save(m);
		t.commit();
		s.close();
		sf.close();
		System.out.println("Insertion Success!!!");
	}

}
