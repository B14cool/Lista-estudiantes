package JDBC;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EstudianteDAOImpl implements EstudianteDAO {
    private DBConnection dbcon;

    public EstudianteDAOImpl(DBConnection dbcon) {
        this.dbcon = dbcon;
    }
    
    @Override
    public void guardar(Estudiante e) {
        Connection con = null;
        PreparedStatement pstmnt = null;
        
        try {
            con = dbcon.conectar();
            
            String sql = "INSERT INTO notas(nombre, matricula, nota) "
                    + "VALUES(?, ?, ?)";
            
            pstmnt = con.prepareStatement(sql);
            
            pstmnt.setString(1, e.getNombre());
            pstmnt.setString(2, e.getMatricula());
            pstmnt.setInt(3, e.getNota());
            
            pstmnt.execute();
            
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BD");
        }
        finally {
            dbcon.desconectar(con);
        }
    }

    @Override
    public List<Estudiante> extraerTodos() {
        Connection con = null;
        Statement stmnt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM notas";
        List<Estudiante> lista = new ArrayList<>();    
        
        try {
            con = dbcon.conectar();
            stmnt = con.createStatement();
            rs = stmnt.executeQuery(sql);
            
            while (rs.next()) {
            lista.add(new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("matricula"),
                    rs.getInt("nota")
            ));
        }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }
    
}
