package DatabaseManager.Factory;

public interface IModel<T> {

    public abstract void add(T item);

    public abstract void remove(int id);

    public abstract T findById(int id);

    public abstract T findByParameters(String... parameters) throws Exception;
}