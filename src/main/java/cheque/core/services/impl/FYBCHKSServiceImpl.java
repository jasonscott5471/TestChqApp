package cheque.core.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cheque.core.models.BannerEntities.FYBCHKS;
import cheque.core.repositories.FYBCHKSRepo;
import cheque.core.services.FYBCHKSService;
import cheque.core.services.exceptions.FYBCHKSExistsException;
import cheque.core.services.util.FYBCHKSList;


/**
 * Created by finwebmailer on 7/24/2016.
 */


@Service
@Transactional
public class FYBCHKSServiceImpl implements FYBCHKSService {

    @Autowired
    private FYBCHKSRepo Repo;

    @Override
    public FYBCHKS findFYBCHKS(String FYBCHKS_INVH_CODE) {
        return Repo.findFYBCHKS(FYBCHKS_INVH_CODE);
    }


    @Override
    public FYBCHKS createFYBCHKS(FYBCHKS data) {
        FYBCHKS fybchks = Repo.findFYBCHKS(data.getFYBCHKS_INVH_CODE());
        if(fybchks != null)
        {
            throw new FYBCHKSExistsException();
        }
        return Repo.createFYBCHKS(data);
    }

    @Override
    public FYBCHKSList findAllFYBCHKSs() {
        return new FYBCHKSList(Repo.findAllFYBCHKSs());
    }


    @Override
    public FYBCHKS deleteFYBCHKS(String FYBCHKS_INVH_CODE) {
        return Repo.deleteFYBCHKS(FYBCHKS_INVH_CODE);
    }

    @Override
    public FYBCHKS updateFYBCHKS(String FYBCHKS_INVH_CODE, FYBCHKS data) {
        return Repo.updateFYBCHKS(FYBCHKS_INVH_CODE, data);
    }

    @Override
   // public void callTestAPI(String FYBCHKS_INVH_CODE) {
    public String callTestAPI(String FYBCHKS_INVH_CODE) {
        return Repo.callTestAPI(FYBCHKS_INVH_CODE);

    }

    @Override
    public FYBCHKSList ValidateFYBCHKS() {
        return new FYBCHKSList(Repo.ValidateFYBCHKS());
    }
}
