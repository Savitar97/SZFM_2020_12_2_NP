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

    private static IngredientDataModel ingredient;

    public void initialize() {

        dao = IngredientDao.getInstance();

    }

    public void setDataModel (IngredientDataModel selectedItem){

        this.ingredient = selectedItem;

    }

    public void returnToIngredients(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void modifyIngredient(MouseEvent mouseEvent) {

        try {

            ingredient.setName(newName.getText());
            ingredient.setAmount(Long.parseLong(newAmount.getText()));
            ingredient.setUnit(newUnit.getText());
            dao.update(ingredient);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.out.println( e.getClass() + ": "+ e.getMessage());
            dao.getEntityManager().getTransaction().rollback();
        }
    }
}
