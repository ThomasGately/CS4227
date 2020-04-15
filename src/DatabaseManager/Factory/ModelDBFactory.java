package DatabaseManager.Factory;

import DatabaseManager.Factory.Models.*;
import DatabaseManager.Repository.IRepository;
import Models.CustomerModel;
import Models.IModel;
import Models.ModelFactory;

import java.sql.ResultSet;
import java.util.function.Supplier;

public abstract class ModelDBFactory<T> {

    protected IRepository repository;
    protected ResultSet resultSet;
    protected String query;
    protected String dQuery;
    protected static String modelInfo;
    protected String tableName;
    protected Class<T> clazz;
    protected FactoryType factoryType;

    public enum FactoryType {
        Card, Customer, Reservation, Room
    }

    public static ModelDBFactory getModelDBFactory(FactoryType type) throws Exception {

        switch (type) {
            case Card:
                return new CardDBFactory();
            case Customer:
                return new CustomerDBFactory();
            case Reservation:
                return new ReservationDBFactory();
            case Room:
                return new RoomDBFactory();
        }
        return null;
    }

    public boolean add(T item) throws Exception {

        query = "INSERT INTO " + tableName +
                " (" + modelInfo + ") " +
                "VALUES (" + item.toString() + ");";
        try{
            repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean remove(int id) throws Exception {

        query = "DELETE " + modelInfo + " " +
                "FROM "   + tableName + " " +
                "WHERE "  + tableName + "_id = " + id + ";";
        try{
            repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public T findById(int id) throws Exception {

        query = dQuery +
                "WHERE "  + tableName + "_id = " + id + ";";
        try{
            resultSet = repository.queryDatabaseStatement(query);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return resultSetToModel(clazz.newInstance());
    }

    public abstract T findByParameters(String... parameters) throws Exception;

    protected abstract T resultSetToModel(T item) throws Exception;
}
