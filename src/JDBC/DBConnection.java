package JDBC;


import java.sql.Connection;
import java.sql.SQLException;


public interface DBConnection {
    public Connection conectar() throws SQLException;
    public void desconectar(Connection con);
}
