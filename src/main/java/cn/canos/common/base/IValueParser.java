package cn.canos.common.base;

/**
 * String 类型转换器
 * @param <TValue> 目标转换类型
 */
public interface IValueParser<TValue> {

    /**
     * 将 执行的字符串 转换为 特性类型的一个实例
     * @param text 需要转换的字符串
     * @return 特性类型的一个实例
     */
    TValue parse(String text);
}
