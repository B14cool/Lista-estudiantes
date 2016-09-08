package JDBC.dao;


import java.util.List;


public interface GenericDAO<E> {
    public void guardar(E e);
    public List<E> extraerTodos();
}
