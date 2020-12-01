package controller.meal;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import result.dao.MealDao;
import result.model.MealDataModel;

public class ModifyMeal {
    @FXML
    public TextField newName;
    @FXML
    public TextField newPrice;

    private MealDao dao;

    private static MealDataModel meal;

    public void initialize() {

        dao = MealDao.getInstance();

    }
    public void setDataModel (MealDataModel selectedItem){

        this.meal = selectedItem;

        newName.setText(meal.getName());
        newPrice.setText(meal.getPrice().toString());

    }

    public void modifyMeal(MouseEvent mouseEvent) {

        try {

            meal.setName(newName.getText());
            meal.setPrice(Long.parseLong(newPrice.getText()));
            dao.update(meal);

            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            System.out.println( e.getClass() + ": "+ e.getMessage());
            dao.getEntityManager().getTransaction().rollback();
        }
    }

    public void returnToMeal(MouseEvent mouseEvent) {

        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
