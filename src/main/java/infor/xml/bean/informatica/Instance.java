package infor.xml.bean.informatica;

/**
 * 实例对象
 */
public class Instance {

    private String NAME;
    private String DESCRIPTION;
    private String TYPE;
    private String REUSABLE;
    private String TRANSFORMATION_TYPE;
    private String TRANSFORMATION_NAME;
    private String DBDNAME;
    private String ASSOCIATED_DSQ;
    private String ASSOCIATED_DSQ_TYPE;
    private String INSTANCEID;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getREUSABLE() {
        return REUSABLE;
    }

    public void setREUSABLE(String REUSABLE) {
        this.REUSABLE = REUSABLE;
    }

    public String getTRANSFORMATION_TYPE() {
        return TRANSFORMATION_TYPE;
    }

    public void setTRANSFORMATION_TYPE(String TRANSFORMATION_TYPE) {
        this.TRANSFORMATION_TYPE = TRANSFORMATION_TYPE;
    }

    public String getTRANSFORMATION_NAME() {
        return TRANSFORMATION_NAME;
    }

    public void setTRANSFORMATION_NAME(String TRANSFORMATION_NAME) {
        this.TRANSFORMATION_NAME = TRANSFORMATION_NAME;
    }

    public String getDBDNAME() {
        return DBDNAME;
    }

    public void setDBDNAME(String DBDNAME) {
        this.DBDNAME = DBDNAME;
    }

    public String getASSOCIATED_DSQ() {
        return ASSOCIATED_DSQ;
    }

    public void setASSOCIATED_DSQ(String ASSOCIATED_DSQ) {
        this.ASSOCIATED_DSQ = ASSOCIATED_DSQ;
    }

    public String getASSOCIATED_DSQ_TYPE() {
        return ASSOCIATED_DSQ_TYPE;
    }

    public void setASSOCIATED_DSQ_TYPE(String ASSOCIATED_DSQ_TYPE) {
        this.ASSOCIATED_DSQ_TYPE = ASSOCIATED_DSQ_TYPE;
    }

    public String getINSTANCEID() {
        return INSTANCEID;
    }

    public void setINSTANCEID(String INSTANCEID) {
        this.INSTANCEID = INSTANCEID;
    }
}
