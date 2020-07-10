package cn.canos.common.base;

/**
 * 将字符串换换为整型数字
 */
public class IntegerParser extends AbstractValueParser<Integer> {

    @Override
    protected Integer onParse(String text) throws NumberFormatException {
        return Integer.parseInt(text);
    }
}