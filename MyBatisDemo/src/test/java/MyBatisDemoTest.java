import com.example.mybatisdemo.domain.TimeZone;
import com.example.mybatisdemo.mapper.TimeZoneMapper;
import com.example.mybatisdemo.utils.MyBatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class MyBatisDemoTest {
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TimeZoneMapper mapper = sqlSession.getMapper(TimeZoneMapper.class);
        List<TimeZone> timeZoneList = mapper.selectTimeZoneList();
        log.info(String.valueOf(timeZoneList.size()));
        sqlSession.close();
        Assertions.assertEquals(timeZoneList.size(), 48);

//        因为设置了池化线程池，所以JDBC Connection会复用，不需要用户自己考虑
        SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
        TimeZoneMapper mapper1 = sqlSession1.getMapper(TimeZoneMapper.class);
        List<TimeZone> timeZoneList1 = mapper1.selectTimeZoneList();
        log.info(String.valueOf(timeZoneList1.size()));
        sqlSession1.close();
        Assertions.assertEquals(timeZoneList1.size(), 48);
    }
}
