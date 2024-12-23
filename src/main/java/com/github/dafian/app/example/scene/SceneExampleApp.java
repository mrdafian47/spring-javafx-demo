package com.github.dafian.app.example.scene;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneExampleApp extends Application {

    private static final double WIDTH = 300;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        Scene scene = new Scene(vbox);

//        scene.setCursor(Cursor.DEFAULT);
        scene.setCursor(Cursor.CROSSHAIR);
//        scene.setCursor(Cursor.DISAPPEAR);
//        scene.setCursor(Cursor.CLOSED_HAND);
//        scene.setCursor(Cursor.HAND);
//        scene.setCursor(Cursor.OPEN_HAND);
//        scene.setCursor(Cursor.V_RESIZE);
//        scene.setCursor(Cursor.H_RESIZE);
//        scene.setCursor(Cursor.N_RESIZE);
//        scene.setCursor(Cursor.NE_RESIZE);
//        scene.setCursor(Cursor.E_RESIZE);
//        scene.setCursor(Cursor.SE_RESIZE);
//        scene.setCursor(Cursor.S_RESIZE);
//        scene.setCursor(Cursor.SW_RESIZE);
//        scene.setCursor(Cursor.W_RESIZE);
//        scene.setCursor(Cursor.NW_RESIZE);

        primaryStage.setTitle("Scene Example");
        primaryStage.setHeight(WIDTH);
        primaryStage.setWidth(HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
