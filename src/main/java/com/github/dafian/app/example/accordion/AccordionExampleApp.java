package com.github.dafian.app.example.accordion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class AccordionExampleApp extends Application {

    private static final double WIDTH = 400;
    private static final double HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Init component
        Accordion accordion = new Accordion();

        // Init child component
        TitledPane pane1 = new TitledPane("Boats", new Label("Show all boats available"));
        TitledPane pane2 = new TitledPane("Cars", new Label("Show all cars available"));
        TitledPane pane3 = new TitledPane("Planes", new Label("Show all planes available"));
        List<TitledPane> titledPaneList = Arrays.asList(pane1, pane2, pane3);

        // Adding all child component
        accordion.getPanes().addAll(titledPaneList);

        VBox vBox = new VBox(accordion);
        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
