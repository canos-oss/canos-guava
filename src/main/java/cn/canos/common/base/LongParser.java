package cn.canos.common.base;

/**
 * 将字符串换位为长整型
 */
public class LongParser extends AbstractValueParser<Long> {

    @Override
    protected Long onParse(String text) throws NumberFormatException {
        return Long.parseLong(text);
    }
}
