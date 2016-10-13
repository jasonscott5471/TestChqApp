package cheque.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import cheque.core.services.util.FATCKINList;
import cheque.rest.mvc.FATCKINController;
import cheque.rest.resources.FATCKINListResource;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class FATCKINListResourceAsm extends ResourceAssemblerSupport<FATCKINList, FATCKINListResource> {

    public FATCKINListResourceAsm()
    {
        super(FATCKINController.class, FATCKINListResource.class);
    }

    @Override
    public FATCKINListResource toResource(FATCKINList fatckinList) {
        FATCKINListResource res = new FATCKINListResource();
        res.setFATCKINs(new FATCKINResourceAsm().toResources(fatckinList.getFatckins()));
        return res;
    }
}