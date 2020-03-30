package DatabaseManager.RepositoryV2;

import java.util.Collection;

public interface IRepository<T> {

    public abstract void add(T item);

    public abstract void remove(int id);

    public abstract T findById(int id);
}
