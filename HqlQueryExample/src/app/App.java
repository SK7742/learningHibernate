package app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;


public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		//testForSelectAllRecordsFromATable(s,t);		//Test Case: 01
		//testForSelectSingleRow(s,t);					//Test Case: 02
		testForSelectingMultipleRecords(s,t);			//Test Case: 03
		
		t.commit();
		s.close();
		sf.close();
	}

	private static void testForSelectingMultipleRecords(Session s, Transaction t) {
		//List method is used to retrieve multiple row/column data
		//Data retrieved in the form of array, we need to cast and store accordingly.
		Query q = s.createQuery("select email, address from Student t");
		List<Object> addressList = q.list();
		addressList.forEach((e) ->{
			Object[] arr = (Object[]) e;
			Student st = new Student();
			st.setEmail((String) arr[0]);
			st.setAddress((String) arr[1]);
			System.out.println(st);
		});
	}

	private static void testForSelectSingleRow(Session s, Transaction t) {
		//Unique Result method is used only for get unique single record...
		Query q = s.createQuery("select email from Student t where t.id = 2");
		String emailId = (String) q.uniqueResult();
		System.out.println(emailId);
	}

	private static void testForSelectAllRecordsFromATable(Session s, Transaction t) {
		Query q = s.createQuery("from Student");
		List<Student> studentList = q.list();
		studentList.forEach((e) ->{
			System.out.println(e);
		});
	}
}
