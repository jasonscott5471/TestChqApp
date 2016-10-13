package cheque.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class FATCKINListResource extends ResourceSupport {
    private List<FATCKINResource> fatckins = new ArrayList<FATCKINResource>();

    public List<FATCKINResource> getFATCKINs() {
        return fatckins;
    }

    public void setFATCKINs(List<FATCKINResource> fatckins) {
        this.fatckins = fatckins;
    }
}

