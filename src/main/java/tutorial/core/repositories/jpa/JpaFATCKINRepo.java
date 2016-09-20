package tutorial.core.repositories.jpa;


import org.springframework.stereotype.Repository;
import tutorial.core.models.BannerEntities.FATCKIN;
import tutorial.core.repositories.FATCKINRepo;
import tutorial.core.services.util.FATCKINList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by finwebmailer on 7/21/2016.
 */

    @Repository
    public class JpaFATCKINRepo implements FATCKINRepo {

        @PersistenceContext
        private EntityManager em;


        @Override
        public List<FATCKIN> findAllFATCKINs() {
            Query query = em.createQuery("SELECT b from FATCKIN b");


            return query.getResultList();
        }

        @Override
        public FATCKIN findFATCKIN(String FATCKIN_INVH_CODE) {
            return em.find(FATCKIN.class, FATCKIN_INVH_CODE);
        }

        @Override
        public FATCKIN findFATCKINByFATCKIN_VEND_FULL_NAME(String FATCKIN_VEND_FULL_NAME) {
            Query query = em.createQuery("SELECT b from FATCKIN b where b.FATCKIN_VEND_FULL_NAME=?1");
            query.setParameter(1, FATCKIN_VEND_FULL_NAME);
            List<FATCKIN> fatckin = query.getResultList();
            if (fatckin.isEmpty()) {
                return null;
            } else {
                return fatckin.get(0);
            }
        }

    @Override
    public FATCKIN createFATCKIN(FATCKIN data) {
        em.persist(data);
        return data;
    }
}

