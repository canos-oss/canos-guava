package cn.canos.common.base;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 字符分割工具
 * harriszhang@live.cn
 */
public class SpringSpliter {

    private static final IntegerParser INTEGER_STRING_PARSER = new IntegerParser();

    private static final LongParser LONG_STRING_PARSER = new LongParser();

    private String regex;

    public SpringSpliter() {
        this.regex = ",";
    }

    public SpringSpliter(String regex) {
        this.regex = regex;
    }

    public List<Integer> parseIntegerList(String text) {
        return parse(text, INTEGER_STRING_PARSER);
    }

    public List<Integer> parseIntegerList(String text, Integer defaultValue) {
        return parse(text, new IntegerParser(defaultValue));
    }

    public List<Integer> parseIntegerList(String text, IntegerParser parser) {
        return parse(text, parser);
    }

    public List<Integer> parseIntegerList(String text, IValueParser<Integer> parser) {
        return parse(text, parser);
    }

    public List<Long> parseLongList(String text) {
        return parse(text, LONG_STRING_PARSER);
    }

    public List<Long> parseLongList(String text, Long defaultValue) {
        return parse(text, new LongParser(defaultValue));
    }

    public List<Long> parseLongList(String text, LongParser parser) {
        return parse(text, parser);
    }

    public List<Long> parseLongList(String text, IValueParser<Long> parser) {
        return parse(text, parser);
    }

    /**
     * 将字符串解析为特定类型的列表
     *
     * @param text     需要解析的字符串
     * @param parser   类型转换器
     * @param <TValue> 目标特定类型
     * @return 特定类型列表
     */
    public <TValue> List<TValue> parse(String text, IValueParser<TValue> parser) {
        if (text == null) {
            return null;
        }

        String[] items = text.split(regex);
        if (items.length == 0) {
            return Lists.newArrayListWithCapacity(0);
        }

        List<TValue> arrayList = Lists.newArrayListWithCapacity(items.length);
        for (String item : items) {
            TValue tValue = parser.parse(item);
            if (tValue == null) {
                continue;
            }
            arrayList.add(tValue);
        }

        return arrayList;
    }
}
