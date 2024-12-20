package com.github.dafian.app.example.pagination;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PaginationExampleApp extends Application {

    private static final double WIDTH = 600;
    private static final double HEIGHT = 900;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pagination pagination = new Pagination();
        pagination.setPageCount(21);
        pagination.setCurrentPageIndex(3);
        pagination.setMaxPageIndicatorCount(3);

//        pagination.setPageFactory(param -> null);

        pagination.setPageFactory((pageIndex) -> {

            Label label1 = new Label("Content for page with index: " + pageIndex);
            label1.setFont(new Font("Arial", 24));

            Label label2 = new Label("Main content of the page ...");

            return new VBox(label1, label2);
        });

        VBox vBox = new VBox(pagination);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
