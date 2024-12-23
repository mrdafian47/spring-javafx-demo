package com.github.dafian.app.example.dashboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardExampleApp extends Application {

    private static final double WIDTH = 900;
    private static final double HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        DashboardView view = new DashboardView();

        VBox vBox = new VBox(view.getParentScene());
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
