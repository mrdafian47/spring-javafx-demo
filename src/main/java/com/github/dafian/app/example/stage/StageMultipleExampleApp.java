package com.github.dafian.app.example.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageMultipleExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        primaryStage.setTitle("JavaFX App");
        primaryStage.setHeight(200);
        primaryStage.setWidth(200);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("JavaFX Stage Window Title");
        stage.setX(500);
        stage.setY(500);

        stage.setWidth(600);
        stage.setHeight(300);

        stage.showAndWait();
    }
}
