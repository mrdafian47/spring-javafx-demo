package com.github.dafian.app.example.tableview;

import com.github.dafian.app.example.tableview.model.Person;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class TableViewExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Person> tableView = new TableView<>();

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        List<Person> personList = Arrays.asList(
                new Person("Kevin", "Julio"),
                new Person("Robert", "Carlos"),
                new Person("Robert", "Junior"),
                new Person("Mark", "Bitwise")
        );

        tableView.getItems().addAll(personList);

        VBox vBox = new VBox(tableView);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
