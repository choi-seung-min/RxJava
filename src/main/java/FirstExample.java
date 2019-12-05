import com.sun.tools.jdeprscan.scan.Scan;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Action;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class FirstExample {
    public static void main(String[] args) {
        String[] data = {"1", "2", "3", "4", "5", "6"};

        Observable<String> source = Observable.fromArray(data)
                .zipWith(Observable.interval(100L, TimeUnit.MILLISECONDS), (val, time) -> val)
                .skipUntil(Observable.timer(500L, TimeUnit.MILLISECONDS));

        source.subscribe(System.out::println);
        CommonUtils.sleep(1000);
    }
}