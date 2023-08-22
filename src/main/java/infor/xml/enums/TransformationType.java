package infor.xml.enums;

/**
 * informatica转换类型
 */
public enum TransformationType {

    /**
     * Source Qualifier转换
     */
    SOURCE_QUALIFIER("Source Qualifier");

    TransformationType(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
