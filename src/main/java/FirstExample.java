import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class FirstExample {
    public static void main(String[] args) {
        CommonUtils.exampleStart();
        Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(data -> (data + 1) * 100)
                .take(5);
        source.subscribe(Log::it);
    }
}
