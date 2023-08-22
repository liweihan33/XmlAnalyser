package infor.xml.bean.informatica;

import java.util.List;

/**
 * 数据源对象
 */
public class Source {

    private String NAME;
    private String DBDNAME;
    private String BUSINESSNAME;
    private String DESCRIPTION;
    private String OBJECTVERSION;
    private String OWNERNAME;
    private String IBMCOMP;
    private String DATABASETYPE;
    private String DATABASE_SUBTYPE;
    private String VERSIONNUMBER;
    private String COMPONENTVERSION;
    private String CRCVALUE;

    /**
     * 字段列表
     */
    private List<Sourcefield> sourcefields;

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDBDNAME() {
        return DBDNAME;
    }

    public void setDBDNAME(String DBDNAME) {
        this.DBDNAME = DBDNAME;
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

    public String getOWNERNAME() {
        return OWNERNAME;
    }

    public void setOWNERNAME(String OWNERNAME) {
        this.OWNERNAME = OWNERNAME;
    }

    public String getIBMCOMP() {
        return IBMCOMP;
    }

    public void setIBMCOMP(String IBMCOMP) {
        this.IBMCOMP = IBMCOMP;
    }

    public String getDATABASETYPE() {
        return DATABASETYPE;
    }

    public void setDATABASETYPE(String DATABASETYPE) {
        this.DATABASETYPE = DATABASETYPE;
    }

    public String getDATABASE_SUBTYPE() {
        return DATABASE_SUBTYPE;
    }

    public void setDATABASE_SUBTYPE(String DATABASE_SUBTYPE) {
        this.DATABASE_SUBTYPE = DATABASE_SUBTYPE;
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

    public List<Sourcefield> getSourcefields() {
        return sourcefields;
    }

    public void setSourcefields(List<Sourcefield> sourcefields) {
        this.sourcefields = sourcefields;
    }

    /**
     * 字段对象
     */
    public static class Sourcefield {

        private String NAME;
        private String BUSINESSNAME;
        private String DESCRIPTION;
        private String DATATYPE;
        private String KEYTYPE;
        private String PRECISION;
        private String SCALE;
        private String NULLABLE;
        private String USAGE;
        private String USAGE_FLAGS;
        private String LEVEL;
        private String FIELDTYPE;
        private String PICTURETEXT;
        private String OCCURS;
        private String REDEFINES;
        private String REFERENCEDTABLE;
        private String REFERENCEDFIELD;
        private String REFERENCEDDBD;
        private String OFFSET;
        private String LENGTH;
        private String PHYSICALOFFSET;
        private String PHYSICALLENGTH;
        private String FIELDNUMBER;
        private String FIELDPROPERTY;
        private String HIDDEN;
        private String GROUP;
        private String SHIFTSTATE;

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

        public String getNULLABLE() {
            return NULLABLE;
        }

        public void setNULLABLE(String NULLABLE) {
            this.NULLABLE = NULLABLE;
        }

        public String getUSAGE() {
            return USAGE;
        }

        public void setUSAGE(String USAGE) {
            this.USAGE = USAGE;
        }

        public String getUSAGE_FLAGS() {
            return USAGE_FLAGS;
        }

        public void setUSAGE_FLAGS(String USAGE_FLAGS) {
            this.USAGE_FLAGS = USAGE_FLAGS;
        }

        public String getLEVEL() {
            return LEVEL;
        }

        public void setLEVEL(String LEVEL) {
            this.LEVEL = LEVEL;
        }

        public String getFIELDTYPE() {
            return FIELDTYPE;
        }

        public void setFIELDTYPE(String FIELDTYPE) {
            this.FIELDTYPE = FIELDTYPE;
        }

        public String getPICTURETEXT() {
            return PICTURETEXT;
        }

        public void setPICTURETEXT(String PICTURETEXT) {
            this.PICTURETEXT = PICTURETEXT;
        }

        public String getOCCURS() {
            return OCCURS;
        }

        public void setOCCURS(String OCCURS) {
            this.OCCURS = OCCURS;
        }

        public String getREDEFINES() {
            return REDEFINES;
        }

        public void setREDEFINES(String REDEFINES) {
            this.REDEFINES = REDEFINES;
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

        public String getREFERENCEDDBD() {
            return REFERENCEDDBD;
        }

        public void setREFERENCEDDBD(String REFERENCEDDBD) {
            this.REFERENCEDDBD = REFERENCEDDBD;
        }

        public String getOFFSET() {
            return OFFSET;
        }

        public void setOFFSET(String OFFSET) {
            this.OFFSET = OFFSET;
        }

        public String getLENGTH() {
            return LENGTH;
        }

        public void setLENGTH(String LENGTH) {
            this.LENGTH = LENGTH;
        }

        public String getPHYSICALOFFSET() {
            return PHYSICALOFFSET;
        }

        public void setPHYSICALOFFSET(String PHYSICALOFFSET) {
            this.PHYSICALOFFSET = PHYSICALOFFSET;
        }

        public String getPHYSICALLENGTH() {
            return PHYSICALLENGTH;
        }

        public void setPHYSICALLENGTH(String PHYSICALLENGTH) {
            this.PHYSICALLENGTH = PHYSICALLENGTH;
        }

        public String getFIELDNUMBER() {
            return FIELDNUMBER;
        }

        public void setFIELDNUMBER(String FIELDNUMBER) {
            this.FIELDNUMBER = FIELDNUMBER;
        }

        public String getFIELDPROPERTY() {
            return FIELDPROPERTY;
        }

        public void setFIELDPROPERTY(String FIELDPROPERTY) {
            this.FIELDPROPERTY = FIELDPROPERTY;
        }

        public String getHIDDEN() {
            return HIDDEN;
        }

        public void setHIDDEN(String HIDDEN) {
            this.HIDDEN = HIDDEN;
        }

        public String getGROUP() {
            return GROUP;
        }

        public void setGROUP(String GROUP) {
            this.GROUP = GROUP;
        }

        public String getSHIFTSTATE() {
            return SHIFTSTATE;
        }

        public void setSHIFTSTATE(String SHIFTSTATE) {
            this.SHIFTSTATE = SHIFTSTATE;
        }
    }

}
