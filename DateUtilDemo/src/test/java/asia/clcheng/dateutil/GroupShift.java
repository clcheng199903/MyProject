package asia.clcheng.dateutil;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GroupShift {
    /**
     * 班组：甲乙丙丁
     * 班别：夜白中休
     * 八天一个周期
     * 8个小时一个单位
     */
    @Test
    void test() {

        String baseDate = "2023-06-27 00:00:00";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long baseTs = 1687795200000l;
        long ts = 0;
        try {
            Date parse = dateFormat.parse(baseDate);
            ts = parse.getTime();
            System.out.println(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

//        long ts = System.currentTimeMillis();

        int shift = (int) ((ts - baseTs) / (8 * 3600 * 1000));

        int date = shift % 24;
        if (date < 0) {
            date += 24;
        }
        System.out.println(date);
//        date %= 24;  // 8天一个周期24个班，一天3个班
        if (date == 0) {
            print(3, 1);
        } else if (date == 1) {
            print(4, 2);
        } else if (date == 2) {
            print(1, 3);
        } else if (date == 3) {
            print(3, 1);
        } else if (date == 4) {
            print(4, 2);
        } else if (date == 5) {
            print(1, 3);
        } else if (date == 6) {
            print(2, 1);
        } else if (date == 7) {
            print(3, 2);
        } else if (date == 8) {
            print(4, 3);
        } else if (date == 9) {
            print(2, 1);
        } else if (date == 10) {
            print(3, 2);
        } else if (date == 11) {
            print(4, 3);
        } else if (date == 12) {
            print(1, 1);
        } else if (date == 13) {
            print(2, 2);
        } else if (date == 14) {
            print(3, 3);
        } else if (date == 15) {
            print(1, 1);
        } else if (date == 16) {
            print(2, 2);
        } else if (date == 17) {
            print(3, 3);
        } else if (date == 18) {
            print(4, 1);
        } else if (date == 19) {
            print(1, 2);
        } else if(date == 20) {
            print(2, 3);
        } else if (date == 21) {
            print(4, 1);
        } else if (date == 22) {
            print(1, 2);
        } else if(date == 23) {
            print(2, 3);
        }
    }

    private void print(int group, int shift) {
        System.out.println("group: " + group + ", shift: " + shift);
    }
}
