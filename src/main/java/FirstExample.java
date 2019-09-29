import io.reactivex.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FirstExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 10)
                .filter(num -> num % 2 == 0);
        source.subscribe(Log::it);
    }
}
