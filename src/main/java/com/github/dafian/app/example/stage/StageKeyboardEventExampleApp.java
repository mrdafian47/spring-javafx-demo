package com.github.dafian.app.example.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StageKeyboardEventExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label = new Label("This app will shut down automatically");
        VBox vbox = new VBox(label);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(100);
        primaryStage.show();

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            System.out.println("Key Code: " + event.getCode().getName());

            KeyCode selectedKey = event.getCode();
            if (selectedKey == KeyCode.ESCAPE) {
                primaryStage.close();
            } else if (selectedKey == KeyCode.ENTER) {
                primaryStage.setWidth(primaryStage.getWidth() * 2);
            }
        });
    }
}
