package infor.xml.bean.informatica;

/**
 * 链接对象
 */
public class Connector {

    private String FROMINSTANCE;
    private String FROMINSTANCETYPE;
    private String FROMFIELD;
    private String TOINSTANCE;
    private String TOINSTANCETYPE;
    private String TOFIELD;

    public String getFROMINSTANCE() {
        return FROMINSTANCE;
    }

    public void setFROMINSTANCE(String FROMINSTANCE) {
        this.FROMINSTANCE = FROMINSTANCE;
    }

    public String getFROMINSTANCETYPE() {
        return FROMINSTANCETYPE;
    }

    public void setFROMINSTANCETYPE(String FROMINSTANCETYPE) {
        this.FROMINSTANCETYPE = FROMINSTANCETYPE;
    }

    public String getFROMFIELD() {
        return FROMFIELD;
    }

    public void setFROMFIELD(String FROMFIELD) {
        this.FROMFIELD = FROMFIELD;
    }

    public String getTOINSTANCE() {
        return TOINSTANCE;
    }

    public void setTOINSTANCE(String TOINSTANCE) {
        this.TOINSTANCE = TOINSTANCE;
    }

    public String getTOINSTANCETYPE() {
        return TOINSTANCETYPE;
    }

    public void setTOINSTANCETYPE(String TOINSTANCETYPE) {
        this.TOINSTANCETYPE = TOINSTANCETYPE;
    }

    public String getTOFIELD() {
        return TOFIELD;
    }

    public void setTOFIELD(String TOFIELD) {
        this.TOFIELD = TOFIELD;
    }
}
