package com.github.dafian.app.example.tableview;

import com.github.dafian.app.example.tableview.model.Person;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewEditableExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Person> tableView = new TableView<>();
        tableView.setEditable(true);

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        column2.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Person, String> column3 = new TableColumn<>("Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("category"));
        column3.setCellFactory(ComboBoxTableCell.forTableColumn("Category 1", "Category 2"));

        TableColumn<Person, Boolean> column4 = new TableColumn<>("Is XYZ");
        column4.setCellValueFactory(cellData -> new ReadOnlyBooleanWrapper(cellData.getValue().isXyz()));
        column4.setCellFactory(CheckBoxTableCell.forTableColumn(column4));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);

        tableView.getItems().add(new Person("John", "Doe", null, false));
        tableView.getItems().add(new Person("Jane", "Deer", "Category 1", true));
        tableView.getItems().add(new Person("Dinesh", "Gupta", "Category 2", true));

        VBox vBox = new VBox(tableView);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
