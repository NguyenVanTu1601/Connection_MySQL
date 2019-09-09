package Connect;
import java.sql.*;
public class Connect_Database {
    private final String className = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/tunguyen";
    private final String user = "root";
    private final String pass = "nguyenvantu";
    private Connection connection;
    private String table = "_update";
    private void connect(){
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
    }

    private ResultSet getData(){ // Lấy dữ liệu
        ResultSet rs = null; // Chứa các bản ghi
        String sqlCommand = "select * from "+ table; // Cấu trúc câu lênh
        Statement st;
        try{
            st = connection.createStatement();
            rs = st.executeQuery(sqlCommand);// thực thi câu lệnh của Mysql = try catch
        }catch(SQLException e){
            System.out.println("Sellect Error!");
        }
        return rs;
    }

    private void showData(ResultSet rs){ // Hiển thị dư liệu
        try{
            while(rs.next()){
                System.out.printf("%-20d %-20s %-20d %-5.2f",rs.getInt(1),rs.getString(2), rs.getInt(3)
                ,rs.getFloat("avg"));
                System.out.println();
            }
        }
        catch(SQLException e){
        }
    }

    private ResultSet getDataId(String id){
        ResultSet rs = null; // Chứa các bản ghi
        String sqlCommand = "select * from "+ table + " where id = ?"; // Cấu trúc câu lênh
        PreparedStatement pst = null; // Thay thế 1 số hạn chế của Staterment trong việc dùng vs where
        try{
            pst = connection.prepareStatement(sqlCommand);
            pst.setString(1, id); // Thay dau hoi thu nhat = id truyen vao
            rs = pst.executeQuery();// thực thi câu lệnh của Mysql = try catch -- ko cần tham số khác vs sd Stament
            // Dung lay du lieu
        }catch(SQLException e){
            System.out.println("Select Error!" + e.toString());
        }
        return rs;
    }

    private void DeleteId(int Id, String name){
         String delete = "delete from "+ table + " where id = ? and name = ?";
         PreparedStatement pst = null;
         try{
             pst = connection.prepareStatement(delete);
             pst.setString(1,Integer.toString(Id));
             pst.setString(2,name);
             if(pst.executeUpdate() > 0){
                 System.out.println("Delete success!");
             }
             else System.out.println("Delete error!");
         }catch(SQLException e){
             System.out.println( e.toString());
         }
    }
    private void Delete_with_Statement(int Id){
        String delete = "delete from "+ table + " where id = " + Id;
        try{
            Statement statement = connection.createStatement();
            if(statement.executeUpdate(delete) > 0){
                System.out.println("Delete success !");
            }
            else System.out.println("Delete Error!");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void Insert_Into(_update up){
        String insert = "Insert Into " + table + " values(?, ?, ?, ?)";
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(insert);
            pst.setString(1,Integer.toString(up.getId()));
            pst.setString(2,up.getName());
            pst.setString(3, Integer.toString(up.getAge()));
            pst.setString(4,Float.toString(up.getAvg()));
            if (pst.executeUpdate() > 0) {
                System.out.println("insert success");
            } else {
                System.out.println("insert error \n");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }


    private void Update(int Id, _update up){
        String update = "update " + table + " set age = ?, avg = ? where id = ?";
        PreparedStatement pst = null;
        try{
            pst = connection.prepareStatement(update);
            pst.setString(1, Integer.toString(up.getAge()));
            pst.setString(2, Float.toString((float)up.getAvg()));
            pst.setString(3,Integer.toString(Id));
            if(pst.executeUpdate() > 0){
                System.out.println("Update success!");
            }
            else System.out.println("Update error!");
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    private void ReName(String column, String name){
        PreparedStatement pst = null;
        String change_column = column;
        String kieu_du_lieu = " varchar(250)";
        String rename = "Alter table " + table + " change " + column + " " + name + " " +  kieu_du_lieu;
        try{
            pst = connection.prepareStatement(rename);
           // pst.setString(1, name);
            if(pst.executeUpdate() >= 0){
                System.out.println("Update success!");
            }
            else System.out.println("Update error!");

        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }

    public static void main(String[] args) {
        Connect_Database connect_database = new Connect_Database();
        connect_database.connect();
        //connect_database.showData(connect_database.getDataId("1"));
        //connect_database.Insert_Into(new _update(1,"Tu",21, (float) 3.25));
        //connect_database.Update(1, new _update(1, "Tu", 22,(float)3.4));
        //connect_database.ReName("Name", "name");
        connect_database.Delete_with_Statement(5);
    }
}
