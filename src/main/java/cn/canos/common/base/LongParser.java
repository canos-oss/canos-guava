package cn.canos.common.base;

/**
 * 将字符串换位为长整型
 */
public class LongParser extends AbstractValueParser<Long> {

    /**
     * 构造函数
     */
    public LongParser() {
    }

    /**
     * 构造函数
     * @param defaultValue 转换失败时的默认值
     */
    public LongParser(Long defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Long onParse(String text) throws NumberFormatException {
        return Long.parseLong(text);
    }
}
