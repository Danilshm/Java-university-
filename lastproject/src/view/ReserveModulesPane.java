package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Module;

public class ReserveModulesPane extends BorderPane {
    private ListView<Module> lstUnselectedBlock34;
    private ListView<Module> lstReservedBlock34;
    private Button btnAdd;
    private Button btnRemove;
    private Button btnConfirm;

    public ReserveModulesPane() {
        setPadding(new Insets(10));

        lstUnselectedBlock34 = new ListView<>();
        lstReservedBlock34 = new ListView<>();

        VBox leftBox = new VBox(10, new Label("Unselected Block 3/4 modules"), lstUnselectedBlock34);
        VBox rightBox = new VBox(10, new Label("Reserved Block 3/4 modules"), lstReservedBlock34);
        HBox.setHgrow(leftBox, Priority.ALWAYS);
        HBox.setHgrow(rightBox, Priority.ALWAYS);

        HBox centerBox = new HBox(20, leftBox, rightBox);
        setCenter(centerBox);

        btnAdd = new Button("Add");
        btnRemove = new Button("Remove");
        btnConfirm = new Button("Confirm");

        HBox bottomBox = new HBox(15, new Label("Reserve one optional module"), btnAdd, btnRemove, btnConfirm);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(10, 0, 0, 0));
        setBottom(bottomBox);
    }

    public ListView<Module> getLstUnselectedBlock34() { return lstUnselectedBlock34; }
    public ListView<Module> getLstReservedBlock34() { return lstReservedBlock34; }
    public Button getBtnAdd() { return btnAdd; }
    public Button getBtnRemove() { return btnRemove; }
    public Button getBtnConfirm() { return btnConfirm; }
}