package sonarpack;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DataBaseService {
	
    public static final String className = "com.mysql.jdbc.Driver";
    public static final String chaine = "jdbc:mysql://localhost:3306/studentbib";
    public static final  String username = "root";
    public static final  String password = "root";
    private static final Logger LOGGER = Logger.getLogger( DataBaseService.class.getName() );
    private static final String MSG =      "an error in DataBaseService";            
 ;
    public Connection connecter()   {

        Connection con = null;
        try {
            Class.forName(className);
            con = DriverManager.getConnection(chaine, username, password);
        } catch (ClassNotFoundException | SQLException e) {
        	LOGGER.log(Level.SEVERE,MSG, e);            
        }
        return con;
    }
    
    public String getStudentFirstName() {
    	   
    	   String s="";
    	  
           String query = "select * from student";
           
          
           try( Connection conn = connecter() ; Statement st=conn.createStatement() ; ResultSet rs = st.executeQuery(query);) {
			
	        
	        while(rs.next()) {
	        	s=rs.getString("firstName");
	        }
	       
           } catch (SQLException e) {
	          LOGGER.log(Level.SEVERE,MSG, e);
		   } 
           
        
           return s;
      
    	
    }
    
    
 
    
   
    public boolean processLogin(String user) throws SQLException {
    	Connection conn = null;
    	boolean results = false;
    	conn = connecter();
    	 
         String query = "SELECT * FROM  User where userName=?";
         
        try(PreparedStatement pr = conn.prepareStatement(query); ResultSet res = pr.executeQuery();) {
        	
         
            pr.setString(1, user);  // Compliant; PreparedStatements escape their inputs.
            
            results = res.next();
            
            
        } catch (SQLException e) {
        	LOGGER.log(Level.SEVERE,MSG, e);
        }finally{
        	conn.close(); 
			
        }
        
        return results;
    } 

  



}
