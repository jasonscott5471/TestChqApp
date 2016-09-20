package tutorial.core.repositories.jpa;

        import org.springframework.stereotype.Repository;
        import tutorial.core.models.BannerEntities.FYBCHKS;
        import tutorial.core.repositories.FYBCHKSRepo;

        import javax.persistence.*;
        import java.util.List;
/**
 * Created by finwebmailer on 7/21/2016.
 */

@Repository
public class JpaFYBCHKSRepo implements FYBCHKSRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public FYBCHKS findFYBCHKS(String FYBCHKS_INVH_CODE) {
        return em.find(FYBCHKS.class, FYBCHKS_INVH_CODE);
    }


    @Override
    public List<FYBCHKS>findAllFYBCHKSs() {
        Query query = em.createQuery("SELECT b from FYBCHKS b");


        return query.getResultList();
    }


    @Override
    public FYBCHKS deleteFYBCHKS(String FYBCHKS_INVH_CODE) {
        FYBCHKS entry = em.find(FYBCHKS.class, FYBCHKS_INVH_CODE);
        em.remove(entry);
        return entry;
    }

    @Override
    public FYBCHKS updateFYBCHKS(String FYBCHKS_INVH_CODE, FYBCHKS data) {
        FYBCHKS  entry = em.find(FYBCHKS.class, FYBCHKS_INVH_CODE);
        entry.setFYBCHKS_DESCRIPTION(data.getFYBCHKS_DESCRIPTION());
        entry.setFYBCHKS_ACTIVITY_DATE(data.getFYBCHKS_ACTIVITY_DATE());
        entry.setFYBCHKS_INVH_CODE(data.getFYBCHKS_INVH_CODE());
        entry.setFYBCHKS_SURROGATE_ID(data.getFYBCHKS_SURROGATE_ID());
        entry.setFYBCHKS_USER_ID(data.getFYBCHKS_USER_ID());
        entry.setFYBCHKS_VERSION(data.getFYBCHKS_VERSION());
        entry.setFYBCHKS_VPDI_CODE(data.getFYBCHKS_VPDI_CODE());
        entry.setFYBCHKS_PRINTCHQ(data.getFYBCHKS_PRINTCHQ());
        entry.setFYBCHKS_VEND_FULL_NAME(data.getFYBCHKS_VEND_FULL_NAME());
        entry.setFYBCHKS_VEND_INV(data.getFYBCHKS_VEND_INV());
        entry.setFYBCHKS_CURR_CODE(data.getFYBCHKS_CURR_CODE());
        entry.setFYBCHKS_NET_AMT(data.getFYBCHKS_NET_AMT());
        return entry;
    }

    @Override
    public FYBCHKS createFYBCHKS(FYBCHKS data) {
        em.persist(data);
        return data;
    }

    /*
    public void callTestAPI(String FYBCHKS_INVH_CODE) {

        Query query = em.createNativeQuery("BEGIN VALIDATE_EMP(P_EMP_ID=>?); END;");
        query.setParameter(1, FYBCHKS_INVH_CODE);
        query.executeUpdate();


    }
*/

 //   public void callTestAPI(String FYBCHKS_INVH_CODE) {
    @Override
 public String callTestAPI(String FYBCHKS_INVH_CODE) {

        //Query query = em.createStoredProcedureQuery("TestCount");
     StoredProcedureQuery query = em.createStoredProcedureQuery("TestCount");

     query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
     query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

     query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);

     query.setParameter(1, "GetUserIDLoggedIn");
        query.setParameter(2, FYBCHKS_INVH_CODE);
        query.executeUpdate();
    // boolean status = query.execute() ;

//     int status = query.executeUpdate();


     String FResult ;
    /*
     if ( status != false) {
         FResult = (String) query.getSingleResult();
        return FResult;
     }
     */

        //String FResult = (String) query.getParameterValue("FResult");
     //String FResult = (String) query.getOutputParameterValue(2);
    // FResult = "No Record Found for that invoice";
    // FResult = (String) query.getSingleResult();
     FResult = query.getOutputParameterValue(3).toString();



        System.out.println("Total records found:" + FResult);

       return FResult;

    }

    @Override
    public List<FYBCHKS>ValidateFYBCHKS() {

        //this fires our cheque validation package
        StoredProcedureQuery query = em.createStoredProcedureQuery("Process_Custom_Cheques_Test");
        query.executeUpdate();


        //get the results
        Query query2 = em.createQuery("SELECT b from FYBCHKS b");


        return query2.getResultList();
    }


    /*
    @Override
    public List<FYBCHKS> findByFYBCHKS_INVH_CODE(String fybchks_invh_code) {
        Query query = em.createQuery("SELECT b FROM FYBCHKS b WHERE b.FYBCHKS_INVH_CODE=?1");
        query.setParameter(1, fybchks_invh_code);
        return query.getResultList();
    } */
}

