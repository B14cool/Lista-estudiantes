package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBConnection implements DBConnection {

    Connection coneccion;
    Statement statement;
    ResultSet resultSet;
    
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:+3306/lista_estudiante?"
                                           + "useSSL=false&user=root&password=root");
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
