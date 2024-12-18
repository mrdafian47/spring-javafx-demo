package com.github.dafian.app.example.combobox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ComboBoxExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // init component
        ComboBox<String> comboBox = new ComboBox<>();

        // init choice list
        List<String> choiceList = Arrays.asList(
                "Choice #1",
                "Choice #2",
                "Choice #3",
                "Choice #4"
        );

        // set placeholder
        comboBox.setValue("Please choice ...");

        // insert the choice list
        comboBox.getItems().addAll(choiceList);

        // make it editable
        comboBox.setEditable(true);

        // listen the event
        comboBox.setOnAction(actionEvent -> {

            int selectedIndex = comboBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = comboBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("   ChoiceBox.getValue(): " + comboBox.getValue());
        });

        HBox hBox = new HBox(10, comboBox);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(hBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
