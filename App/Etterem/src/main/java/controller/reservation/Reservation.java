package controller.reservation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import result.dao.ReservationDao;
import result.model.ReservationDataModel;

import java.io.IOException;
import java.time.ZonedDateTime;

public class Reservation {

    @FXML
    private TableView<ReservationDataModel> reservationTable;

    @FXML
    private TableColumn<ReservationDataModel,String> name;

    @FXML
    private TableColumn<ReservationDataModel,Long> phoneNumber;

    @FXML
    private TableColumn<ReservationDataModel,Long> amountOfPeople;

    @FXML
    private TableColumn<ReservationDataModel, ZonedDateTime> date;

    private ReservationDao dao;

    public void initialize(){

        dao = ReservationDao.getInstance();

    }

    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void goToModify(MouseEvent mouseEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/modifyReservation.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.initOwner(((Node) mouseEvent.getSource()).getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.setOnHiding(event -> refreshTable());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToAdd(MouseEvent mouseEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/addReservation.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.initOwner(((Node) mouseEvent.getSource()).getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            //stage.setOnHiding(event -> refreshTable());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeSelected(MouseEvent mouseEvent) {
    }
}