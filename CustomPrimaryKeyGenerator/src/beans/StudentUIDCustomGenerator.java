package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentityGenerator;

public class StudentUIDCustomGenerator extends IdentityGenerator {
	String prefix = "CEC/CSE/";
	@Override
	public Serializable generate(SessionImplementor s, Object obj) {
		Connection con  = s.connection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select studentUIDSeq.nextval from dual");
			if(rs.next()) {
				prefix += rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return prefix;
	}
}
