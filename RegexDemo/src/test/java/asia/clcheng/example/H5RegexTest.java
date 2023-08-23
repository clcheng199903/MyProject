package asia.clcheng.example;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class H5RegexTest {
    /**
     * 读取测点名词
     */
    @Test
    void test1() {
        String reg = "\\s+";
        String str = "  Time for PA28X  ";
        String[] array = str.trim().split(reg);
        System.out.println(array[2]);
    }

    /**
     * 获取试验次数和方向
     */
    @Test
    void test2() {
        String reg = "\"([xyz].+)\"";
        String str = "Record    1 of section \"Y\", run \"y-02g-1_1\"";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
            String s = m.group(1);
            String[] split = s.split("-");
            System.out.println(split[0]);
            System.out.println(split[1]);
            System.out.println(split[2]);
            String d = split[1];
            String r1 = "^0";
            Pattern p1 = Pattern.compile(r1);
            Matcher m1 = p1.matcher(d);
            if (m1.find()) {
                System.out.println(m1.group());
                String s1 = d.replaceFirst("^0", "0.");
                System.out.println(s1);
            }
        }
    }

    /**
     * 获取坐标及测点数量
     */
    @Test
    void test3() {
        String reg = "\\s+";
        String str = "         2    247762         1  1.79271e+01  3.12500e-04  0.00000e+00   ";
        String[] array = str.trim().split(reg);
        System.out.println(Arrays.toString(array));
        System.out.println("测点数：" + array[1]);
        System.out.println("坐标：(" + array[3] + ", " + array[4] + ", " + array[5] + ")");
    }

    /**
     * X轴单位
     */
    @Test
    void test4() {
        String reg = "\\s+";
        String str = "        17    0    0    0 X-axis               s               ";
        String[] array = str.trim().split(reg);
        System.out.println("X轴单位：" + array[5]);
    }

    /**
     * Y轴单位
     */
    @Test
    void test5() {
        String reg = "\\s+";
        String str = "        12    0    0    0 84                   g               ";
        String[] array = str.trim().split(reg);
        System.out.println("Y轴单位：" + array[5]);
    }

    /**
     * 试验产品代号
     */
    @Test
    void test6() {

    }

    /**
     * 试验时间
     */
    @Test
    void test7() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.ENGLISH);
        String str = "09-Apr-15  16:14:00";
        Date parse = dateFormat.parse(str);
        System.out.println(parse);
    }

    String getItem(String content, int index) {
        if (content == null || content.length() == 0 || index < 0) {
            return null;
        }
        String reg = "\\s+";
        String[] array = content.trim().split(reg);
        if (array.length <= index) {
            return null;
        }
        return array[index];
    }
}
