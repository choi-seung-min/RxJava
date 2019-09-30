import io.reactivex.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class FirstExample {
    public static void main(String[] args) {
        CommonUtils.exampleStart();

        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.interval(100L, TimeUnit.MILLISECONDS)
                .map(Long::intValue)
                .map(idx -> balls[idx])
                .take(balls.length)
                .doOnNext(Log::it)
                .switchMap(ball -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                .map(notUsed -> ball + "<>")
                .take(2)
                );
        source.subscribe(Log::it);
        CommonUtils.sleep(2000);
    }
}