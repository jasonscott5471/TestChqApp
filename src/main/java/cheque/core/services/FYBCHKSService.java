package cheque.core.services;

import cheque.core.models.BannerEntities.FYBCHKS;
import cheque.core.services.util.FYBCHKSList;

/**
 * Created by finwebmailer on 6/19/2016.
 */
public interface FYBCHKSService {


    /**
     * @param FYBCHKS_INVH_CODE the id of the FYBCHKS to updateFYBCHKS
     * @param data the FYBCHKS containing the data to be used for the updateFYBCHKS
     * @return the updated FYBCHKS or null if the FYBCHKS with the id cannot be found
     */

    public FYBCHKS createFYBCHKS(FYBCHKS data) ;
    public FYBCHKS updateFYBCHKS(String FYBCHKS_INVH_CODE, FYBCHKS data);
    public FYBCHKS findFYBCHKS(String FYBCHKS_INVH_CODE); // Returns the FYBCHKS or null if it can't be found
    public FYBCHKS deleteFYBCHKS(String FYBCHKS_INVH_CODE); // Deletes the found FYBCHKS or returns null if it can't be found
    public FYBCHKSList findAllFYBCHKSs();


   // void callTestAPI(String FYBCHKS_INVH_CODE);

   //String callTestAPI(String FYBCHKS_INVH_CODE);
    public  String callTestAPI(String FYBCHKS_INVH_CODE);

    public FYBCHKSList ValidateFYBCHKS();
}
