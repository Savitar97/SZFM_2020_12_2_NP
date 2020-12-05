package controller.recipe;

import controller.reservation.ModifyReservation;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;
import result.dao.MealDao;
import result.dao.RecipeDao;
import result.model.IngredientDataModel;
import result.model.MealDataModel;
import result.model.RecipeDataModel;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
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

    public void initialize() {

        recipeDao = RecipeDao.getInstance();
        mealDao = MealDao.getInstance();
        initChoices();

    }

    @FXML
    public void initChoices() {


        List<MealDataModel> meals = mealDao.findAll();

        for (int i = 0; i < meals.size(); i++) {
            recipeChoices.getItems().add(meals.get(i).getName());
            System.out.println(meals.get(i).getName());
        }

    }

    public void recipeSelected(MouseEvent mouseEvent) {

        if (!recipeChoices.getValue().isEmpty()) {
            String mealName = recipeChoices.getValue();
            MealDataModel selectedMeal = mealDao.findByName(mealName);

            List<RecipeDataModel> datas = recipeDao.findAll();
            datas.stream().filter((recipeDataModel) -> {
                return recipeDataModel.getMeal().equals(selectedMeal);
            }).collect(Collectors.toList());
            System.out.println(datas);

            name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RecipeDataModel, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(TableColumn.CellDataFeatures<RecipeDataModel, String> p) {
                    return p.getValue().getIngredient().getNameProperty();
                }
            });


            amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            unit.setCellValueFactory(new PropertyValueFactory<>("unit"));

            ObservableList<RecipeDataModel> observableResult = FXCollections.observableArrayList();
            observableResult.addAll(datas);
            recipeTable.setItems(observableResult);
            recipeTable.refresh();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nincs kiválasztott elem!", ButtonType.CLOSE);
            alert.showAndWait();
        }
    }

    public void modifyAmount(MouseEvent mouseEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/recipeModify.fxml"));
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

    public void addIngredientToRecipe(MouseEvent mouseEvent) {

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

    private void refreshTable() {

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