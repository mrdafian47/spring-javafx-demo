package com.github.dafian.app.example.webview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewMouseWheelZoomExampleApp extends Application {

    private static final double WIDTH = 900;
    private static final double HEIGHT = 600;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        WebView webView = new WebView();

        WebEngine webEngine = webView.getEngine();

        webEngine.load("https://asliri.id/");

        webView.addEventFilter(ScrollEvent.SCROLL, (ScrollEvent e) -> {
            double deltaY = e.getDeltaY();
            if (e.isControlDown() && deltaY > 0) {
                webView.setZoom(webView.getZoom() * 1.1);
                e.consume();
                System.out.println("Zoom In");
            } else if (e.isControlDown() && deltaY < 0) {
                webView.setZoom(webView.getZoom() / 1.1);
                e.consume();
                System.out.println("Zoom Out");
            }
        });


        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setTitle("WebView Example App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
