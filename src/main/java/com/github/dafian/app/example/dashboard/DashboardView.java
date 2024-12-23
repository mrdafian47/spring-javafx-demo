package com.github.dafian.app.example.dashboard;

import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class DashboardView {

    private final VBox parentLayout;

    public DashboardView() {
        this.parentLayout = createLayout();
        this.parentLayout.setPrefWidth(900);
        this.parentLayout.setPrefHeight(600);
    }

    public Parent getParentScene() {
        return this.parentLayout;
    }

    private VBox createLayout() {

        VBox vBox = new VBox(0,
                createTopSection(),
                createCenterSection(),
                createBottomSection()
        );
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setNodeOrientation(NodeOrientation.INHERIT);
        return vBox;
    }

    private MenuBar createTopSection() {

        Menu menuFile = createMenu("File", "New", "Open");
        Menu menuEdit = createMenu("Edit", "Undo", "Redo");
        Menu menuHelp = createMenu("Help", "About App");

        MenuBar menuBar = new MenuBar(
                menuFile,
                menuEdit,
                menuHelp
        );

        VBox.setVgrow(menuBar, Priority.NEVER);

        return menuBar;
    }

    private SplitPane createCenterSection() {

        Label masterLabel = createLabel("Master");
        AnchorPane masterSection = new AnchorPane(
                masterLabel
        );

        Label viewLabel = createLabel("View");
        AnchorPane viewInnerSection = new AnchorPane(
                viewLabel
        );

        ScrollPane viewSection = new ScrollPane(
                viewInnerSection
        );

        Label detailLabel = createLabel("Detail");
        AnchorPane detailSection = new AnchorPane(
                detailLabel
        );

        SplitPane splitPane = new SplitPane(
                masterSection,
                viewSection,
                detailSection
        );
        splitPane.setDividerPositions(0.2505567928730512, 0.7505567928730512);
        splitPane.setFocusTraversable(true);
        splitPane.setPrefWidth(-1.0);
        splitPane.setPrefHeight(-1.0);

        VBox.setVgrow(splitPane, Priority.ALWAYS);

        return splitPane;
    }

    private HBox createBottomSection() {

        Font font = createFont(11.0);

        Label labelLeftStatus = new Label("Status: Connected");
        labelLeftStatus.setFont(font);
        HBox.setHgrow(labelLeftStatus, Priority.ALWAYS);

        Pane paneCentral = new Pane();
        HBox.setHgrow(paneCentral, Priority.ALWAYS);

        Label labelRightStatus = new Label("UTF-8 4 spaces");
        labelRightStatus.setFont(font);
        HBox.setHgrow(labelRightStatus, Priority.NEVER);

        HBox hBox = new HBox(
                5,
                labelLeftStatus,
                paneCentral,
                labelRightStatus
        );
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10.0));
        VBox.setVgrow(hBox, Priority.NEVER);

        return hBox;
    }

    private Label createLabel(String itemLabel) {
        Label label = new Label(itemLabel);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(createFont(18.0));
        label.setLayoutX(14.0);
        label.setLayoutY(14.0);
        return label;
    }

    private Font createFont(double size) {
        return new Font(size);
    }

    private Menu createMenu(String menuLabel, String... menuItemLabel) {
        Menu menu = new Menu(menuLabel);
        for (String menuItem : menuItemLabel) {
            menu.getItems().add(createMenuItem(menuItem));
        }
        return menu;
    }

    private MenuItem createMenuItem(String label) {
        MenuItem menuItem = new MenuItem(label);
        menuItem.setOnAction(actionEvent -> {
            System.out.println("Click Menu: " + label);
        });
        return menuItem;
    }
}
