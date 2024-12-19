package com.github.dafian.app.example.htmleditor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class HtmlEditorExampleApp extends Application {

    private static final double WIDTH = 600;
    private static final double HEIGHT = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HTMLEditor htmlEditor = new HTMLEditor();

        String htmlText = "<b>Bold text</b>";
        htmlEditor.setHtmlText(htmlText);

        Button button = new Button();
        button.setText("Submit Data");
        button.setOnAction(actionEvent -> {

            String htmlTextEdited = htmlEditor.getHtmlText();
            System.out.println(htmlTextEdited);
        });

        VBox vBox = new VBox(10, htmlEditor, button);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox, WIDTH, HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
