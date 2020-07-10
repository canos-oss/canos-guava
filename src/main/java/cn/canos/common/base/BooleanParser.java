package cn.canos.common.base;

/**
 * 将字符串转换为布尔类型
 */
public class BooleanParser extends AbstractValueParser<Boolean> {
    @Override
    protected Boolean onParse(String text) throws NumberFormatException {
        return Boolean.parseBoolean(text);
    }
}
