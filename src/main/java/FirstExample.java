import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class FirstExample {
    public static void main(String[] args) {
        CommonUtils.exampleStart();
        Observable<Long> source = Observable.interval(0L,100L, TimeUnit.MILLISECONDS)
                .map(val -> val + 100)
                .take(5);
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}
