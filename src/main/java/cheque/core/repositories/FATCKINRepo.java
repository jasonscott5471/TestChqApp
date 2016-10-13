package cheque.core.repositories;


import cheque.core.models.BannerEntities.FATCKIN;
//import cheque.core.models.BannerEntities.FYBCHKSEntry;

import java.util.List;

/**
 * Created by finwebmailer on 7/19/2016.
 */
public interface FATCKINRepo {
    public List<FATCKIN> findAllFATCKINs();
    public FATCKIN findFATCKIN(String FATCKIN_INVH_CODE);
    public FATCKIN findFATCKINByFATCKIN_VEND_FULL_NAME(String FATCKIN_VEND_FULL_NAME);
    public FATCKIN createFATCKIN(FATCKIN data);
}
