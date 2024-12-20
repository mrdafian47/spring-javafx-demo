package com.github.dafian.app.example.toolbar;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToolbarExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ToolBar toolBar = new ToolBar();
        toolBar.setOrientation(Orientation.HORIZONTAL);

        Label label = new Label("Toolbar Label");
        toolBar.getItems().add(label);

        Button button1 = new Button("Button 1");
        toolBar.getItems().add(button1);

        toolBar.getItems().add(new Separator());

        Button button2 = new Button("Button 2");
        toolBar.getItems().add(button2);

        VBox vBox = new VBox(toolBar);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setTitle("Toolbar Example App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
