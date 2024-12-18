package com.github.dafian.app.example.contextmenu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class ContextMenuExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // init component
        ContextMenu contextMenu = new ContextMenu();

        // init menu item list
        List<MenuItem> menuItemList = Arrays.asList(
                new MenuItem("Choice #1"),
                new MenuItem("Choice #2"),
                new MenuItem("Choice #3"),
                new MenuItem("Choice #4")
        );

        // insert menu item list
        contextMenu.getItems().addAll(menuItemList);

        // listen the event
        menuItemList.forEach(menuItem -> {
            menuItem.setOnAction(actionEvent -> {
                System.out.println("Menu item " + menuItem.getText() + " selected");
            });
        });

        TextArea textArea = new TextArea();
        textArea.setContextMenu(contextMenu);
        textArea.setText("Please use Right Click");

        Button button = new Button();
        button.setText("Submit");
        button.setOnAction(actionEvent -> {
            System.out.println("Input from TextArea: " + textArea.getText());
        });

        VBox vBox = new VBox(10, textArea, button);
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
