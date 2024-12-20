package com.github.dafian.app.example.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageDecorationExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);
        primaryStage.setTitle("This title is not visible");
        primaryStage.setScene(scene);

        primaryStage.initStyle(StageStyle.DECORATED);
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.initStyle(StageStyle.UNIFIED);
//        primaryStage.initStyle(StageStyle.UTILITY);

        primaryStage.show();
    }
}
