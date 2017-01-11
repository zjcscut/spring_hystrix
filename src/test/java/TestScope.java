import org.junit.Test;
import org.throwable.data.MockBigDataHttpInvoke;
import org.throwable.data.MockBigDataInterfaceCallback;
import org.throwable.extand.http.repository.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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


    public String Test1() throws Exception {
        Map<String, String> params = new HashMap<>();
        Map<String, String> header = new HashMap<>();
        header.put("key1", "value1");
        String url = "http://localhost:9090/1111";
        params.put("id", "1");
        params.put("name", "zjcscut");
        return HttpClient.getInstance()
                .addParameter("age", "11111111")
                .doPost(url, header, params, 15)
                .getContent();
    }

    public String Test2() throws Exception {
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        headers.put("key2", "value2");
        String url = "http://localhost:9090/2222";
        params.put("id", "222");
        params.put("name", "zjcscut22");
        return HttpClient.getInstance()
                .addParameter("age", "2222222")
                .doPost(url, headers, params, 15)
                .getContent();
    }

    @Test
    public void TestInvokeData() throws Exception {
        MockBigDataInterfaceCallback callback = new MockBigDataInterfaceCallback();
        String idcard = "222222";
        ExecutorService pool = Executors.newFixedThreadPool(6);
        try {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchWecashCreditData(idcard));
                        System.out.println(callback.dofetchWecashEduData(idcard));
                        System.out.println(callback.dofetchWecashPhotoData(idcard));
                        System.out.println(callback.dofetchJpushMsgData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchWecashYYSData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchTXLData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchMGData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchTDData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        System.out.println("END ----------------------------------");
        System.in.read();
    }


    @Test
    public void TestInvokeDataSubmit() throws Exception {
        MockBigDataInterfaceCallback callback = new MockBigDataInterfaceCallback();
        String idcard = "222222";
        ExecutorService pool = Executors.newFixedThreadPool(6);
        long start = System.currentTimeMillis();
        try {
            Future future1 = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchWecashCreditData(idcard));
                        System.out.println(callback.dofetchWecashEduData(idcard));
                        System.out.println(callback.dofetchWecashPhotoData(idcard));
                        System.out.println(callback.dofetchJpushMsgData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Future future2 = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchWecashYYSData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Future future3 = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchTXLData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Future future4 = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchMGData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            Future future5 = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchTDData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });


            future1.get();
            future2.get();
            future3.get();
            future4.get();
            future5.get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

        System.out.println("END ----------------------------------,costTime:" + (System.currentTimeMillis() - start));

        System.in.read();
    }


    @Test
    public void TestInvokeDataLauthDown() throws Exception {
        MockBigDataInterfaceCallback callback = new MockBigDataInterfaceCallback();
        String idcard = "222222";
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //CountDownLatch count参数的数目一定要和下面的countDown的调用总次数一致,否则会提前释放
        final CountDownLatch downLatch = new CountDownLatch(5);
        long start = System.currentTimeMillis();
        try {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchWecashCreditData(idcard));
                        System.out.println(callback.dofetchWecashEduData(idcard));
                        System.out.println(callback.dofetchWecashPhotoData(idcard));
                        System.out.println(callback.dofetchJpushMsgData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchWecashYYSData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchTXLData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchMGData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(callback.dofetchTDData(idcard));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            downLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        System.out.println("END ----------------------------------,costTime:" + (System.currentTimeMillis() - start));


        System.in.read();
    }


    @Test
    public void TestInvokeDataLauthDownWithHystrix() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //CountDownLatch count参数的数目一定要和下面的countDown的调用总次数一致,否则会提前释放
        final CountDownLatch downLatch = new CountDownLatch(5);
        long start = System.currentTimeMillis();
        try {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new MockBigDataHttpInvoke("dofetchWecashYYSData", 500).execute());
                        System.out.println(new MockBigDataHttpInvoke("dofetchTXLData", 500).execute());
                        System.out.println(new MockBigDataHttpInvoke("dofetchWecashCreditData", 500).execute());
                        System.out.println(new MockBigDataHttpInvoke("dofetchTDData", 500).execute());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new MockBigDataHttpInvoke("dofetchMGData", 500).execute());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new MockBigDataHttpInvoke("dofetchWecashEduData", 500).execute());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new MockBigDataHttpInvoke("dofetchWecashPhotoData", 600).execute());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(new MockBigDataHttpInvoke("dofetchJpushMsgData", 600).execute());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        downLatch.countDown();
                    }
                }
            });

            downLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        System.out.println("END ----------------------------------,costTime:" + (System.currentTimeMillis() - start));


        System.in.read();
    }


    @Test
    public void TestHystrix() throws Exception {
        String result = new MockBigDataHttpInvoke("dofetchTDData", 500).execute();
        System.out.println(result);
    }
}
