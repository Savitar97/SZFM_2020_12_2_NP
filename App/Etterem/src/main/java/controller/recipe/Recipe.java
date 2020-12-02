package controller.recipe;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.MealDao;
import result.dao.RecipeDao;
import result.model.MealDataModel;
import result.model.RecipeDataModel;

import java.io.IOException;
import java.util.List;


public class Recipe {

    @FXML
    public ComboBox<String> recipeChoices;

    @FXML
    private TableView<RecipeDataModel> recipeTable;

    @FXML
    private TableColumn<RecipeDataModel, String> name;

    @FXML
    private TableColumn<RecipeDataModel, Long> amount;

    @FXML
    private TableColumn<RecipeDataModel, String> unit;

    private RecipeDao recipeDao;

    public void initialize() {

        recipeDao = RecipeDao.getInstance();
        initChoices();

    }

    @FXML
    public void initChoices(){

        MealDao mealDao = MealDao.getInstance();
        List<MealDataModel> meals = mealDao.findAll();

        for (int i = 0; i<meals.size(); i++){
            recipeChoices.getItems().add(meals.get(i).getName());
            System.out.println(meals.get(i).getName());
        }

    }

    public void recipeSelected(MouseEvent mouseEvent) {
    }

    public void modifyAmount(MouseEvent mouseEvent) {
    }

    public void addIngredientToRecipe(MouseEvent mouseEvent) {
    }

    public void removeIngredientFromRecipe(MouseEvent mouseEvent) {
    }

    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}