package controller.stock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.IngredientDao;
import result.model.IngredientDataModel;

import java.io.IOException;
import java.util.List;

public class OutOfStock {

    @FXML
    private TableView<IngredientDataModel> ingredientTable;

    @FXML
    private TableColumn<IngredientDataModel, String> name;

    @FXML
    private TableColumn<IngredientDataModel, Long> amount;

    @FXML
    private TableColumn<IngredientDataModel, String> unit;

    private IngredientDao ingredientDao;

    public void initialize() {

        ingredientDao = IngredientDao.getInstance();
        refreshTable();
    }

    private void refreshTable() {

        List<IngredientDataModel> datas = ingredientDao.findOutOfStock();
        System.out.println(datas);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        ObservableList<IngredientDataModel> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(datas);
        ingredientTable.setItems(observableResult);
        ingredientTable.refresh();

    }
    
    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}