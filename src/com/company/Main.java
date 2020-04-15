package com.company;

import DatabaseManager.Factory.ModelDBFactory;
import DatabaseManager.Repository.DBConfig;
import Models.CustomerModel;

import static DatabaseManager.Factory.ModelDBFactory.FactoryType.Customer;

public class Main {

    public static void main(String args[]) throws Exception {

        DBConfig dbConfig = new DBConfig();

        dbConfig.setDatabaseName("DBCS4227");
        dbConfig.setServerName("kek.ooguy.com");
        dbConfig.setPortNumber("6603");
        dbConfig.setUserName("root");
        dbConfig.setPassword("mypassword");
        dbConfig.setDatabaseConfigInstance(dbConfig);

        ModelDBFactory dbCustomer = ModelDBFactory.getModelDBFactory(Customer);

        if(false) {
            CustomerModel customer = new CustomerModel();
            customer.setUserName("TG");
            customer.setFirstName("Tom");
            customer.setLastName("Gat");
            customer.setAddress("6 the");
            customer.setPhone(123456789);
            customer.setEmailAddress("Tom@Gat.com");
            customer.setPassword("pass");
            customer.setLoyaltyLevel(0);
            customer.setMembership_type(1);
            System.out.println(dbCustomer.add(customer));
        }

//        dbCustomer.findById(CustomerModel.class, 1);

        CustomerModel customer2 = (CustomerModel) dbCustomer.findByParameters("TG", "pass");
        System.out.println(customer2.toString());

    }
}