package controller.reservation;

import controller.ingredient.ModifyIngredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import result.dao.ReservationDao;
import result.model.ReservationDataModel;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Reservation {

    @FXML
    private TableView<ReservationDataModel> reservationTable;

    @FXML
    private TableColumn<ReservationDataModel, String> name;

    @FXML
    private TableColumn<ReservationDataModel, Long> phoneNumber;

    @FXML
    private TableColumn<ReservationDataModel, Long> amountOfPeople;

    @FXML
    private TableColumn<ReservationDataModel, ZonedDateTime> date;

    private ReservationDao dao;

    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");

    public void initialize() {

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
            fxmlLoader.<ModifyReservation>getController().setDataModel(reservationTable.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.initOwner(((Node) mouseEvent.getSource()).getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setOnHiding(event -> refreshTable());
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
            stage.setOnHiding(event -> refreshTable());
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeSelected(MouseEvent mouseEvent) {

        try {
            dao.remove(reservationTable.getSelectionModel().getSelectedItem());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        refreshTable();

    }

    public void refreshTable() {
        List<ReservationDataModel> data = dao.findAll();
        System.out.println(data);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        amountOfPeople.setCellValueFactory(new PropertyValueFactory<>("amountOfPeople"));
        date.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());

        date.setCellFactory(column -> {
            return new TableCell<ReservationDataModel, ZonedDateTime>() {
                @Override
                protected void updateItem(ZonedDateTime item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(timeFormatter.format(item));

                    }
                }
            };
        });

        ObservableList<ReservationDataModel> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(data);
        reservationTable.setItems(observableResult);
        reservationTable.refresh();
    }
}