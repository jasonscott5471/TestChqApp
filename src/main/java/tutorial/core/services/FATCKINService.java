package tutorial.core.services;

import tutorial.core.models.BannerEntities.FATCKIN;
import tutorial.core.services.exceptions.FATCKINNotFoundException;
import tutorial.core.services.util.FATCKINList;

public interface FATCKINService {
    /**
     * @param FATCKIN_INVH_CODE the id of the FATCKIN to add this FYBCHKSEntry to
     * @param data the FYBCHKSEntry containing the data to be used for creating the new entity
     * @return the created FYBCHKSEntry with a generated ID
     * @throws FATCKINNotFoundException if the FATCKIN to add to cannot be found
     */

    public FATCKIN createFATCKIN(FATCKIN data);


    public FATCKIN findFATCKIN(String FATCKIN_INVH_CODE);

    public FATCKINList findAllFATCKINs();


}