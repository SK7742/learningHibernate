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
		
		//Create Student Object
		Student st = new Student();
		st.setAddress("Raxaul");
		st.setEmail("sk@gmail.com");
		st.setId(2);
		st.setName("ShivamKumar");
		
		/*int pk = (int) s.save(st); //Primary key will be returned by save method.
		System.out.println(pk);*/
		
		//s.saveOrUpdate(st); //this method will search for the object and if no match found then save otherwise will be updated...
		
		//s.delete(st); //st object will be deleted if found.
		
		s.update(st); //st object will be updated if found otherwise throw exception.
		t.commit();
		s.close();
		sf.close();
	}

}
