package Connect;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

// Dùng lấy dữ liệu như statement
public class _RowSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/hello");
        jdbcRowSet.setUsername("root");
        jdbcRowSet.setPassword("nguyenvantu");
        String sql = "SELECT * FROM person";
        jdbcRowSet.setCommand(sql);
        jdbcRowSet.execute();
        while(jdbcRowSet.next()){
            System.out.println(jdbcRowSet.getInt("id") + " " + jdbcRowSet.getString("name"));
        }
    }
}
