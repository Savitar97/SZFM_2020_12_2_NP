package result;

import jpa.GenericJPADao;
import result.model.IngredientDataModel;

import javax.persistence.Persistence;

public class IngredientDao extends GenericJPADao<IngredientDataModel> {
    private static IngredientDao instance;

    private IngredientDao() {
        super(IngredientDataModel.class);
    }

    public static IngredientDao getInstance() {
        if (instance == null) {
            instance = new IngredientDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("persistence").createEntityManager());
        }
        return instance;
    }

}