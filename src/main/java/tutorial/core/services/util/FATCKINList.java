package tutorial.core.services.util;
import tutorial.core.models.BannerEntities.FATCKIN;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by finwebmailer on 6/20/2016.
 */
public class FATCKINList {

    private List<FATCKIN> fatckins = new ArrayList<FATCKIN>();

    public FATCKINList(List<FATCKIN> resultList)  {
        this.fatckins = resultList;
    }

    public List<FATCKIN> getFatckins() {
        return fatckins;
    }

    public void setFatckins(List<FATCKIN> fatckins) {
        this.fatckins = fatckins;
    }


}