package Connect;
// Quản lý nếu 1 lệnh có ngoại lệ thì coi như thất bại hết các lệnh và ko thực hiện

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = TestConnectDB.getJDBCConnection();
        if(connection != null) System.out.println("Connect success!");
        String s1 = "insert into hello(id,name) values (1,\"B\");";
        String s2 = "Delete from hello where id = 2";
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        Statement statement1 = connection.createStatement();
        statement.executeUpdate(s1);
        statement.executeUpdate(s2);
        connection.commit();
        /* Co thể là ko cần tới vì chạy thử thấy k ảnh hưởng */
    }
}
