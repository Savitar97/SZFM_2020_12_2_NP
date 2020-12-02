package controller.meal;

import controller.ingredient.ModifyIngredient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import result.dao.MealDao;
import result.dao.ReservationDao;
import result.model.IngredientDataModel;
import result.model.MealDataModel;

import java.io.IOException;
import java.util.List;

public class Meal {
    @FXML
    private TableView<MealDataModel> mealsTable;
    @FXML
    private TableColumn<MealDataModel, String> name;
    @FXML
    private TableColumn<MealDataModel, Long> price;
    private MealDao dao;

    public void initialize() {
        dao = MealDao.getInstance();
        refreshTable();
    }



    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void goToModify(MouseEvent mouseEvent) {
        if (mealsTable.getSelectionModel().getSelectedItem() != null) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/modifyMeal.fxml"));
                Parent root = fxmlLoader.load();
                fxmlLoader.<ModifyMeal>getController().setDataModel(mealsTable.getSelectionModel().getSelectedItem());
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root, 450, 450));
                stage.initOwner(((Node) mouseEvent.getSource()).getScene().getWindow());
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setOnHiding(event -> refreshTable());
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott elem!", ButtonType.CLOSE);
            alert.showAndWait();

        }
    }

    public void goToAdd(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/addMeal.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root, 450, 450));
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
            dao.remove(mealsTable.getSelectionModel().getSelectedItem());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        refreshTable();
    }

    private void refreshTable() {
        List<MealDataModel> datas = dao.findAll();
        System.out.println(datas);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<MealDataModel> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(datas);
        mealsTable.setItems(observableResult);
        mealsTable.refresh();
    }
}