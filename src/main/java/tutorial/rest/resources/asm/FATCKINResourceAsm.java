package tutorial.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import tutorial.core.models.BannerEntities.FATCKIN;
import tutorial.rest.mvc.AccountController;
import tutorial.rest.mvc.FATCKINController;
import tutorial.rest.resources.FATCKINResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by finwebmailer on 6/20/2016.
 *Not sure if I need to include account controller here again. My concern is when *I drop the blog components from the app. Looks like the account part is used *for authenticating the record ownership?
 */
public class FATCKINResourceAsm extends ResourceAssemblerSupport<FATCKIN, FATCKINResource> {
    public FATCKINResourceAsm() {
        super(FATCKINController.class, FATCKINResource.class);
    }

    @Override
    public FATCKINResource toResource(FATCKIN FATCKIN) {
        FATCKINResource resource = new FATCKINResource();

        //selement added July 31


        resource.setFATCKIN_INVH_CODE(FATCKIN.getFATCKIN_INVH_CODE());
        resource.add(linkTo(FATCKINController.class).slash(FATCKIN.getFATCKIN_INVH_CODE()).withSelfRel());

        resource.add(linkTo(FATCKINController.class).slash(FATCKIN.getFATCKIN_INVH_CODE()).slash("fatckin-entries").withRel("entries"));

        resource.setFATCKIN_VEND_FULL_NAME(FATCKIN.getFATCKIN_VEND_FULL_NAME());
        resource.setFATCKIN_VEND_INV(FATCKIN.getFATCKIN_VEND_INV());
        resource.setFATCKIN_CURR_CODE(FATCKIN.getFATCKIN_CURR_CODE());
        resource.setFATCKIN_GROSS_AMT(FATCKIN.getFATCKIN_GROSS_AMT());
        resource.setFATCKIN_NET_AMT(FATCKIN.getFATCKIN_NET_AMT());

        resource.setSelectChq(FATCKIN.getSelectChq());

        return resource;
    }
}
