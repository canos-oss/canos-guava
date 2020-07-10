package cn.canos.common.base;

/**
 * 将字符串转换为布尔类型
 */
public class BooleanParser extends AbstractValueParser<Boolean> {

    /**
     * 构造函数
     */
    public BooleanParser() {
    }

    /**
     * 构造函数
      * @param defaultValue 转换失败时的默认值
     */
    public BooleanParser(Boolean defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Boolean onParse(String text) throws NumberFormatException {
        return Boolean.parseBoolean(text);
    }
}
