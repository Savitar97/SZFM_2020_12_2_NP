package controller.recipe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.IngredientDao;
import result.dao.MealDao;
import result.dao.RecipeDao;
import result.model.IngredientDataModel;
import result.model.MealDataModel;

public class ModifyRecipe {

    @FXML
    TextField amount;
    @FXML
    TextField unit;

    private IngredientDao ingredientDao;

    private MealDao mealDao;

    private RecipeDao recipeDao;

    private MealDataModel selectedMeal;

    private IngredientDataModel selectedIngredient;

    public void setSelectedMeal(MealDataModel selectedMeal) {
        this.selectedMeal = selectedMeal;
    }

    public void setSelectedIngredient(IngredientDataModel selectedIngredient) {
        this.selectedIngredient = selectedIngredient;
    }

    public void initialize(){
        ingredientDao = IngredientDao.getInstance();
        mealDao = MealDao.getInstance();
        recipeDao = RecipeDao.getInstance();

    }

    public void modify(MouseEvent mouseEvent) {
    }

    public void returnToRecipes(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
