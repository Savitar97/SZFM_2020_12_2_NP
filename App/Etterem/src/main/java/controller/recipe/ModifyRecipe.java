package controller.recipe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.RecipeDao;
import result.model.RecipeDataModel;

public class ModifyRecipe {

    @FXML
    TextField amount;
    @FXML
    TextField unit;

    private RecipeDao recipeDao;

    private RecipeDataModel selectedRecipe;

    public void setSelectedRecipe(RecipeDataModel selected) {

        this.amount.setText(selected.getAmount().toString());
        this.unit.setText(selected.getUnit());
        this.selectedRecipe = selected;
    }

    public void initialize(){

        recipeDao = RecipeDao.getInstance();

    }

    public void modify(MouseEvent mouseEvent) {

        try {

            selectedRecipe.setAmount(Long.valueOf(amount.getText()));
            selectedRecipe.setUnit(unit.getText());
            recipeDao.update(selectedRecipe);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.out.println( e.getClass() + ": "+ e.getMessage());
            recipeDao.getEntityManager().getTransaction().rollback();
        }
    }

    public void returnToRecipes(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
