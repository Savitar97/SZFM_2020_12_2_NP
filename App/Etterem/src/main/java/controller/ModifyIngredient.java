package controller;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ModifyIngredient {
    public void returnToIngredients(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void modifyIngredient(MouseEvent mouseEvent) {
    }
}
