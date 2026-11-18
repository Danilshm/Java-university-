package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Module;

public class SelectModulesPane extends BorderPane {
    private ListView<Module> lstSelectedBlock1;
    private ListView<Module> lstSelectedBlock2;
    private ListView<Module> lstUnselectedBlock34;
    private ListView<Module> lstSelectedBlock34;

    private Button btnAdd;
    private Button btnRemove;
    private Button btnReset;
    private Button btnSubmit;
    private TextField txtCredits;

    public SelectModulesPane() {
        setPadding(new Insets(10));

        lstSelectedBlock1 = new ListView<>();
        lstSelectedBlock2 = new ListView<>();
        lstUnselectedBlock34 = new ListView<>();
        lstSelectedBlock34 = new ListView<>();

        lstSelectedBlock1.setPrefHeight(150);
        lstSelectedBlock2.setPrefHeight(150);
        lstUnselectedBlock34.setPrefHeight(150);
        lstSelectedBlock34.setPrefHeight(150);

        VBox leftBox = new VBox(10);
        leftBox.getChildren().addAll(
                new Label("Selected Block 1 modules"), lstSelectedBlock1,
                new Label("Selected Block 2 modules"), lstSelectedBlock2
        );

        btnAdd = new Button("Add");
        btnRemove = new Button("Remove");
        HBox buttonBox = new HBox(10, new Label("Block 3/4"), btnAdd, btnRemove);
        buttonBox.setAlignment(Pos.CENTER);

        VBox rightBox = new VBox(10);
        rightBox.getChildren().addAll(
                new Label("Unselected Block 3/4 modules"), lstUnselectedBlock34,
                buttonBox,
                new Label("Selected Block 3/4 modules"), lstSelectedBlock34
        );

        HBox centerBox = new HBox(20, leftBox, rightBox);
        HBox.setHgrow(leftBox, Priority.ALWAYS);
        HBox.setHgrow(rightBox, Priority.ALWAYS);
        leftBox.setMaxWidth(Double.MAX_VALUE);
        rightBox.setMaxWidth(Double.MAX_VALUE);
        setCenter(centerBox);

        txtCredits = new TextField("0");
        txtCredits.setEditable(false);
        txtCredits.setMaxWidth(60);

        btnReset = new Button("Reset");
        btnSubmit = new Button("Submit");

        HBox bottomBox = new HBox(15, new Label("Current credits:"), txtCredits, btnReset, btnSubmit);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10, 0, 0, 0));
        setBottom(bottomBox);
    }

    public ListView<Module> getLstSelectedBlock1() { return lstSelectedBlock1; }
    public ListView<Module> getLstSelectedBlock2() { return lstSelectedBlock2; }
    public ListView<Module> getLstUnselectedBlock34() { return lstUnselectedBlock34; }
    public ListView<Module> getLstSelectedBlock34() { return lstSelectedBlock34; }
    public Button getBtnAdd() { return btnAdd; }
    public Button getBtnRemove() { return btnRemove; }
    public Button getBtnReset() { return btnReset; }
    public Button getBtnSubmit() { return btnSubmit; }
    public TextField getTxtCredits() { return txtCredits; }
}