package Connect;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class ReadFile {
    public static void main(String[] args) throws SQLException, IOException {
        Connection connection = TestConnectDB.getJDBCConnection();
        String sql = "Select * from file";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            Blob file = resultSet.getBlob("file");
            byte[] b = file.getBytes(1,(int)file.length());
            FileOutputStream fileOutputStream = new FileOutputStream(name);
            fileOutputStream.write(b);
            fileOutputStream.close();
        }
    }
}
