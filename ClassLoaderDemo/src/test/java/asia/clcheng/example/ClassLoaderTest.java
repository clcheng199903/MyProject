package asia.clcheng.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.BitSet;

public class ClassLoaderTest {
    @Test
    void elementTypeTest() {
        // array classes不能被ClassLoader创建，但需要时会被java runtime自动创建
        // 每个Class类型都包含定义这个Class的ClassLoader的引用
        // 要明确类类型Class的含义
        ClassLoader loader = String.class.getClassLoader(); // loader为空，因为BootstrapClassLoader是C实现的，是个Klass引用，不被jvm管理
        Assertions.assertNotNull(loader, "loader为空，则为BootstrapLoader加载器！");
    }

    @Test
    void arrayTypeTest() {
        ClassLoader loader = String[].class.getClassLoader();
        Assertions.assertNotNull(loader, "loader为空，但array class没有加载器，所以为也为空！");
    }

    @Test
    void classloaderTypeTest() {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader(); // app
        System.out.println(loader.getName());
    }
}
