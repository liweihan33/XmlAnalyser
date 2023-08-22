package infor.xml.bean.informatica;

import java.util.List;

/**
 * 转换对象
 */
public class Transformation {

    private String NAME;
    private String DESCRIPTION;
    private String TYPE;
    private String OBJECTVERSION;
    private String REUSABLE;
    private String ISVSAM_NORMALIZER;
    private String REF_SOURCE_NAME;
    private String REF_DBD_NAME;
    private String TEMPLATEID;
    private String TEMPLATENAME;
    private String PARENT;
    private String PARENT_TYPE;
    private String VERSIONNUMBER;
    private String COMPONENTVERSION;
    private String CRCVALUE;

    /**
     * 转换字段对象列表
     */
    List<Transformfield> transformfields;

    List<Tableattribute> tableattributes;

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

    public String getOBJECTVERSION() {
        return OBJECTVERSION;
    }

    public void setOBJECTVERSION(String OBJECTVERSION) {
        this.OBJECTVERSION = OBJECTVERSION;
    }

    public String getREUSABLE() {
        return REUSABLE;
    }

    public void setREUSABLE(String REUSABLE) {
        this.REUSABLE = REUSABLE;
    }

    public String getISVSAM_NORMALIZER() {
        return ISVSAM_NORMALIZER;
    }

    public void setISVSAM_NORMALIZER(String ISVSAM_NORMALIZER) {
        this.ISVSAM_NORMALIZER = ISVSAM_NORMALIZER;
    }

    public String getREF_SOURCE_NAME() {
        return REF_SOURCE_NAME;
    }

    public void setREF_SOURCE_NAME(String REF_SOURCE_NAME) {
        this.REF_SOURCE_NAME = REF_SOURCE_NAME;
    }

    public String getREF_DBD_NAME() {
        return REF_DBD_NAME;
    }

    public void setREF_DBD_NAME(String REF_DBD_NAME) {
        this.REF_DBD_NAME = REF_DBD_NAME;
    }

    public String getTEMPLATEID() {
        return TEMPLATEID;
    }

    public void setTEMPLATEID(String TEMPLATEID) {
        this.TEMPLATEID = TEMPLATEID;
    }

    public String getTEMPLATENAME() {
        return TEMPLATENAME;
    }

    public void setTEMPLATENAME(String TEMPLATENAME) {
        this.TEMPLATENAME = TEMPLATENAME;
    }

    public String getPARENT() {
        return PARENT;
    }

    public void setPARENT(String PARENT) {
        this.PARENT = PARENT;
    }

    public String getPARENT_TYPE() {
        return PARENT_TYPE;
    }

    public void setPARENT_TYPE(String PARENT_TYPE) {
        this.PARENT_TYPE = PARENT_TYPE;
    }

    public String getVERSIONNUMBER() {
        return VERSIONNUMBER;
    }

    public void setVERSIONNUMBER(String VERSIONNUMBER) {
        this.VERSIONNUMBER = VERSIONNUMBER;
    }

    public String getCOMPONENTVERSION() {
        return COMPONENTVERSION;
    }

    public void setCOMPONENTVERSION(String COMPONENTVERSION) {
        this.COMPONENTVERSION = COMPONENTVERSION;
    }

    public String getCRCVALUE() {
        return CRCVALUE;
    }

    public void setCRCVALUE(String CRCVALUE) {
        this.CRCVALUE = CRCVALUE;
    }

    public List<Transformfield> getTransformfields() {
        return transformfields;
    }

    public void setTransformfields(List<Transformfield> transformfields) {
        this.transformfields = transformfields;
    }

    public List<Tableattribute> getTableattributes() {
        return tableattributes;
    }

    public void setTableattributes(List<Tableattribute> tableattributes) {
        this.tableattributes = tableattributes;
    }

    /**
     * 转换字段对象
     */
    public static class Transformfield {

        private String NAME;
        private String TYPE;
        private String DATATYPE;
        private String DESCRIPTION;
        private String DEFAULTVALUE;
        private String ORDER;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getDATATYPE() {
            return DATATYPE;
        }

        public void setDATATYPE(String DATATYPE) {
            this.DATATYPE = DATATYPE;
        }

        public String getDESCRIPTION() {
            return DESCRIPTION;
        }

        public void setDESCRIPTION(String DESCRIPTION) {
            this.DESCRIPTION = DESCRIPTION;
        }

        public String getDEFAULTVALUE() {
            return DEFAULTVALUE;
        }

        public void setDEFAULTVALUE(String DEFAULTVALUE) {
            this.DEFAULTVALUE = DEFAULTVALUE;
        }

        public String getORDER() {
            return ORDER;
        }

        public void setORDER(String ORDER) {
            this.ORDER = ORDER;
        }
    }

    /**
     * 转换配置对象
     */
    public static class Tableattribute {
        private String NAME;
        private String VALUE;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getVALUE() {
            return VALUE;
        }

        public void setVALUE(String VALUE) {
            this.VALUE = VALUE;
        }
    }

}
