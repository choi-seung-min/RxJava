import com.sun.tools.jdeprscan.scan.Scan;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Action;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class FirstExample {
    public static void main(String[] args) {
        String[] data1 = {"1", "3", "5"};
        String[] data2 = {"2-R", "4-R"};

        List<Observable<String>> sources = Arrays.asList(
                Observable.fromArray(data1)
                .doOnComplete(() -> System.out.println("Observable #1 : onComplete()")),
                Observable.fromArray(data2)
                .delay(100L, TimeUnit.MILLISECONDS)
                .doOnComplete(() -> System.out.println("Observable #2 : onComplete()"))
        );

        Observable.amb(sources)
                .doOnComplete(() -> System.out.println("Result : onComplete()"))
                .subscribe(System.out::println);
        CommonUtils.sleep(1000);
    }
}