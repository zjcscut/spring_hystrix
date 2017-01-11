package org.throwable.backoff.impl;

import org.throwable.backoff.Sleeper;

/**
 * @author zhangjinci
 * @version 2017/1/11 12:28
 * @function
 */
public class BackOffSleeper implements Sleeper {


    @Override
    public void sleep(long backOffPeriod) throws InterruptedException {
        Thread.sleep(backOffPeriod);
    }
}
