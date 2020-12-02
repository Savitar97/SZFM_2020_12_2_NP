package controller.recipe;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.IngredientDao;
import result.dao.MealDao;
import result.dao.RecipeDao;
import result.model.IngredientDataModel;
import result.model.MealDataModel;
import result.model.RecipeDataModel;

import java.util.List;

public class AddRecipe {

    @FXML
    ComboBox<String> mealChoices;
    @FXML
    ComboBox<String> ingredientChoices;
    @FXML
    TextField amount;
    @FXML
    TextField unit;

    private IngredientDao ingredientDao;

    private MealDao mealDao;

    private RecipeDao recipeDao;


    public void initialize(){
        ingredientDao = IngredientDao.getInstance();
        mealDao = MealDao.getInstance();
        recipeDao = RecipeDao.getInstance();

        initMealChoices();
        initIngredientChoices();
    }

    public void initMealChoices(){

        List<MealDataModel> meals = mealDao.findAll();

        for (int i = 0; i<meals.size(); i++){
            mealChoices.getItems().add(meals.get(i).getName());
            System.out.println(meals.get(i).getName());
        }
    }

    public void initIngredientChoices(){

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

        try {

            RecipeDataModel element = new RecipeDataModel();
            IngredientDataModel ingredient = IngredientDao.getInstance().findByName(ingredientChoices.getValue());
            MealDataModel meal = MealDao.getInstance().findByName(mealChoices.getValue());

            element.setIngredient(ingredient);
            element.setMeal(meal);
            element.setAmount(Long.parseLong(amount.getText()));
            element.setUnit(unit.getText());

            recipeDao.persist(element);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            recipeDao.getEntityManager().getTransaction().rollback();
        }

    }
}
