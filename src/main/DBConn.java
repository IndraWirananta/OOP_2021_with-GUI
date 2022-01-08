package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {

    Connection conn;
    Statement stmt;

    public DBConn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kfp", "root", "");
        stmt = conn.createStatement();
    }

    public ResultSet query(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int queryDML(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }
}
