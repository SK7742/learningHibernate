package app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import beans.Vote;
import beans.Voter;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Voter v = new Voter();
		v.setName("Shivam");
		v.setVage(50000);
		v.setVoterId(101);
		
		Vote v1 = new Vote();
		v1.setDate(new Date());
		v1.setPartyName("ABC");
		v1.setVoter(v);
		
		/*Vote v2 = new Vote();
		v2.setDate(new Date());
		v2.setPartyName("ABC");
		v2.setVoter(v);*/
		
		//If we uncomment these lines then compiler will throw non unique object exception as the relation mapped is ONE TO ONE.
		
		s.save(v);
		s.save(v1);
		//s.save(v2);
		t.commit();
		s.close();
		sf.close();
	}
}
