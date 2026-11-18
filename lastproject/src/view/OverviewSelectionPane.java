package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class OverviewSelectionPane extends BorderPane {
    private TextArea txtProfile;
    private TextArea txtSelectedModules;
    private TextArea txtReservedModules;
    private Button btnSaveOverview;

    public OverviewSelectionPane() {
        setPadding(new Insets(10));

        txtProfile = new TextArea();
        txtProfile.setEditable(false);
        txtProfile.setPrefHeight(120);

        txtSelectedModules = new TextArea();
        txtSelectedModules.setEditable(false);

        txtReservedModules = new TextArea();
        txtReservedModules.setEditable(false);

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(10);

        grid.add(txtProfile, 0, 0, 2, 1);
        grid.add(txtSelectedModules, 0, 1);
        grid.add(txtReservedModules, 1, 1);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        grid.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(35);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(65);
        grid.getRowConstraints().addAll(row1, row2);

        setCenter(grid);

        btnSaveOverview = new Button("Save Overview");
        HBox bottomBox = new HBox(btnSaveOverview);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10, 0, 0, 0));
        setBottom(bottomBox);
    }

    public TextArea getTxtProfile() { return txtProfile; }
    public TextArea getTxtSelectedModules() { return txtSelectedModules; }
    public TextArea getTxtReservedModules() { return txtReservedModules; }
    public Button getBtnSaveOverview() { return btnSaveOverview; }


}