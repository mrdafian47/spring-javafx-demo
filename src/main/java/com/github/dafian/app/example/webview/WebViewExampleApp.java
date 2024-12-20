package com.github.dafian.app.example.webview;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.Date;

public class WebViewExampleApp extends Application {

    private static final double WIDTH = 600;
    private static final double HEIGHT = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        WebView webView = new WebView();
        //webView.setZoom(2.25);
        //webView.setFontScale(1.25);
        //webView.setContextMenuEnabled(false);

        WebEngine webEngine = webView.getEngine();
        //webEngine.setUserStyleSheetLocation("assets/webview/stylesheet.css");

        webEngine.getLoadWorker().stateProperty().addListener((observableValue, oldState, newState) -> {
            System.out.println("-------------------------------------------------------------------------------");
            if (newState == Worker.State.RUNNING) {
                System.out.println("Start running other task");
            }
            System.out.println("Old State: " + oldState.toString());
            System.out.println("New State: " + newState.toString());
        });

        webEngine.load("https://asliri.id/");
//        webEngine.loadContent("<!DOCTYPE html><html><body>Hello World!</body></html>", "text/html");

        webEngine.setUserAgent("MyApp Web Browser 1.0");

        //webEngine.reload();

        historyExamples(webEngine);

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setTitle("WebView Example App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void historyExamples(WebEngine webEngine) {
        WebHistory history = webEngine.getHistory();

        ObservableList<WebHistory.Entry> entries = history.getEntries();

        for (WebHistory.Entry entry : entries) {

        }

        for (WebHistory.Entry entry : entries) {
            //do something with the entry
            String url = entry.getUrl();
            String title = entry.getTitle();
            Date lastVisitedDate = entry.getLastVisitedDate();
        }

        history.go(1);
        history.go(-1);

        int currentIndex = history.getCurrentIndex();
    }
}
