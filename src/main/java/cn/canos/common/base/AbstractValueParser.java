package cn.canos.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象类型转换器
 * @param <TValue>
 */
public abstract class AbstractValueParser<TValue> implements IValueParser<TValue> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private TValue defaultValue;

    public AbstractValueParser() {
    }

    public AbstractValueParser(TValue defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public TValue parse(String text) {
        try {
            return onParse(text);
        } catch (NumberFormatException e) {
            logger.warn("apply", e);
            return defaultValue;
        }
    }

    protected abstract TValue onParse(String text) throws NumberFormatException;
}