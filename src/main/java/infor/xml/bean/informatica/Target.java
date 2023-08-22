package infor.xml.bean.informatica;

import java.util.List;

/**
 * 目标对象
 */
public class Target {

    private String NAME;
    private String BUSINESSNAME;
    private String DESCRIPTION;
    private String OBJECTVERSION;
    private String CONSTRAINT;
    private String TABLEOPTIONS;
    private String TABLETYPE;
    private String DATABASETYPE;
    private String VERSIONNUMBER;
    private String COMPONENTVERSION;
    private String CRCVALUE;

    private List<Targetfield> targetfields;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getBUSINESSNAME() {
        return BUSINESSNAME;
    }

    public void setBUSINESSNAME(String BUSINESSNAME) {
        this.BUSINESSNAME = BUSINESSNAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getOBJECTVERSION() {
        return OBJECTVERSION;
    }

    public void setOBJECTVERSION(String OBJECTVERSION) {
        this.OBJECTVERSION = OBJECTVERSION;
    }

    public String getCONSTRAINT() {
        return CONSTRAINT;
    }

    public void setCONSTRAINT(String CONSTRAINT) {
        this.CONSTRAINT = CONSTRAINT;
    }

    public String getTABLEOPTIONS() {
        return TABLEOPTIONS;
    }

    public void setTABLEOPTIONS(String TABLEOPTIONS) {
        this.TABLEOPTIONS = TABLEOPTIONS;
    }

    public String getTABLETYPE() {
        return TABLETYPE;
    }

    public void setTABLETYPE(String TABLETYPE) {
        this.TABLETYPE = TABLETYPE;
    }

    public String getDATABASETYPE() {
        return DATABASETYPE;
    }

    public void setDATABASETYPE(String DATABASETYPE) {
        this.DATABASETYPE = DATABASETYPE;
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

    public List<Targetfield> getTargetfields() {
        return targetfields;
    }

    public void setTargetfields(List<Targetfield> targetfields) {
        this.targetfields = targetfields;
    }

    /**
     * 字段对象
     */
    public static class Targetfield{
        private String NAME;
        private String BUSINESSNAME;
        private String DESCRIPTION;
        private String DATATYPE;
        private String KEYTYPE;
        private String PRECISION;
        private String SCALE;
        private String FIELDNUMBER;
        private String NULLABLE;
        private String PICTURETEXT;
        private String REFERENCEDTABLE;
        private String REFERENCEDFIELD;
        private String GROUP;
        private String ISFILENAMEFIELD;

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getBUSINESSNAME() {
            return BUSINESSNAME;
        }

        public void setBUSINESSNAME(String BUSINESSNAME) {
            this.BUSINESSNAME = BUSINESSNAME;
        }

        public String getDESCRIPTION() {
            return DESCRIPTION;
        }

        public void setDESCRIPTION(String DESCRIPTION) {
            this.DESCRIPTION = DESCRIPTION;
        }

        public String getDATATYPE() {
            return DATATYPE;
        }

        public void setDATATYPE(String DATATYPE) {
            this.DATATYPE = DATATYPE;
        }

        public String getKEYTYPE() {
            return KEYTYPE;
        }

        public void setKEYTYPE(String KEYTYPE) {
            this.KEYTYPE = KEYTYPE;
        }

        public String getPRECISION() {
            return PRECISION;
        }

        public void setPRECISION(String PRECISION) {
            this.PRECISION = PRECISION;
        }

        public String getSCALE() {
            return SCALE;
        }

        public void setSCALE(String SCALE) {
            this.SCALE = SCALE;
        }

        public String getFIELDNUMBER() {
            return FIELDNUMBER;
        }

        public void setFIELDNUMBER(String FIELDNUMBER) {
            this.FIELDNUMBER = FIELDNUMBER;
        }

        public String getNULLABLE() {
            return NULLABLE;
        }

        public void setNULLABLE(String NULLABLE) {
            this.NULLABLE = NULLABLE;
        }

        public String getPICTURETEXT() {
            return PICTURETEXT;
        }

        public void setPICTURETEXT(String PICTURETEXT) {
            this.PICTURETEXT = PICTURETEXT;
        }

        public String getREFERENCEDTABLE() {
            return REFERENCEDTABLE;
        }

        public void setREFERENCEDTABLE(String REFERENCEDTABLE) {
            this.REFERENCEDTABLE = REFERENCEDTABLE;
        }

        public String getREFERENCEDFIELD() {
            return REFERENCEDFIELD;
        }

        public void setREFERENCEDFIELD(String REFERENCEDFIELD) {
            this.REFERENCEDFIELD = REFERENCEDFIELD;
        }

        public String getGROUP() {
            return GROUP;
        }

        public void setGROUP(String GROUP) {
            this.GROUP = GROUP;
        }

        public String getISFILENAMEFIELD() {
            return ISFILENAMEFIELD;
        }

        public void setISFILENAMEFIELD(String ISFILENAMEFIELD) {
            this.ISFILENAMEFIELD = ISFILENAMEFIELD;
        }
    }
    
}
