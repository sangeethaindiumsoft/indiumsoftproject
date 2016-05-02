package dataInfo;
import java.sql.*;

	public class DBAccess{
	   public static void main(String[] args) {

	      // Create a variable for the connection string.
		  String Connectionurl="jdbc:sqlserver://204.51.249.147;DatabaseName=iscoute_temp;user=sa;Password=isil@123";

	      // Declare the JDBC objects.
	      Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;

	      try {
	         // Establish the connection.
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         con = DriverManager.getConnection(Connectionurl);

	         // Create and execute an SQL statement that returns some data.
	         String SQL = "SELECT * FROM IS_Transactions";
	         stmt = con.createStatement();
	         rs = stmt.executeQuery(SQL);

	         // Iterate through the data in the result set and display it.
	         while (rs.next()) {
	            System.out.println(rs.getString(4) + " " + rs.getString(6));
	         }
	      }

	      // Handle any errors that may have occurred.
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      finally {
	         if (rs != null) try { rs.close(); } catch(Exception e) {}
	         if (stmt != null) try { stmt.close(); } catch(Exception e) {}
	         if (con != null) try { con.close(); } catch(Exception e) {}
	      }
	   }
	}


	


