package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbIntegrityException;

  // deletando dados no banco de dados  //

public class progam {

	public static void main(String[] args) throws SQLException {
	   
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement()
			
		    int rows1 = st.executeUpdate("UPDATE seller SET Basesalary")

		}
	    catch (SQLDataException e) {
	    	throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
		
	
		


