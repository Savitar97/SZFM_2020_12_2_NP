package result.dao;

import jpa.GenericJPADao;
import result.model.MealDataModel;

import javax.persistence.Persistence;

public class MealDao extends GenericJPADao<MealDataModel> {
    private static MealDao instance;

    private MealDao() {
        super(MealDataModel.class);
    }

    public static MealDao getInstance() {
        if (instance == null) {
            instance = new MealDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("persistence").createEntityManager());
        }
        return instance;
    }
}
