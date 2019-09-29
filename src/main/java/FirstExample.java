import io.reactivex.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FirstExample {
    public static void main(String[] args) {
        //source and source2 is same
        Observable<Long> source = Observable.intervalRange(1, 5, 100L, 100L, TimeUnit.MILLISECONDS);
        Observable<Long> source2 = Observable.interval(100L, 100L, TimeUnit.MILLISECONDS)
                .map(val -> val + 1)
                .take(5);
        source.subscribe(Log::it);
        source2.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
