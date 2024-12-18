package com.github.dafian.app.example.button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonDefaultAndCancelExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Button regularButton = new Button("Regular");
        regularButton.setOnAction(actionEvent -> {
            System.out.println("Regular button clicked");
        });

        regularButton.setCancelButton(false);
        regularButton.setDefaultButton(false);

        Button defaultButton = new Button("Default");
        defaultButton.setOnAction(actionEvent -> {
            System.out.println("Default button clicked");
        });

        defaultButton.setCancelButton(false);
        defaultButton.setDefaultButton(true);

        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(actionEvent -> {
            System.out.println("Cancel button clicked");
        });

        cancelButton.setCancelButton(true);
        cancelButton.setDefaultButton(false);

        HBox hBox = new HBox(10, regularButton, defaultButton, cancelButton);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(hBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
