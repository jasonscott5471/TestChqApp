package tutorial.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.core.models.BannerEntities.FATCKIN;
import tutorial.core.repositories.FATCKINRepo;
import tutorial.core.services.FATCKINService;
import tutorial.core.services.exceptions.FATCKINExistsException;
import tutorial.core.services.exceptions.FATCKINNotFoundException;
import tutorial.core.services.util.FATCKINList;


/**
 * Created by finwebmailer on 7/24/2016.
 */
@Service
@Transactional
public class FATCKINServiceImpl implements FATCKINService {

    @Autowired
    private FATCKINRepo FATCKINRepo;



    @Override
    public FATCKIN createFATCKIN(FATCKIN data) {
        FATCKIN fatckin = FATCKINRepo.findFATCKIN(data.getFATCKIN_INVH_CODE());
        if(fatckin != null)
        {
            throw new FATCKINExistsException();
        }
        return FATCKINRepo.createFATCKIN(data);
    }

    @Override
    public FATCKINList findAllFATCKINs() {
        return new FATCKINList(FATCKINRepo.findAllFATCKINs());
    }




    @Override
    public FATCKIN findFATCKIN(String fatckin_invh_code) {

        return FATCKINRepo.findFATCKIN(fatckin_invh_code);
    }




}
