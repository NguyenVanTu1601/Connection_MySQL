package Connect;
import java.sql.*;

public class TestConnectDB {
    public static Connection getJDBCConnection() {
         String className = "com.mysql.cj.jdbc.Driver";
         String url = "jdbc:mysql://localhost:3306/tunguyen";
         String user = "root";
         String pass = "nguyenvantu";
         String table = "_update";
            try{
                Class.forName(className);
                return DriverManager.getConnection(url,user,pass);

            }catch(ClassNotFoundException e){
                System.out.println("Class not found!");
                System.out.println("Error Found " + e.getMessage());
            } catch(SQLException e){
                System.out.println("Error connection!");
                System.out.println("Error SQL " + e.getMessage());
            }
            return null;
    }

}
