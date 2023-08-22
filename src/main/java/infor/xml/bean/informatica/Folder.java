package infor.xml.bean.informatica;

/**
 * Folder对象
 */
public class Folder {

    private String NAME;
    private String DESCRIPTION;
    private String SHARED;
    private String OWNER;
    private String GROUP;
    private String PERMISSIONS;
    private String UUID;

    /**
     * 数据源
     */
    private Source source;

    /**
     * 目标
     */
    private Target target;

    /**
     * 映射对象
     */
    private Mapping mapping;

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

    public String getSHARED() {
        return SHARED;
    }

    public void setSHARED(String SHARED) {
        this.SHARED = SHARED;
    }

    public String getOWNER() {
        return OWNER;
    }

    public void setOWNER(String OWNER) {
        this.OWNER = OWNER;
    }

    public String getGROUP() {
        return GROUP;
    }

    public void setGROUP(String GROUP) {
        this.GROUP = GROUP;
    }

    public String getPERMISSIONS() {
        return PERMISSIONS;
    }

    public void setPERMISSIONS(String PERMISSIONS) {
        this.PERMISSIONS = PERMISSIONS;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public Mapping getMapping() {
        return mapping;
    }

    public void setMapping(Mapping mapping) {
        this.mapping = mapping;
    }
}
