package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Launch {
    public void initialize(){

    }

    public void goToIngredients(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/ingredients.fxml");
    }

    public void goToRecipes(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/recipes.fxml");
    }

    public void goToFoods(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/foods.fxml");
    }

    public void goToMenus(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/menus.fxml");
    }

    public void goToOrders(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/orders.fxml");
    }

    public void goToReservations(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/reservation.fxml");
    }

    public void goToOutOfStocks(MouseEvent mouseEvent) throws IOException {
        navigation(mouseEvent,"/fxml/outofstocks.fxml");
    }

    public void navigation(MouseEvent mouseEvent,String filename) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
}