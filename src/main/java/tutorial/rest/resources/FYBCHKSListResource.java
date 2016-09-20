package tutorial.rest.resources;


import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by finwebmailer on 7/20/2016.
 */
public class FYBCHKSListResource extends ResourceSupport {
    private List<FYBCHKSResource> fybchkss = new ArrayList<FYBCHKSResource>();

    public List<FYBCHKSResource> getfybchkss() {
        return fybchkss;
    }

    public void setFYBCHKSs(List<FYBCHKSResource> fybchkss) {
        this.fybchkss = fybchkss;
    }
}
