package result.dao;

import jpa.*;
import result.model.*;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<IngredientDataModel> findOutOfStock() {
        return entityManager.createQuery("SELECT r FROM IngredientDataModel r WHERE r.amount<10", IngredientDataModel.class)
                .getResultList();
    }

    public IngredientDataModel findByName(String name){

       return entityManager.createQuery("SELECT r FROM IngredientDataModel r WHERE r.name=" + name, IngredientDataModel.class).getResultList().get(0);
    }

}