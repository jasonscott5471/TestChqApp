package cheque.rest.resources;
import org.springframework.hateoas.ResourceSupport;
import cheque.core.models.BannerEntities.FATCKIN;

import java.math.BigDecimal;

/**
 * Created by finwebmailer on 6/20/2016.
 */
public class FATCKINResource extends ResourceSupport {

    private String FATCKIN_INVH_CODE;
    private String FATCKIN_VEND_FULL_NAME;
    private String FATCKIN_VEND_INV;
    private BigDecimal FATCKIN_GROSS_AMT;
    private BigDecimal FATCKIN_NET_AMT;
    private String FATCKIN_CURR_CODE;

    //@Transient
    private Boolean SelectChq;

    {
        SelectChq = false;
    }


    public String getFATCKIN_INVH_CODE() {
        return FATCKIN_INVH_CODE;
    }

    public void setFATCKIN_INVH_CODE(String FATCKIN_INVH_CODE) {
        this.FATCKIN_INVH_CODE = FATCKIN_INVH_CODE;
    }

    public String getFATCKIN_VEND_FULL_NAME() {
        return FATCKIN_VEND_FULL_NAME;
    }

    public void setFATCKIN_VEND_FULL_NAME(String FATCKIN_VEND_FULL_NAME) {
        this.FATCKIN_VEND_FULL_NAME = FATCKIN_VEND_FULL_NAME;
    }

    public String getFATCKIN_VEND_INV() {
        return FATCKIN_VEND_INV;
    }

    public void setFATCKIN_VEND_INV(String FATCKIN_VEND_INV) {
        this.FATCKIN_VEND_INV = FATCKIN_VEND_INV;
    }

    public BigDecimal getFATCKIN_GROSS_AMT() {
        return FATCKIN_GROSS_AMT;
    }

    public void setFATCKIN_GROSS_AMT(BigDecimal FATCKIN_GROSS_AMT) {
        this.FATCKIN_GROSS_AMT = FATCKIN_GROSS_AMT;
    }

    public BigDecimal getFATCKIN_NET_AMT() {
        return FATCKIN_NET_AMT;
    }

    public void setFATCKIN_NET_AMT(BigDecimal FATCKIN_NET_AMT) {
        this.FATCKIN_NET_AMT = FATCKIN_NET_AMT;
    }

    public String getFATCKIN_CURR_CODE() {
        return FATCKIN_CURR_CODE;
    }

    public void setFATCKIN_CURR_CODE(String FATCKIN_CURR_CODE) {
        this.FATCKIN_CURR_CODE = FATCKIN_CURR_CODE;
    }

    public  Boolean getSelectChq() {
        return SelectChq;
    }

    public void setSelectChq(Boolean selectChq) {
        this.SelectChq = selectChq;
    }

    public FATCKIN toFATCKIN() {
        FATCKIN fatckin = new FATCKIN();



        fatckin.setFATCKIN_INVH_CODE(FATCKIN_INVH_CODE);
        fatckin.setFATCKIN_VEND_FULL_NAME(FATCKIN_VEND_FULL_NAME);
        fatckin.setFATCKIN_VEND_INV(FATCKIN_VEND_INV);
        fatckin.setFATCKIN_CURR_CODE(FATCKIN_CURR_CODE);
        fatckin.setFATCKIN_GROSS_AMT(FATCKIN_GROSS_AMT);
        fatckin.setFATCKIN_NET_AMT(FATCKIN_NET_AMT);


        return fatckin;
    }
}
