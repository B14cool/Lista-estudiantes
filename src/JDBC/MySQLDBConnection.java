package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBConnection implements DBConnection {

    String host = "root";
    String port = "3306";
    String db = "lista_estudiantes";
    String table = "notas";
    String user = "root";
    String pass = "root";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user="
            + user + "&password=" + pass;
    Connection con;
    Statement stmnt;
    ResultSet rs;

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public void desconectar(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
            }
        }
    }


}
