package ranger.one;

import java.util.concurrent.TimeUnit;

/**
 * 重量级类实现
 */
public class DBQuery implements IDBQuery {
    public DBQuery() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String request() {
        return "request string";
    }
}
