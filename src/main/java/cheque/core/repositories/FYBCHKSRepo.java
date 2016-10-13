package cheque.core.repositories;



import cheque.core.models.BannerEntities.FYBCHKS;

import java.util.List;

/**
 * Created by finwebmailer on 7/21/2016.
 */
public interface FYBCHKSRepo {

    public FYBCHKS findFYBCHKS(String fybchks_invh_code); // Returns the FYBCHKS or null if it can't be found

    public List<FYBCHKS>findAllFYBCHKSs();

    public FYBCHKS deleteFYBCHKS(String fybchks_invh_code); // Deletes the found FYBCHKS or returns null if it can't be found

    /**
     * @param fybchks_invh_code the fybchks_invh_code of the FYBCHKS to updateFYBCHKS
     * @param data              the FYBCHKS containing the data to be used for the updateFYBCHKS
     * @return the updated FYBCHKS or null if the FYBCHKS with the fybchks_invh_code cannot be found
     */
    public FYBCHKS updateFYBCHKS(String fybchks_invh_code, FYBCHKS data);

    public FYBCHKS createFYBCHKS(FYBCHKS data);

    //public void callTestAPI(String fybchks_invh_code);

    public String callTestAPI(String fybchks_invh_code);

    public List<FYBCHKS>ValidateFYBCHKS();

  //  public List<FYBCHKS> findByFYBCHKS_invh_code(String fybchks_invh_code);

    /*
    public void setFYBCHKS_VERSION(BigDecimal FYBCHKS_VERSION) {
        this.FYBCHKS_VERSION = FYBCHKS_VERSION;
    }

    public String getFYBCHKS_VPDI_CODE() {
        return FYBCHKS_VPDI_CODE;
    }

    public void setFYBCHKS_VPDI_CODE(String FYBCHKS_VPDI_CODE) {
        this.FYBCHKS_VPDI_CODE = FYBCHKS_VPDI_CODE;
    }

    public Date getFYBCHKS_ACTIVITY_DATE() {
        return FYBCHKS_ACTIVITY_DATE;
    }

    public void setFYBCHKS_ACTIVITY_DATE(Date FYBCHKS_ACTIVITY_DATE) {
        this.FYBCHKS_ACTIVITY_DATE = FYBCHKS_ACTIVITY_DATE;
    }
*/
}