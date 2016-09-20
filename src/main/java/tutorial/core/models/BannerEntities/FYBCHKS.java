package tutorial.core.models.BannerEntities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;

import javax.persistence.Id;

/**
 * Created by finwebmailer on 6/19/2016.
 */
@Entity
public class FYBCHKS {

    //THIS appears to be a class level variable

    @Id
    public String FYBCHKS_INVH_CODE;


    private String FYBCHKS_USER_ID;
    private String FYBCHKS_DESCRIPTION;
    private BigDecimal FYBCHKS_SURROGATE_ID;
    private BigDecimal FYBCHKS_VERSION;
    private String FYBCHKS_VPDI_CODE;
    private Date FYBCHKS_ACTIVITY_DATE;
    //private BigDecimal FYBCHKS_PRINTCHQ;
    private String FYBCHKS_PRINTCHQ;
    private String FYBCHKS_VEND_FULL_NAME;
    private String FYBCHKS_VEND_INV;
    private String FYBCHKS_CURR_CODE;
    private BigDecimal FYBCHKS_NET_AMT;




    public String getFYBCHKS_INVH_CODE() {
        return FYBCHKS_INVH_CODE;
    }

    public void setFYBCHKS_INVH_CODE(String FYBCHKS_INVH_CODE) {
        this.FYBCHKS_INVH_CODE = FYBCHKS_INVH_CODE;
    }

    public String getFYBCHKS_USER_ID() {
        return FYBCHKS_USER_ID;
    }

    public void setFYBCHKS_USER_ID(String FYBCHKS_USER_ID) {
        this.FYBCHKS_USER_ID = FYBCHKS_USER_ID;
    }

    public String getFYBCHKS_DESCRIPTION() {
        return FYBCHKS_DESCRIPTION;
    }

    public void setFYBCHKS_DESCRIPTION(String FYBCHKS_DESCRIPTION) {
        this.FYBCHKS_DESCRIPTION = FYBCHKS_DESCRIPTION;
    }

    public BigDecimal getFYBCHKS_SURROGATE_ID() {
        return FYBCHKS_SURROGATE_ID;
    }

    public void setFYBCHKS_SURROGATE_ID(BigDecimal FYBCHKS_SURROGATE_ID) {
        this.FYBCHKS_SURROGATE_ID = FYBCHKS_SURROGATE_ID;
    }

    public BigDecimal getFYBCHKS_VERSION() {
        return FYBCHKS_VERSION;
    }

    public  void  setFYBCHKS_VERSION(BigDecimal FYBCHKS_VERSION) {
        this.FYBCHKS_VERSION = FYBCHKS_VERSION;

    }

    public Date getFYBCHKS_ACTIVITY_DATE() {return FYBCHKS_ACTIVITY_DATE;}

    public void  setFYBCHKS_ACTIVITY_DATE(Date FYBCHKS_ACTIVITY_DATE) {
        this.FYBCHKS_ACTIVITY_DATE = FYBCHKS_ACTIVITY_DATE;
    }

    public String getFYBCHKS_VPDI_CODE() {
        return FYBCHKS_VPDI_CODE;
    }

    public void setFYBCHKS_VPDI_CODE(String FYBCHKS_VPDI_CODE) {
        this.FYBCHKS_VPDI_CODE = FYBCHKS_VPDI_CODE;
    }

    public String getFYBCHKS_PRINTCHQ() {
        return FYBCHKS_PRINTCHQ;
    }

    public void setFYBCHKS_PRINTCHQ(String FYBCHKS_PRINTCHQ) {
        this.FYBCHKS_PRINTCHQ = FYBCHKS_PRINTCHQ;
    }

    public String getFYBCHKS_VEND_FULL_NAME() {
        return FYBCHKS_VEND_FULL_NAME;
    }

    public void setFYBCHKS_VEND_FULL_NAME(String FYBCHKS_VEND_FULL_NAME) {
        this.FYBCHKS_VEND_FULL_NAME = FYBCHKS_VEND_FULL_NAME;
    }

    public String getFYBCHKS_VEND_INV() {
        return FYBCHKS_VEND_INV;
    }

    public void setFYBCHKS_VEND_INV(String FYBCHKS_VEND_INV) {
        this.FYBCHKS_VEND_INV = FYBCHKS_VEND_INV;
    }

    public String getFYBCHKS_CURR_CODE() {
        return FYBCHKS_CURR_CODE;
    }

    public void setFYBCHKS_CURR_CODE(String FYBCHKS_CURR_CODE) {
        this.FYBCHKS_CURR_CODE = FYBCHKS_CURR_CODE;
    }

    public BigDecimal getFYBCHKS_NET_AMT() {
        return FYBCHKS_NET_AMT;
    }

    public void setFYBCHKS_NET_AMT(BigDecimal FYBCHKS_NET_AMT) {
        this.FYBCHKS_NET_AMT = FYBCHKS_NET_AMT;
    }
}