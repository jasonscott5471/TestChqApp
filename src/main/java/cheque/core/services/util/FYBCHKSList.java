package cheque.core.services.util;

import cheque.core.models.BannerEntities.FYBCHKS;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by finwebmailer on 6/19/2016.
 */

/*
public class FYBCHKSList {

    private List<FYBCHKS> entries = new ArrayList<FYBCHKS>();
    private String FYBCHKS_INVH_CODE;

    public FYBCHKSList(List<FYBCHKS> byFYBCHKS_invh_code) {

    }


    public List<FYBCHKS>getEntries() {return entries;}

    public void setEntries(List<FYBCHKS> entries) {
        this.entries = entries;
    }

    public String getFYBCHKS_INVH_CODE() {
        return FYBCHKS_INVH_CODE;
    }

    public void setFYBCHKS_INVH_CODE(String FYBCHKS_INVH_CODE) {
        this.FYBCHKS_INVH_CODE = FYBCHKS_INVH_CODE;
    }

}
*/
public class FYBCHKSList {

    private List<FYBCHKS> fybchkss = new ArrayList<FYBCHKS>();

    public FYBCHKSList(List<FYBCHKS> resultList)  {
        this.fybchkss = resultList;
    }

    public List<FYBCHKS> getFybchkss() {
        return fybchkss;
    }

    public void setFybchkss(List<FYBCHKS> fybchkss) {
        this.fybchkss = fybchkss;
    }


}
