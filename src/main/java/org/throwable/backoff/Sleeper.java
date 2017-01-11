package org.throwable.backoff;

import java.io.Serializable;

/**
 * @author zhangjinci
 * @version 2017/1/11 12:27
 * @function
 */
public interface Sleeper extends Serializable {


    void sleep(long backOffPeriod) throws InterruptedException;

}
