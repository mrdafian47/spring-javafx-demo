package com.github.dafian.app.example.video;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class MediaVideoExampleApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File mediaFile = new File("src/main/resources/media/videos/Golden-48569.mp4");

        Media media = new Media(mediaFile.toURI().toURL().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        MediaView mediaView = new MediaView(mediaPlayer);

        Scene scene = new Scene(new Pane(mediaView), 1024, 860);
        primaryStage.setScene(scene);
        primaryStage.show();

        mediaPlayer.play();
    }
}
