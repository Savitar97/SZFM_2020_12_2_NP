package controller.recipe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import result.dao.IngredientDao;
import result.dao.MealDao;
import result.dao.RecipeDao;
import result.model.MealDataModel;
import result.model.RecipeDataModel;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


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

    private MealDao mealDao;

    private IngredientDao ingredientDao;

    public void initialize() {

        recipeDao = RecipeDao.getInstance();
        mealDao = MealDao.getInstance();
        ingredientDao = IngredientDao.getInstance();
        initChoices();

    }

    @FXML
    public void initChoices() {


        List<MealDataModel> meals = mealDao.findAll();

        for (MealDataModel meal : meals) {
            recipeChoices.getItems().add(meal.getName());
            System.out.println(meal.getName());
        }

    }

    public void recipeSelected(MouseEvent mouseEvent) {

        if (!recipeChoices.getValue().isEmpty()) {
            refreshTable();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott étel!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    public void modifyRecipe(MouseEvent mouseEvent) {
        if (recipeChoices.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott módosítandó recept!", ButtonType.CLOSE);
            alert.showAndWait();
        } else if (recipeTable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott módosítandó alapanyag!", ButtonType.CLOSE);
            alert.showAndWait();
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/recipeModify.fxml"));
                Parent root = fxmlLoader.load();
                fxmlLoader.<ModifyRecipe>getController().setSelectedMeal(mealDao.findByName(recipeChoices.getValue()));
                fxmlLoader.<ModifyRecipe>getController().setSelectedIngredient(recipeTable.getSelectionModel().getSelectedItem().getIngredient());
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.initOwner(((Node) mouseEvent.getSource()).getScene().getWindow());
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setOnHiding(event -> refreshTable());
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addIngredientToRecipe(MouseEvent mouseEvent) {

        if (recipeChoices.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott étel!", ButtonType.CLOSE);
            alert.showAndWait();
        } else {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/recipeAdd.fxml"));
                Parent root = fxmlLoader.load();
                fxmlLoader.<AddRecipe>getController().setSelectedMeal(mealDao.findByName(recipeChoices.getValue()));
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.initStyle(StageStyle.UNDECORATED);
                stage.setScene(new Scene(root));
                stage.initOwner(((Node) mouseEvent.getSource()).getScene().getWindow());
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setOnHiding(event -> refreshTable());
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeIngredientFromRecipe(MouseEvent mouseEvent) {

        if (recipeChoices.getValue().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott módosítandó recept!", ButtonType.CLOSE);
            alert.showAndWait();
        } else if (recipeTable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott módosítandó alapanyag!", ButtonType.CLOSE);
            alert.showAndWait();
        } else {
            try {
                recipeDao.remove(recipeTable.getSelectionModel().getSelectedItem());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshTable() {

        String mealName = recipeChoices.getValue();
        MealDataModel selectedMeal = mealDao.findByName(mealName);

        List<RecipeDataModel> data = recipeDao.findAll();
        data.stream().filter((recipeDataModel) -> recipeDataModel.getMeal().equals(selectedMeal)).collect(Collectors.toList());
        System.out.println(data);

        name.setCellValueFactory(p -> p.getValue().getIngredient().getNameProperty());

        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        ObservableList<RecipeDataModel> observableResult = FXCollections.observableArrayList();
        observableResult.addAll(data);
        recipeTable.setItems(observableResult);
        recipeTable.refresh();

    }

    public void returnMainMenu(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/launch.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}