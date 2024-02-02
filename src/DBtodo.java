import java.sql.*;

public class DBtodo {

    private String DB = "jdbc:mysql://localhost:3306/homework_0102";
    private String USER = "root";

    private String PASS = "Fantastische9klein!";

    // add, delete, update
    //add = insert
    public void add(String item, int hours) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String insert = "INSERT INTO Todo_list (item, hours) VALUES ('"+ item +"', '"+ hours +"')";
        stmt.executeUpdate(insert);
    }
    public ResultSet select_all() throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String select = "SELECT * FROM Todo_list";
        ResultSet result = stmt.executeQuery(select);
        return result;
    }

    public void delete (int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String d = "DELETE FROM Todo_list WHERE id = "+id;
        stmt.executeUpdate(d);
    }

    public void update (String item, int hours, String status, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String u = "UPDATE Todo_list SET item = '"+ item +"', hours = '"+ hours +"', status = '"+ status +"' WHERE id = "+id;
        stmt.executeUpdate(u);
    }
}
