package com.github.dafian.app.example.tableview;

import com.github.dafian.app.example.tableview.model.Customer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewNestedColumnExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Customer> tableView = new TableView<>();

        TableColumn<Customer, String> customer = new TableColumn<>("Customer");

        TableColumn<Customer, String> customerId = new TableColumn<>("Customer No");

        TableColumn<Customer, String> name       = new TableColumn<>("Name");
        TableColumn<Customer, String> firstName  = new TableColumn<>("First Name");
        TableColumn<Customer, String> lastName   = new TableColumn<>("Last Name");

        name.getColumns().addAll(firstName, lastName);
        customer.getColumns().addAll(customerId, name);
        tableView.getColumns().addAll(customer);

        customerId.setCellValueFactory(new PropertyValueFactory<>("customerNo"));
        firstName .setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName  .setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getItems().add(new Customer("007", "Jane", "Deer"));
        tableView.getItems().add(new Customer("006", "John", "Doe"));
        tableView.getItems().add(new Customer("008", "Mack", "Alamo"));

        VBox vBox = new VBox(tableView);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
