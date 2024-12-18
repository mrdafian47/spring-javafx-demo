package com.github.dafian.app.example.button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ButtonFontExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Init component
        Button button = new Button("Click Here");

        // Init font
        Font font = Font.font("Courier New", FontWeight.BOLD, 36);

        // Set font to button
        button.setFont(font);

        // Set button listener
        button.setOnAction(actionEvent -> {
            System.out.println("Debug event handler from button");
        });

        VBox vBox = new VBox(button);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
