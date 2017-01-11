package org.throwable.data;

import org.throwable.backoff.Sleeper;
import org.throwable.backoff.impl.BackOffSleeper;

/**
 * @author zhangjinci
 * @version 2017/1/11 14:47
 * @function
 */
public class MockBigDataHttpInvokeMethod {
    private final static Sleeper sleeper = new BackOffSleeper();

    private final static MockBigDataInterfaceCallback callback = new MockBigDataInterfaceCallback();

    public String callback(String method,int timeOut) throws Exception {
        String result;
        sleeper.sleep(timeOut);
        switch (method) {
            case "dofetchWecashYYSData":
                result = callback.dofetchWecashYYSData(method);
                break;
            case "dofetchTXLData":
                result = callback.dofetchTXLData(method);
                break;
            case "dofetchWecashCreditData":
                result = callback.dofetchWecashCreditData(method);
                break;
            case "dofetchTDData":
                result = callback.dofetchTDData(method);
                break;
            case "dofetchMGData":
                result = callback.dofetchMGData(method);
                break;
            case "dofetchWecashEduData":
                result = callback.dofetchWecashEduData(method);
                break;
            case "dofetchWecashPhotoData":
                result = callback.dofetchWecashPhotoData(method);
                break;
            case "dofetchJpushMsgData":
                result = callback.dofetchJpushMsgData(method);
                break;
            default: {
                result = "no method found";
            }
        }
        return result;
    }
}
