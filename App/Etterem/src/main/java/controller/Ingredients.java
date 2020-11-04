package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import result.IngredientDao;
import result.model.IngredientDataModel;

import java.io.IOException;
import java.util.List;

public class Ingredients {

    @FXML
    private TableView<IngredientDataModel> ingredientTable;

    @FXML
    private TableColumn<IngredientDataModel,String> name;

    @FXML
    private TableColumn<IngredientDataModel,Long> amount;

    @FXML
    private TableColumn<IngredientDataModel,String> unit;

    private IngredientDao ingredientDao;


    public void initialize(){
        ingredientDao = IngredientDao.getInstance();
        refreshTable();
    }


    @FXML
    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    public void goToModify(MouseEvent mouseEvent) {
    }


    @FXML
    public void goToAdd(MouseEvent mouseEvent) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/addingredient.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void removeSelected(MouseEvent mouseEvent) {
        try {
            ingredientDao.remove(ingredientTable.getSelectionModel().getSelectedItem());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        refreshTable();
    }


    public void refreshTable(){
        List<IngredientDataModel> datas= ingredientDao.findAll();
        System.out.println(datas);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        ObservableList<IngredientDataModel> observableResult = FXCollections.observableArrayList();

        observableResult.addAll(datas);

        ingredientTable.setItems(observableResult);
    }
}