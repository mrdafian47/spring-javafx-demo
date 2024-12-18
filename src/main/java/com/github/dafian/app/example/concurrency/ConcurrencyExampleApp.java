package com.github.dafian.app.example.concurrency;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ConcurrencyExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ProgressBar progressBar = new ProgressBar(0);

        Text text = new Text("Starting");

        VBox vBox = new VBox(10, progressBar, text);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();

        Thread taskThread = new Thread(() -> {

            double progress = 0;

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }

                progress += 0.1;

                double reportedProgress = progress;
                Platform.runLater(() -> progressBar.setProgress(reportedProgress));

                int indexProgress = i;
                Platform.runLater(() -> {
                    if (indexProgress == 9) {
                        text.setText("Finish");
                    } else {
                        if (indexProgress % 2 == 0) {
                            text.setText("Loading.");
                        } else {
                            text.setText("Loading..");
                        }
                    }
                });
            }

        });

        taskThread.start();
    }
}
