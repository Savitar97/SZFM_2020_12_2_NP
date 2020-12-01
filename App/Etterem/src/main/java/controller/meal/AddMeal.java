package controller.meal;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.MealDao;
import result.model.MealDataModel;

public class AddMeal {
    @FXML
    public TextField name;
    @FXML
    public TextField price;

    private MealDao dao;

    public void initialize() {

        dao = MealDao.getInstance();

    }
    @FXML
    public void addMeal(MouseEvent mouseEvent) {
        try {
            MealDataModel meal = new MealDataModel();
            meal.setName(name.getText());
            meal.setPrice(Long.parseLong(price.getText()));
            dao.persist(meal);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            dao.getEntityManager().getTransaction().rollback();
        }
    }

    @FXML
    public void returnToMeal(MouseEvent mouseEvent) {
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
