package result.dao;

import jpa.GenericJPADao;
import result.model.RecipeDataModel;

import javax.persistence.Persistence;

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
}
