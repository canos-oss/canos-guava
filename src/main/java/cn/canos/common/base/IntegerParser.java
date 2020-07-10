package cn.canos.common.base;

/**
 * 将字符串换换为整型数字
 */
public class IntegerParser extends AbstractValueParser<Integer> {

    /**
     * 构造函数
     */
    public IntegerParser() {
    }

    /**
     * 构造函数
     * @param defaultValue 转换失败时的默认值
     */
    public IntegerParser(Integer defaultValue) {
        super(defaultValue);
    }

    @Override
    protected Integer onParse(String text) throws NumberFormatException {
        return Integer.parseInt(text);
    }
}