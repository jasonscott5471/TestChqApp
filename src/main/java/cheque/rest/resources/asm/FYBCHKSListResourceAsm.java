package cheque.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import cheque.core.services.util.FYBCHKSList;
import cheque.rest.mvc.FYBCHKSController;
import cheque.rest.resources.FYBCHKSListResource;

/**
 * Created by finwebmailer on 7/20/2016.
 */
public class FYBCHKSListResourceAsm extends ResourceAssemblerSupport<FYBCHKSList, FYBCHKSListResource> {


    public FYBCHKSListResourceAsm() {
        super(FYBCHKSController.class, FYBCHKSListResource.class);
    }

    /*
    @Override
    public FYBCHKSListResource toResource(FYBCHKSList FybchksList) {
        List<FYBCHKSResource> resList = new FYBCHKSResourceAsm().toResources(FybchksList.getEntries());
        FYBCHKSListResource finalRes = new FYBCHKSListResource();
        finalRes.setFYBCHKSs(resList);
        return finalRes;
    }
    */
    @Override
    public FYBCHKSListResource toResource(FYBCHKSList fybchksList) {
        FYBCHKSListResource res = new FYBCHKSListResource();
        res.setFYBCHKSs(new FYBCHKSResourceAsm().toResources(fybchksList.getFybchkss()));
        return res;
    }


}
