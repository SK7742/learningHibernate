package app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
//		Employee e = new Employee(111, "abc", "sk@gmail.com", 1000);
//		Employee e1 = new Employee(112, "abcd", "sk@gmail.com", 10800);
//		Employee e2 = new Employee(113, "abcde", "sk@gmail.com", 1050);
//		s.save(e);
//		s.save(e1);
//		s.save(e2);
		
		//selectOperationCriteria(s,t);	//Test Case: 01
		//selectCriteriaUsingRestriction(s,t); //Test Case: 02
		//selectUsingProjects(s,t);		//Test Case: 03
		
		getAvgSalary(s,t);
		t.commit();
		s.close();
		sf.close();
	}

	private static void getAvgSalary(Session s, Transaction t) {
		Criteria c = s.createCriteria(Employee.class);
		Projection p = Projections.avg("salary");
		c.setProjection(p);
		
		c.uniqueResult();
	}

	private static void selectUsingProjects(Session s, Transaction t) {
		Criteria c = s.createCriteria(Employee.class);
		Projection p = Projections.property("email");
		Projection p2 = Projections.property("name");
		ProjectionList list = Projections.projectionList();
		list.add(p);
		list.add(p2);
		c.setProjection(list);
		
		List<Object[]> list2 = c.list();
		list2.forEach((e) ->{
			System.out.println(e[0]);
			System.out.println(e[1]);
		});
		
	}

	private static void selectCriteriaUsingRestriction(Session s, Transaction t) {
		Criteria c = s.createCriteria(Employee.class);
		
		// Criterion is used to implement restriction like where clause
		// Suppose we want to execute the query: "Select *from employee t where t.id=112";
		// Criterion provides methods by which we can implement
		/*Criterion cr = Restrictions.eq("id", 112);
		c.add(cr);
		Employee e = (Employee)c.uniqueResult();
		System.out.println(e.toString());*/
		
		//Query: : select this_.id as id0_0_, this_.name as name0_0_, this_.email as email0_0_, this_.salary as salary0_0_ from learninghibernate.employee this_ where this_.salary>?
		Criterion cr = Restrictions.lt("salary", 1050);
		c.add(cr);
		List<Employee> l = (List<Employee>)c.list();
		l.forEach((x) ->{
			System.out.println(x.toString());
		});
	}

	private static void selectOperationCriteria(Session s, Transaction t) {
		Criteria c = s.createCriteria(Employee.class);
		List<Employee> empList = c.list();
		empList.forEach((x)->{
			System.out.println(x.toString());
		});
	}
}
