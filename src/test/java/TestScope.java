import org.junit.Test;
import org.throwable.extand.http.repository.HttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2017/1/10 17:08
 * @function
 */
public class TestScope {

    @Test
    public void test1() throws Exception {

        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Test1());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "thread1111" + i).start();


            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Test2());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "thread22222" + i).start();
        }


        System.in.read();
    }


    public String Test1()throws Exception{
        Map<String, String> params = new HashMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("key1", "value1");
        String url = "http://localhost:9090/1111";
        params.put("id", "1");
        params.put("name", "zjcscut");
        return HttpClient.getInstance()
                .addParameter("age","11111111")
                .doPost(url, header, params,15)
                .getContent();
    }

    public String Test2()throws Exception{
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        headers.put("key2", "value2");
        String url = "http://localhost:9090/2222";
        params.put("id", "222");
        params.put("name", "zjcscut22");
        return HttpClient.getInstance()
                .addParameter("age","2222222")
                .doPost(url, headers, params,15)
                .getContent();
    }
}
