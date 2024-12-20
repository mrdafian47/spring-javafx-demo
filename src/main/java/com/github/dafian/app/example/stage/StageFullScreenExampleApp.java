package com.github.dafian.app.example.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageFullScreenExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

        //Notice that the Stage title is not visible in full screen mode
        primaryStage.setTitle("Full Screen Window Title");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

        primaryStage.show();
    }
}
