package com.github.dafian.app.example.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Window Title");
        primaryStage.setX(250);
        primaryStage.setY(250);
        primaryStage.setHeight(200);
        primaryStage.setWidth(200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
