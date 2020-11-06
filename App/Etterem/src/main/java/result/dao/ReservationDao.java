package result.dao;

import jpa.*;
import result.model.*;

import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Transactional
public class ReservationDao extends GenericJPADao<ReservationDataModel> {

    private static ReservationDao instance;

    private ReservationDao() {
        super(ReservationDataModel.class);
    }

    public static ReservationDao getInstance() {
        if (instance == null) {
            instance = new ReservationDao();
            instance.setEntityManager(Persistence.createEntityManagerFactory("persistence").createEntityManager());
        }
        return instance;
    }

}