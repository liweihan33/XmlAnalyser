package infor.xml.bean.informatica;

import java.util.List;

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
    private List<Source> sources;

    /**
     * 目标
     */
    private List<Target> targets;

    /**
     * 映射对象
     */
    private List<Mapping> mappings;

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

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    public void setMappings(List<Mapping> mappings) {
        this.mappings = mappings;
    }
}
