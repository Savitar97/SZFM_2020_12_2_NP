package controller.recipe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.IngredientDao;
import result.dao.MealDao;
import result.model.IngredientDataModel;
import result.model.MealDataModel;

import java.util.List;

public class AddRecipe {

    @FXML
    ComboBox<String> mealChoices;
    @FXML
    ComboBox<String> ingredientChoices;

    public void initialize(){
        initMealChoices();
        initIngredientChoices();
    }

    public void initMealChoices(){
        MealDao mealDao = MealDao.getInstance();
        List<MealDataModel> meals = mealDao.findAll();

        for (int i = 0; i<meals.size(); i++){
            mealChoices.getItems().add(meals.get(i).getName());
            System.out.println(meals.get(i).getName());
        }
    }

    public void initIngredientChoices(){
        IngredientDao ingredientDao = IngredientDao.getInstance();
        List<IngredientDataModel> ingredients = ingredientDao.findAll();

        for (int i = 0; i<ingredients.size(); i++){
            mealChoices.getItems().add(ingredients.get(i).getName());
            System.out.println(ingredients.get(i).getName());
        }
    }

    public void returnToRecipes(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void add(MouseEvent mouseEvent) {
    }
}
