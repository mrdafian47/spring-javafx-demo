package com.github.dafian.app.example.colorpicker;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ColorPickerExampleApp extends Application {

    private static final double WIDTH = 600;
    private static final double HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        pane.setPrefWidth(WIDTH);
        pane.setPrefHeight(HEIGHT);

        // Default background
        pane.setBackground(getBackground(Color.GRAY));

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setOnAction(actionEvent -> {

            Color selectedColor = colorPicker.getValue();

            System.out.println("Selected color: " + selectedColor);

            // Change color background
            pane.setBackground(getBackground(selectedColor));
        });

        VBox vBox = new VBox(10, colorPicker, pane);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.TOP_CENTER);

        HBox hBox = new HBox(10, vBox);
        hBox.setPadding(new Insets(10));
        Scene scene = new Scene(hBox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Background getBackground(Color color) {
        return new Background(new BackgroundFill(color, new CornerRadii(15), null));
    }
}
