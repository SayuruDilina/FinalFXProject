package edu.icet.dao;



import edu.icet.entity.ProductsEntity;
import edu.icet.entity.SuppliersEntity;
import javafx.collections.ObservableList;

public interface CrudDao <T> extends SuperDao{

    ObservableList<T> getAll();
    boolean save(T t);
    void update(T t);
    void delete(T t);


}
