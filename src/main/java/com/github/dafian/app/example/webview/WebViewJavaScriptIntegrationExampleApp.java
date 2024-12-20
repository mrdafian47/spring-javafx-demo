package com.github.dafian.app.example.webview;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.w3c.dom.Document;

public class WebViewJavaScriptIntegrationExampleApp extends Application {

    private static final double WIDTH = 600;
    private static final double HEIGHT = 400;

    public static void main(String[] args) {
        launch(args);
    }

    public static class MyObject {

        public void doIt() {
            System.out.println("doIt() called");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        WebView webView = new WebView();
        //webView.setZoom(2.25);
        webView.setFontScale(1.25);
        webView.setContextMenuEnabled(false);

        WebEngine webEngine = webView.getEngine();
        //webEngine.setUserStyleSheetLocation("assets/webview/stylesheet.css");

        webEngine.loadContent("<!DOCTYPE html><html><body>Hello World!<script type=\"text/javascript\">function hmm() { return 'Hey!'; }; document.write(hmm()); </script><button onclick='window.myObject.doIt();'>Do It</button></body></html>", "text/html");

        webEngine.setUserAgent("MyApp Web Browser 1.0");

        webEngine.getLoadWorker().stateProperty().addListener((ChangeListener<Object>) (observable, oldValue, newValue) -> {
            System.out.println("oldValue: " + oldValue);
            System.out.println("newValue: " + newValue);

            if (newValue != Worker.State.SUCCEEDED) {
                return;
            }
            System.out.println("Succeeded!");
            String hello = (String) webEngine.executeScript("hmm()");
            System.out.println("hello: " + hello);

            JSObject window = (JSObject) webEngine.executeScript("window");
            window.setMember("myObject", new MyObject());

            Document document = webEngine.getDocument();

            String result = (String) webEngine.executeScript("hmm()");
            System.out.println(result);
        });

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setTitle("WebView Example App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
