package com.github.dafian.app.example.treeview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TreeItem<String> rootItem = new TreeItem<>("Tutorials");

        TreeItem<String> webItem = new TreeItem<>("Web Tutorials");
        webItem.getChildren().add(new TreeItem<>("HTML  Tutorial"));
        webItem.getChildren().add(new TreeItem<>("HTML5 Tutorial"));
        webItem.getChildren().add(new TreeItem<>("CSS Tutorial"));
        webItem.getChildren().add(new TreeItem<>("SVG Tutorial"));
        rootItem.getChildren().add(webItem);

        TreeItem<String> javaItem = new TreeItem<>("Java Tutorials");
        javaItem.getChildren().add(new TreeItem<>("Java Language"));
        javaItem.getChildren().add(new TreeItem<>("Java Collections"));
        javaItem.getChildren().add(new TreeItem<>("Java Concurrency"));
        rootItem.getChildren().add(javaItem);

        TreeView<String> treeView = new TreeView<>();
        treeView.setRoot(rootItem);

        treeView.setShowRoot(false);

        VBox vBox = new VBox(treeView);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
