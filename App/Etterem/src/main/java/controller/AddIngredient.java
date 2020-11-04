package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.IngredientDao;

public class AddIngredient {

    @FXML
    public TextField name;
    @FXML
    public TextField amount;
    @FXML
    public TextField unit;

    private IngredientDao dao;

    private Application app;

    public void setApp(Application app) {
        this.app = app;
    }

   /*public void initialize(){

        dao=IngredientDao.getInstance();

    }*/

    public void addIngredient(MouseEvent mouseEvent) {
    }

    public void returnToIngredients(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
