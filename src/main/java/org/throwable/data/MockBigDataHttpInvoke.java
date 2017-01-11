package org.throwable.data;

import com.netflix.hystrix.*;

/**
 * @author zhangjinci
 * @version 2017/1/11 14:41
 * @function
 */
public class MockBigDataHttpInvoke extends HystrixCommand<String> {


    private final static MockBigDataHttpInvokeMethod methods = new MockBigDataHttpInvokeMethod();
    private String method;
    private int sleepMillions;

    public MockBigDataHttpInvoke(String method, int sleepMillions) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("hystrix.bigdata.http"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("hystrix.bigdata.http"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hystrix.bigdata.http"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerEnabled(true)  //开启断路器
                                .withCircuitBreakerRequestVolumeThreshold(20) //断路器阈值,设置一个滑动窗口内触发熔断的最少请求量
                                .withCircuitBreakerSleepWindowInMilliseconds(60 * 1000) //设置触发熔断后,拒绝请求后多长时间开始尝试再次执行
                                .withFallbackEnabled(true)  //是否使用降级处理
                                .withExecutionIsolationThreadInterruptOnTimeout(true) //超时是否中断run方法的执行
                                .withExecutionTimeoutInMilliseconds(600) //run方法执行的超时时间(秒)
                )

        );
        this.method = method;
        this.sleepMillions = sleepMillions;
    }

    @Override
    protected String run() throws Exception {
        return methods.callback(method, sleepMillions);
    }

    @Override
    protected String getFallback() {
        return "getfallback for " + method;
    }
}
