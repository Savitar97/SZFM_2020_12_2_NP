package controller.reservation;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ModifyReservation {
    public void modifyReservation(MouseEvent mouseEvent) {
    }

    public void returnToReservation(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();

    }
}
