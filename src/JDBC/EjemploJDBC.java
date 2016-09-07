package JDBC;



public class EjemploJDBC {
    public static void main(String[] args) {
        Estudiante e = new Estudiante();
        e.setNombre("Luis");
        e.setMatricula("2016-7624");
        e.setNota(39);
        
        EstudianteDAOImpl dao = 
                new EstudianteDAOImpl(new MySQLDBConnection());
        dao.guardar(e);
    }
}
