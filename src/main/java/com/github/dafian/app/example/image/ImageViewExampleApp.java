package com.github.dafian.app.example.image;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageViewExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FileInputStream input = new FileInputStream("src/main/resources/media/image/abstract-5719221_640.jpg");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);

            VBox vBox = new VBox(10, imageView);
            vBox.setPadding(new Insets(10));

            Scene scene = new Scene(vBox);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
