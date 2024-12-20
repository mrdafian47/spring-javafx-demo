package com.github.dafian.app.example.togglebutton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToggleButtonExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ToggleButton toggleButton = new ToggleButton("Toggle This!");

        toggleButton.setOnAction((event) -> {
            System.out.println("Toggle button clicked");
            String buttonText = toggleButton.isSelected() ? "On" : "Off";
            toggleButton.setText(buttonText);
        });

        VBox vBox = new VBox(toggleButton);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
