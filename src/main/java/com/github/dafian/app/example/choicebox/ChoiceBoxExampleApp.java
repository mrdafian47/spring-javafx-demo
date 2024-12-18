package com.github.dafian.app.example.choicebox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ChoiceBoxExampleApp extends Application {

    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Ini component
        ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // Init choice list
        List<String> choiceList = Arrays.asList(
                "Choice 0",
                "Choice 1",
                "Choice 2"
        );
        choiceBox.getItems().addAll(choiceList);

        // Set default selected
        choiceBox.setValue("Choice 2");

        choiceBox.setOnAction((actionEvent) -> {

            int selectedIndex = choiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = choiceBox.getSelectionModel().getSelectedItem();

            System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
            System.out.println("ChoiceBox.getValue(): " + choiceBox.getValue());
        });

        HBox hBox = new HBox(10, choiceBox);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(hBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
