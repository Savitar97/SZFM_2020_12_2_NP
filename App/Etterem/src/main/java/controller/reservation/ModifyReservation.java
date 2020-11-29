package controller.reservation;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.ReservationDao;
import result.model.ReservationDataModel;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ModifyReservation {

    @FXML
    public TextField name;
    @FXML
    public TextField phoneNumber;
    @FXML
    public TextField amountOfPeople;
    @FXML
    public TextField email;
    @FXML
    public ComboBox<Long> month;
    @FXML
    public ComboBox<Long> day;
    @FXML
    public ComboBox<Long> hour;
    @FXML
    public ComboBox<Long> minutes;


    private ReservationDao dao;

    private ReservationDataModel reservation;

    public void initialize() {

        dao = ReservationDao.getInstance();
        initChoices();

    }

    public void setDataModel(ReservationDataModel selectedItem) {

        this.reservation = selectedItem;

        name.setText(reservation.getName());
        phoneNumber.setText(reservation.getPhoneNumber().toString());
        amountOfPeople.setText(reservation.getAmountOfPeople().toString());
        email.setText(reservation.getEmail());

        ZonedDateTime date = reservation.getDate();

        month.setValue(Long.valueOf(date.getMonthValue()));
        day.setValue(Long.valueOf(date.getDayOfMonth()));
        hour.setValue(Long.valueOf(date.getHour()));
        minutes.setValue(Long.valueOf(date.getMinute()));

    }

    @FXML
    public void initChoices() {

        for (int i = 1; i < 13; i++) {

            month.getItems().add(Long.valueOf(i));
        }

        for (int i = 1; i < 32; i++) {

            day.getItems().add(Long.valueOf(i));
        }

        for (int i = 11; i < 21; i++) {

            hour.getItems().add(Long.valueOf(i));
        }

        minutes.getItems().add(Long.valueOf(0));
        minutes.getItems().add(Long.valueOf(15));
        minutes.getItems().add(Long.valueOf(30));
        minutes.getItems().add(Long.valueOf(45));

    }

    public void modifyReservation(MouseEvent mouseEvent) {

        try {

            reservation.setName(name.getText());
            reservation.setPhoneNumber(phoneNumber.getText());
            reservation.setAmountOfPeople(Long.parseLong(amountOfPeople.getText()));
            reservation.setEmail(email.getText());

            ZonedDateTime reservationDate;

            reservationDate = ZonedDateTime.of(ZonedDateTime.now().getYear(),
                    month.getValue().intValue(),
                    day.getValue().intValue(),
                    hour.getValue().intValue(),
                    minutes.getValue().intValue(), 0, 0,
                    ZoneId.of("UTC+1"));

            reservation.setDate(reservationDate);

            dao.update(reservation);

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
