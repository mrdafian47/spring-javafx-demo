package com.github.dafian.app.example.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StageMultipleModalExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("Show Dialog");
        button.setOnAction((event) -> {

            Button dialogButton = new Button("Close Dialog");

            VBox vbox = new VBox(dialogButton);
            Scene scene = new Scene(vbox);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Secondary Stage - in Modal Mode");
            dialogStage.setX(300);
            dialogStage.setY(300);
            dialogStage.setWidth(300);
            dialogStage.setHeight(300);
            dialogStage.setScene(scene);

            dialogStage.initOwner(primaryStage);
            //stage.initModality(Modality.NONE);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            //stage.initModality(Modality.APPLICATION_MODAL);

            dialogButton.setOnAction(actionEvent -> {
                dialogStage.close();
            });

            dialogStage.showAndWait();
        });

        VBox vbox = new VBox(button);
        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Primary Stage");
        primaryStage.setX(250);
        primaryStage.setY(250);
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
