package org.throwable.data;

import org.throwable.backoff.Sleeper;
import org.throwable.backoff.impl.BackOffSleeper;

/**
 * @author zhangjinci
 * @version 2017/1/11 12:26
 * @function
 */
public class MockBigDataInterfaceCallback {

    private static final long SLEEP_MILLIONS = 500L;

    private static final Sleeper sleeper = new BackOffSleeper();

    public String dofetchWecashCreditData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchWecashCreditData";
    }

    public String dofetchYXZCData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchYXZCData";
    }


    public String dofetchWecashPhotoData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchWecashPhotoData";
    }

    public String dofetchWecashEduData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchWecashEduData";
    }

    public String dofetchJpushMsgData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchJpushMsgData";
    }

    public String dofetchWecashYYSData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchWecashYYSData";
    }


    public String dofetchTXLData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchTXLData";
    }


    public String dofetchMGData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchMGData";
    }


    public String dofetchTDData(String idcard) throws Exception {
        sleeper.sleep(SLEEP_MILLIONS);
        return "dofetchTDData";
    }


}
