package com.github.dafian.app.example.button;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class ButtonFxmlExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();

        ButtonFxmlController controller = new ButtonFxmlController();
        loader.setController(controller);

        File fxmlFile = new File("src/main/resources/fxml/button-example.fxml");
        URL fxmlUrl = fxmlFile.toURI().toURL();
        loader.setLocation(fxmlUrl);

        VBox vBox = loader.load();
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
