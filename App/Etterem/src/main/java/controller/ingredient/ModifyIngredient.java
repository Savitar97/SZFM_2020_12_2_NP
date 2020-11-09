package controller.ingredient;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.IngredientDao;
import result.model.IngredientDataModel;

public class ModifyIngredient {

    @FXML
    public TextField newName;
    @FXML
    public TextField newAmount;
    @FXML
    public TextField newUnit;

    private IngredientDao dao;

    public void initialize() {

        dao = IngredientDao.getInstance();

    }

    public void returnToIngredients(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void modifyIngredient(MouseEvent mouseEvent) {

        try {
            IngredientDataModel ingredient = new IngredientDataModel();
            ingredient.setName(newName.getText());
            ingredient.setAmount(Long.parseLong(newAmount.getText()));
            ingredient.setUnit(newUnit.getText());
            dao.update(ingredient);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            dao.getEntityManager().getTransaction().rollback();
        }
    }
}
