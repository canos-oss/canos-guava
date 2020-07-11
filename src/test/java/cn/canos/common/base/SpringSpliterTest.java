package cn.canos.common.base;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SpringSpliterTest {

    @Test
    public void parseIntegerList1() {
        String text = "1,2,3";
        List<Integer> expected = Lists.newArrayList(1, 2, 3);

        List<Integer> actual = new SpringSpliter("[,;]").parseIntegerList(text);

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void parseIntegerList2() {
        String text = "1,2,3,a";
        List<Integer> expected = Lists.newArrayList(1, 2, 3);

        List<Integer> actual = new SpringSpliter("[,;]").parseIntegerList(text);

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void parseIntegerList3() {
        String text = "1,2,3,a";
        List<Integer> expected = Lists.newArrayList(1, 2, 3, -1);

        List<Integer> actual = new SpringSpliter().parseIntegerList(text, new IntegerParser(-1));

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void parseIntegerList4() {
        String text = "1,2,3,a";
        List<Integer> expected = Lists.newArrayList(1, 2, 3, -2);

        List<Integer> actual = new SpringSpliter().parseIntegerList(text, -2);

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    @Test
    public void parseIntegerList5() {
        String text = "a,b,c";
        List<Integer> expected = Lists.newArrayList(1, 2, 3);

        List<Integer> actual = new SpringSpliter().parseIntegerList(text, new IValueParser<Integer>() {
            @Override
            public Integer parse(String text) {
                if(Strings.isNullOrEmpty(text)){
                    return null;
                }
                switch (text){
                    case "a":
                        return 1;
                    case "b":
                        return 2;
                    case "c":
                        return 3;
                    default:
                        return  null;
                }
            }
        });

        assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }
}