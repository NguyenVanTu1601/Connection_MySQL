package Connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveFile_inDatabase {
    // Chua tao table trong mysql
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        Connection connection = TestConnectDB.getJDBCConnection();
        File file = new File("text.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        String s5 = "Insert into tableFile(name, file) values(?, ?)";
        PreparedStatement pst = connection.prepareStatement(s5);
        pst.setString(1, "text.txt");
        pst.setString(2, String.valueOf(fileInputStream));
        pst.executeUpdate();
    }
}
