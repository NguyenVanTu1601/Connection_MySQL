package Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_Processing {
    public static void main(String[] args) throws SQLException {
        Connection connection = TestConnectDB.getJDBCConnection();
        // Statement
        String s1 = "Insert into hello(id,name) values(3,\"A\")";
        String s2 = "Insert into hello(id,name) values(4,\"A\")";
        String s3 = "Insert into hello(id,name) values(5,\"A\")";
        Statement statement = connection.createStatement();
        statement.addBatch(s1);
        statement.addBatch(s2);
        statement.addBatch(s3);
        statement.executeBatch();

        // PreparedStatement
        String s4 = "Insert into hello(id,name) values(?,?)";
        PreparedStatement pst = connection.prepareStatement(s4);
        pst.setInt(1,6);
        pst.setString(2,"B");
        pst.addBatch();

        pst.setInt(1,7);
        pst.setString(2,"C");
        pst.addBatch();
        pst.executeBatch();
    }
}
