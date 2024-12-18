package com.github.dafian.app.example.color;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorExampleApp extends Application {

    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        double red = 1.0;
        double green = 0.8;
        double blue = 0.6;
        double alpha = 1.0;

        Color color = new Color(red, green, blue, alpha);
        Color color0 = Color.web("#ff00ff");
        Color color1 = Color.web("hsl(270,100%,100%)");
        Color color2 = Color.web("#ff00ff", 0.5);
        Color color3 = Color.rgb(255, 0, 255);
        Color color4 = Color.rgb(255, 0, 255, 0.5);
        Color color5 = Color.grayRgb(255);
        Color color6 = Color.grayRgb(255, 0.5);
        Color color7 = Color.hsb(1.0, 0.5, 0.8);
        Color color8 = Color.hsb(1.0, 0.5, 0.8, 0.5);
        Color color9 = Color.color(1.0, 0.0, 1.0);
        Color color10 = Color.color(1.0, 0.0, 1.0, 0.5);
        List<Color> colorList = Arrays.asList(
                color,
                color0,
                color1,
                color2,
                color3,
                color4,
                color5,
                color6,
                color7,
                color8,
                color9,
                color10
        );

        List<Pane> paneList = new ArrayList<>();

        colorList.forEach(selectedColor -> {
            Pane pane = new Pane();
            pane.setPrefWidth(300);
            pane.setPrefHeight(300);

            Background background = new Background(new BackgroundFill(selectedColor, new CornerRadii(15), null));
            pane.setBackground(background);

            paneList.add(pane);
        });

        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(paneList);

        Scene scene = new Scene(hBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
