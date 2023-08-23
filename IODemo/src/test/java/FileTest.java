import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.ByteOrder;

public class FileTest {

    String basePath = "D:\\Files\\io";

    @Test
    void fileTest() throws IOException {
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        System.out.println(byteOrder.toString()); // 返回操作系统的端序，windows是小端序

        File file = new File(basePath + File.separator + "test"); // 文件并没有建立【流】
        if (!file.exists()) {
            System.out.println(file.canRead());
            boolean newFile = file.createNewFile();
            System.out.println(file.canRead());
        }
        file.setReadOnly();
        System.out.println(file.canExecute());
    }
}
