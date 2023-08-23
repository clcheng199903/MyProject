package asia.clcheng.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexTest {
    @Test
    void test1() {
        String reg = "\\[([^\\]]+)\\]"; // 首先是java通过\\转义为\，而表达式也需要\\转义为\\，所以综合\\\\代表匹配到正则的\字符
        String str = "您好! 您创阿金的订单:[orderNo], 已经发货, 请知悉! 收货地址:[address]";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1)); // 捕获组，还是要通过括号内去确认；不同的捕获组通过参数分别读取
        }
    }

    /**
     * 捕获组：是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建
     */
    @Test
    void test2() {
        String reg = "(\\\\+)";
        String str = "一个：\\，两个：\\\\";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) {
//            System.out.println(m.group(1));
            System.out.println(m.group());
        }
    }

    /**
     * 按空字符分割
     */
    @Test
    void test3() {
        /**
         * [^\\s=]+ 会找到所有不是空格或 = 的东西
         */
        String reg = "[^\\s=]+(=\"[^\"]+\")?";
        String str = "2013-10-26    15:16:38:011+0200 name=\"twitter-message\" from_user=\"MyUser\" in_reply_to=\"null\" start_time=\"Sat Oct 26 15:16:21 CEST 2013\" event_id=\"394090123278974976\" text=\"Some text\" retweet_count=\"1393\"";
        Matcher m = Pattern.compile(reg).matcher(str);
        while (m.find())
            System.out.println(m.group());
    }

    /**
     * Matcher类获取详细的捕获组信息
     */
    @Test
    void test4() {
        String reg = "abc";
        String str = "dafasdfoasdfabcadsfadsfabca";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) { // find会往后移动position；实际上java的正则表达式是一次匹配，通过find()往后移动，继续匹配
            System.out.println(m.group(0));
            System.out.println(m.group()); // 无参group()方法可以匹配到非括号形式的匹配组
            System.out.println(m.start());
            System.out.println(m.end()); // 左闭右开
        }
    }

    /**
     * 有参无参group()方法的调用和用法：
     * 1.group()和group(0)功能一致，都是表示一个正则表达式的完整匹配
     * 2.group(x)，表示对应的匹配组
     */
    @Test
    void test5() {
        String reg = "d(a(fa)s)df";
        String str = "dafasdfoasdfabcadsfadsfabca";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) { // find会往后移动position；实际上java的正则表达式是一次匹配，通过find()往后移动，继续匹配
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
//            System.out.println(m.group(3));
            System.out.println(m.group()); // 无参group()方法可以匹配到非括号形式的匹配组
            System.out.println(m.start());
            System.out.println(m.end()); // 左闭右开
        }
    }

    /**
     * 根据空格字符分割字符串为数组
     */
    @Test
    void test6() {
        String reg = "\\S+";
        String str = "  A B C - ";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        List<String> array = new ArrayList<>();
        while (m.find()) {
            array.add(m.group());
        }
        System.out.println(array.size());
        System.out.println(array);
    }

    /**
     * 解析源文本文件
     */
    @Test
    void test7() {
        List<String> array = new ArrayList<>();
        array.add("    58                                                                          ");
        array.add("Time for PA28X");
        array.add("Record    1 of section \"Y\", run \"y-02g-1_1\"");
        array.add("         2    247762         1  1.79271e+01  3.12500e-04  0.00000e+00   ");
        array.add("        17    0    0    0 X-axis               s               ");
    }

    @Test
    void test8() {
        String reg = "\\s+";
        String str = "  Time for PA28X  ";
        String[] array = str.trim().split(reg);
        System.out.println(Arrays.toString(array));
    }

    /**
     * ^的用法：
     * 1.^abc以什么开头
     * 2.[^abc]不包含：不包含abc的字符匹配
     */
    @Test
    void test9() {
        String reg = "[^abc]"; // 取非a b c字符的其它字符
        String str = "abcd";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);

        while (m.find()) {
            System.out.println(m.group());
        }
    }

    @Test
    void test10() {
        String reg = "^(abc)"; // 以abc开头，限制了开头这个条件
        String str = "aabcd";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);

        while (m.find()) {
            System.out.println(m.group());
        }
    }

    /**
     * $：以什么结尾
     */
    @Test
    void test11() {
        String reg = "(xy)?.z$";
        String str = "xyez";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.group(0));
            System.out.println(m.group(1));
        }
    }

    /**
     * Matcher类的查找索引方法
     */
    @Test
    void test12() {
        String reg = "(a)(b)";
        String str = "start group test (ab)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        /**
         * start end 索引查找
         */
        while (m.find()) {
            System.out.println(m.groupCount()); // 检测捕获组有无匹配到的数量
            System.out.println(m.start()); // 索引从0开始
            System.out.println(m.end());
            if (m.groupCount() != 0) {
                System.out.println(m.group(1));
                System.out.println(m.end(1)); // 指定捕获组的后面索引
                System.out.println(m.end(2));
            }
            System.out.println();
        }
    }

    /**
     * lookingAt find matches
     */
    @Test
    void test13() {
        String reg = "a";
        String str = "abab";
        Pattern p = Pattern.compile(reg); // 一个模板可以用于生成多个Matcher，
        Matcher m = p.matcher(str);

        /**
         * region是什么概念？——整个模板对应的各Matcher中所有序列的集合
         * 序列：一个Matcher对应的一个序列
         * 子序列：捕获组匹配到的序列
         */
//        System.out.println(m.lookingAt()); // 尝试从区域开头匹配；不会移动索引
//        System.out.println(m.lookingAt());
//        System.out.println(m.lookingAt());
//        System.out.println(m.lookingAt());


//        System.out.println(m.find());   // 尝试查找是否有下一个匹配的字符串；并且将识别索引向后移动
//        System.out.println(m.find());
//        System.out.println(m.find());

        // Attempts to match the entire region against the pattern.
        System.out.println(m.matches()); // 整个region与pattern匹配
    }

    /**
     * 替换：replaceFirst和replaceAll
     */
    @Test
    void test14() {
        String reg = "dog";
        String str = "dog cat dog cat!";
        String replace = "cat";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        System.out.println(m.replaceFirst(replace)); // 替换第一个匹配到的
        System.out.println(m.replaceAll(replace));  // 替换所有匹配到的
    }

    @Test
    void test15() {
        String reg = "a";
        String str = "abab";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);

        try {
            System.out.println(m.group());
        } catch (PatternSyntaxException e) {
            System.out.println(e.getDescription());
            System.out.println(e.getIndex());
            System.out.println(e.getPattern());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
