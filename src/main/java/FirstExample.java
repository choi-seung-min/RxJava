import io.reactivex.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FirstExample {
    public static void main(String[] args) {
        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .repeat(3);

        source.doOnComplete(() -> System.out.println("onComplete\n\n"))
                .subscribe(Log::it);
    }
}