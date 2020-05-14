package Models;

import DatabaseManager.Factory.ModelDBFactory;

public class ModelFactory<T> {

    public static IModel getModelFactory(ModelDBFactory.FactoryType type) throws Exception {
        switch (type) {
            case Card:
                return new CardModel();
            case Customer:
                return new CustomerModel();
            case Reservation:
                return new ReservationModel();
            case Room:
                return new RoomModel();
        }
        return null;
    }

    public T createContents(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
