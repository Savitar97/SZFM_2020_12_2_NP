package result.dao;

import jpa.*;
import result.model.*;

import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Transactional
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