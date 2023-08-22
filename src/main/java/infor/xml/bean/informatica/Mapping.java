package infor.xml.bean.informatica;

import java.util.List;

/**
 * 映射对象
 */
public class Mapping {

    private String NAME;

    private String DESCRIPTION;

    private String OBJECTVERSION;

    private String ISVALID;

    private String ISPROFILEMAPPING;

    private String VERSIONNUMBER;

    private String CRCVALUE;

    /**
     * 实例列表
     */
    private List<Instance> instances;

    /**
     * 转换列表
     */
    private List<Transformation> transformations;

    /**
     * 连接器列表
     */
    private List<Connector> connectors;

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

    public String getOBJECTVERSION() {
        return OBJECTVERSION;
    }

    public void setOBJECTVERSION(String OBJECTVERSION) {
        this.OBJECTVERSION = OBJECTVERSION;
    }

    public String getISVALID() {
        return ISVALID;
    }

    public void setISVALID(String ISVALID) {
        this.ISVALID = ISVALID;
    }

    public String getISPROFILEMAPPING() {
        return ISPROFILEMAPPING;
    }

    public void setISPROFILEMAPPING(String ISPROFILEMAPPING) {
        this.ISPROFILEMAPPING = ISPROFILEMAPPING;
    }

    public String getVERSIONNUMBER() {
        return VERSIONNUMBER;
    }

    public void setVERSIONNUMBER(String VERSIONNUMBER) {
        this.VERSIONNUMBER = VERSIONNUMBER;
    }

    public String getCRCVALUE() {
        return CRCVALUE;
    }

    public void setCRCVALUE(String CRCVALUE) {
        this.CRCVALUE = CRCVALUE;
    }

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    public List<Transformation> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<Transformation> transformations) {
        this.transformations = transformations;
    }

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }
}
