package tutorial.core.models.BannerEntities;

import java.math.BigDecimal;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * Created by finwebmailer on 6/19/2016.
 */
@Entity
public class FATCKIN {

    //sets the unique key ?
    @Id
    public String FATCKIN_INVH_CODE;

   // @Id @Column(name="FATCKIN_INVH_CODE" ,length=32)

    private String FATCKIN_VEND_FULL_NAME;
    private String FATCKIN_VEND_INV;
    private BigDecimal FATCKIN_GROSS_AMT;
    private BigDecimal FATCKIN_NET_AMT;
    private String FATCKIN_CURR_CODE;

    @Transient
    private Boolean SelectChq = false;

    //selement added Jul 31
    public String getId() {
        return FATCKIN_INVH_CODE;
    }

    public void setId(String FATCKIN_INVH_CODE) {
// or is it ?? this.id = FATCKIN_INVH_CODE;
        this.FATCKIN_INVH_CODE = FATCKIN_INVH_CODE;
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
}

