

import java.sql.*;


public class DataBaseService {
	
    public static  String className = "com.mysql.jdbc.Driver";
    public static  String chaine = "jdbc:mysql://localhost:3306/studentbib";
    public static  String username = "root";
    public static  String password = "root";
    
    
    public Connection connecter()   {

        Connection con = null;
        try {
            Class.forName(className);
            con = DriverManager.getConnection(chaine, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public String getStudentFirstName() {
    	   Connection conn = null;
    	   String s="";
    	   Statement st = null;
           String query = "select * from student";
           conn = connecter();
           try {
			st=conn.createStatement();
	        ResultSet rs = st.executeQuery(query);
	        while(rs.next()) {
	        	s=rs.getString("firstName");
	        }
           } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           try {
			conn.close(); 
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
           
           return s;
      
    	
    }
    
    
 
    
   
    public boolean processLogin(String user) {
    	Connection conn = null;
    	boolean results = false;
    	conn = connecter();
        try {
        	
            Statement st = conn.createStatement();
            String query = "SELECT * FROM  User where userName='" + user + "'";
            ResultSet res = st.executeQuery(query);
            results = res.next();
            conn.close(); 
			st.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return results;
    } 

  



}
