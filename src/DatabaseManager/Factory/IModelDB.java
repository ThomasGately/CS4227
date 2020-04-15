package DatabaseManager.Factory;

import Models.IModel;

public interface IModelDB<T> {

    public abstract boolean add(T item) throws Exception;

    public abstract boolean remove(int id) throws Exception;

    public abstract T findById(int id) throws Exception;

    public abstract T findByParameters(String... parameters) throws Exception;
}