package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.IngredientDao;
import result.model.IngredientDataModel;

import java.lang.*;

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

    public void initialize() {

        dao = IngredientDao.getInstance();

    }

    public void addIngredient(MouseEvent mouseEvent) {

        try {
            IngredientDataModel ingredient = new IngredientDataModel();
            ingredient.setName(name.getText());
            ingredient.setAmount(Long.parseLong(amount.getText()));
            ingredient.setUnit(unit.getText());
            dao.persist(ingredient);
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            dao.getEntityManager().getTransaction().rollback();
        }
    }

    public void returnToIngredients(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
