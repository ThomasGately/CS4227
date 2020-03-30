package DatabaseManager.Factory;

import DatabaseManager.Factory.Models.*;

public abstract class ModelFactory {

    public enum FactoryType {
        User, Card, Reservation, Room
    }

    public static ModelFactory getModelFactory(FactoryType type) {
        switch (type) {
            case User:
                return new UserFactory();
        }
        return null;
    }

}
