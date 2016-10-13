package cheque.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cheque.core.models.BannerEntities.FATCKIN;
import cheque.core.repositories.FATCKINRepo;
import cheque.core.services.FATCKINService;
import cheque.core.services.exceptions.FATCKINExistsException;
import cheque.core.services.util.FATCKINList;


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
