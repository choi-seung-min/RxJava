import com.sun.tools.jdeprscan.scan.Scan;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.*;
import io.reactivex.functions.Action;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Timed;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class FirstExample {
    public static void main(String[] args) {
        String[] data = {"1", "3", "7"};

        CommonUtils.exampleStart();
        Observable<Timed<String>> source = Observable.fromArray(data)
                .delay(item -> {
                    CommonUtils.doSomething();
                    return Observable.just(item);
                })
                .timeInterval();

        source.subscribe(System.out::println);
        CommonUtils.sleep(1000);
    }
}