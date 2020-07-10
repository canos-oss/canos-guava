package cn.canos.common.base;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SpringSpliterTest {

    @Test
    public void parseIntegerList() {
        String text = "1,2,3";
        List<Integer> expected = Lists.newArrayList(1, 2, 3);

        List<Integer> actual = new SpringSpliter().parseIntegerList(text);

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void testParseIntegerList() {
        String text = "1,2,3";
        List<Integer> expected = Lists.newArrayList(1, 2, 3);

        List<Integer> actual = new SpringSpliter("[,;]").parseIntegerList(text);

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }
}