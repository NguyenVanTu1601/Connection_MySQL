package Connect;

import java.sql.*;

public class _CallableStatement {
    public static void main(String[] args) throws SQLException {
        String className = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/hello";
        String user = "root";
        String pass = "nguyenvantu";
        String table = "_update";
        Connection connection = null;
        try{
            Class.forName(className);
            connection = DriverManager.getConnection(url,user,pass);
            if(connection != null) System.out.println("Connect success!");
        }catch(ClassNotFoundException e){
            System.out.println("Class not found!");
            System.out.println("Error Found " + e.getMessage());
        } catch(SQLException e){
            System.out.println("Error connection!");
            System.out.println("Error SQL " + e.getMessage());
        }
        CallableStatement callableStatement = connection.prepareCall("{call findPerson(?)}");
        callableStatement.setString(1,"A");
        ResultSet resultSet = callableStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
        }
    }
}
