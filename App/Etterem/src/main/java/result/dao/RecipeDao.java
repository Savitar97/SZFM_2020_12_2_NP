package result.dao;

import jpa.GenericJPADao;
import result.model.IngredientDataModel;
import result.model.MealDataModel;
import result.model.RecipeDataModel;

import javax.persistence.Persistence;
import java.util.List;

public class RecipeDao extends GenericJPADao<RecipeDataModel> {
    private static RecipeDao instance;

    private RecipeDao() {
        super(RecipeDataModel.class);
    }

    public static RecipeDao getInstance() {
        if (instance == null) {
            instance = new RecipeDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("persistence").createEntityManager());
        }
        return instance;
    }

    public List<RecipeDataModel> findRecipe(MealDataModel meal){
        return entityManager.createQuery("SELECT r FROM RecipeDataModel r WHERE r.meal:=meal", RecipeDataModel.class)
                .getResultList();
    }
}
