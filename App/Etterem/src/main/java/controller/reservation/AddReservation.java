package controller.reservation;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.IngredientDao;
import result.dao.ReservationDao;
import result.model.ReservationDataModel;

public class AddReservation {

    @FXML
    public TextField name;
    @FXML
    public TextField phoneNumber;
    @FXML
    public TextField amountOfPeople;

    private ReservationDao dao;

    public void initialize(){

        dao = ReservationDao.getInstance();

    }

    public void addReservation(MouseEvent mouseEvent) {

        try {
            ReservationDataModel reservation = new ReservationDataModel();
            reservation.setName(name.getText());
            reservation.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
            reservation.setAmountOfPeople(Long.parseLong(amountOfPeople.getText()));
            dao.persist(reservation);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            dao.getEntityManager().getTransaction().rollback();
        }

    }

    public void returnToReservation(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();

    }
}
