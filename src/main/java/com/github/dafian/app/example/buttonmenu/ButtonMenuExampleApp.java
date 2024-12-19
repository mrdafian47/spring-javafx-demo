package com.github.dafian.app.example.buttonmenu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ButtonMenuExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuItem menuItem1 = new MenuItem("Action #1");
        menuItem1.setOnAction(actionEvent -> {
            System.out.println("Menu Action #1 clicked");
        });

        MenuItem menuItem2 = new MenuItem("Action #2");
        menuItem2.setOnAction(actionEvent -> {
            System.out.println("Menu Action #2 clicked");
        });

        MenuItem menuItem3 = new MenuItem("Action #3");
        menuItem3.setOnAction(actionEvent -> {
            System.out.println("Menu Action #3 clicked");
        });

        List<MenuItem> menuItemList = Arrays.asList(
                menuItem1,
                menuItem2,
                menuItem3
        );

        MenuButton menuButton = new MenuButton("Action");
        menuButton.getItems().addAll(menuItemList);

        VBox vBox = new VBox(menuButton);
        vBox.setPadding(new Insets(10));
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
