import com.example.mybatisspring.MyApplication;
import com.example.mybatisspring.domain.TimeZone;
import com.example.mybatisspring.mapper.TimeZoneMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {MyApplication.class})
public class MyTest {

    @Resource
    private TimeZoneMapper mapper;

    @Test
    public void test() {
        List<TimeZone> timeZones = mapper.selectTimeZoneList();
        Assertions.assertEquals(48, timeZones.size());
        System.out.println("helo");
    }
}
