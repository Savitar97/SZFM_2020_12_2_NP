package controller.reservation;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddReservation {
    public void addReservation(MouseEvent mouseEvent) {
    }

    public void returnToReservation(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();

    }
}
