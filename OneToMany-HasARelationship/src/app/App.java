package app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Actor;
import beans.Movies;


public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Movies m = new Movies();
		//m.setActorId(1);
		m.setMovieId(1);
		m.setMovieName("PK");
		Set<Movies> mo = new HashSet<Movies>();
		mo.add(m);
		Actor a = new Actor();
		a.setActorId(1);
		a.setActorName("sk");
		a.setMovies(mo);
		
		s.save(a);
		t.commit();
		s.close();
		sf.close();
	}
}
