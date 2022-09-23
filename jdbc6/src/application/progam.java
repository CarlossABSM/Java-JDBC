package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

  // trasações no banco de dados  //

public class progam {

	public static void main(String[] args) throws SQLException {
	   
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			conn.setAutoCommit(false);
			
			st = conn.createStatement();
			
		    int rows1 = st.executeUpdate("UPDATE seller SET Basesalary = 2090 WHERE DepartmentId = 1");

		   // int x = 1; para poder atualizar para 2090 !!!
		    //if (x < 2) {
		      // throw new SQLException ("Fake error ");
		    //}
		    
		    int rows2 = st.executeUpdate("UPDATE seller SET Basesalary = 3090 WHERE DepartmentId = 2");
		    
		    conn.commit();
		    
            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);   
		}   
	    catch (SQLDataException e) {
	    	try { 
	    	conn.rollback();
	    	throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
		  } catch (SQLException e1) {
			throw new DbException("Error tryng to rollback! Caused by: " + e1.getMessage());
			
			 // e1.printStackTrace();
		  }
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		   
   }
}
}

		
	
		


