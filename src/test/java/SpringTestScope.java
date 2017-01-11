import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.Application;
import org.throwable.extand.http.repository.hystrix.CommonHttpCall;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2017/1/11 10:26
 * @function
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTestScope {

    @Test
    public void TestHystrix() throws Exception {
        Map<String, String> params = new HashMap<>();
        String url = "http://localhost:9090/1111";
        params.put("id", "1");
        params.put("name", "zjcscut");
        String callback = new CommonHttpCall(url, params).execute();
        System.out.println(callback);
    }
}
