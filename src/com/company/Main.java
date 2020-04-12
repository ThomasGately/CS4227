package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/UI/Login/FXLoginView.fxml"));
        primaryStage.setTitle("Hotel Booking");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:6603/CS4227","tom","password");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}

        launch(args);
    }

}