package asia.clcheng.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试
 */
public class AssertionsTest {
    /**
     * AssertionError是Throwable的派生类
     */
    @Test
    void test() {
        Assertions.assertTrue(false, () -> {
            return "hello world!";
        });
    }
}
