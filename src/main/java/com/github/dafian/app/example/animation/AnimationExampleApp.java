package com.github.dafian.app.example.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AnimationExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle(50, 150, 50, Color.RED);

        // change circle.translateXProperty from it's current value to 300
        KeyValue keyValue1 = new KeyValue(circle.translateXProperty(), 300);

        // change circle.translateYProperty from it's current value to 100
        KeyValue keyValue2 = new KeyValue(circle.translateYProperty(), 100);

        // over the course of 5 seconds
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(5), keyValue1, keyValue2);

        Timeline timeline = new Timeline(keyFrame2);

        Scene scene = new Scene(new Pane(circle), WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }
}
