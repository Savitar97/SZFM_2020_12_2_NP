package controller.recipe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.ReservationDao;
import result.model.ReservationDataModel;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Recipe {

    @FXML
    public ComboBox<String> recipeChoices;

    @FXML
    private TableView<ReservationDataModel> recipeTable;

    @FXML
    private TableColumn<ReservationDataModel, String> name;

    @FXML
    private TableColumn<ReservationDataModel, Long> amount;

    @FXML
    private TableColumn<ReservationDataModel, String> unit;


    public void initialize() {

        initChoices();

    }

    public void initChoices(){

    }

    public void recipeSelected(MouseEvent mouseEvent) {
    }

    public void modifyAmount(MouseEvent mouseEvent) {
    }

    public void addIngredientToRecipe(MouseEvent mouseEvent) {
    }

    public void removeIngredientFromRecipe(MouseEvent mouseEvent) {
    }

    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}