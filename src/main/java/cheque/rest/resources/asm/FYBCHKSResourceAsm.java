package cheque.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import cheque.core.models.BannerEntities.FYBCHKS;
import cheque.rest.mvc.FYBCHKSController;
import cheque.rest.resources.FYBCHKSResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class FYBCHKSResourceAsm extends ResourceAssemblerSupport<FYBCHKS, FYBCHKSResource> {
    public FYBCHKSResourceAsm() {
        super(FYBCHKSController.class, FYBCHKSResource.class);
    }

    @Override
    public FYBCHKSResource toResource(FYBCHKS Fybchks) {
        FYBCHKSResource res = new FYBCHKSResource();

        res.setFYBCHKS_INVH_CODE(Fybchks.getFYBCHKS_INVH_CODE());

        res.add(linkTo(FYBCHKSController.class).slash(Fybchks.getFYBCHKS_INVH_CODE()).withSelfRel());

       // res.add(linkTo(FYBCHKSController.class).slash(Fybchks.getFYBCHKS_INVH_CODE()).slash("entries").withRel("entries"));
        //res.add(linkTo(FYBCHKSController.class).slash(Fybchks.getFYBCHKS_INVH_CODE()).slash("fybchkss").withRel("fybchkss"));


        res.setFYBCHKS_DESCRIPTION(Fybchks.getFYBCHKS_DESCRIPTION());
        res.setFYBCHKS_USER_ID(Fybchks.getFYBCHKS_USER_ID());

        res.setFYBCHKS_SURROGATE_ID(Fybchks.getFYBCHKS_SURROGATE_ID());

        res.setFYBCHKS_ACTIVITY_DATE(Fybchks.getFYBCHKS_ACTIVITY_DATE());

        //added Sept 4, 2016
        res.setFYBCHKS_VEND_FULL_NAME(Fybchks.getFYBCHKS_VEND_FULL_NAME());
        res.setFYBCHKS_VEND_INV(Fybchks.getFYBCHKS_VEND_INV());
        res.setFYBCHKS_CURR_CODE(Fybchks.getFYBCHKS_CURR_CODE());
        res.setFYBCHKS_NET_AMT(Fybchks.getFYBCHKS_NET_AMT());
        res.setFYBCHKS_PRINTCHQ(Fybchks.getFYBCHKS_PRINTCHQ());




        //res.add(linkTo(methodOn(FYBCHKSController.class).getFYBCHKS(Fybchks.getId())).withSelfRel());
        //res.add(linkTo(methodOn(FYBCHKSController.class).findAllBlogs(Fybchks.getId())).withRel("blogs"));



        return res;
    }
}