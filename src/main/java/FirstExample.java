import com.sun.tools.jdeprscan.scan.Scan;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.*;
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
        Integer[] data = {1, 2, 3,4 };

        //count
        Single<Long> source = Observable.fromArray(data)
                .count();
        source.subscribe(count -> System.out.println("Count: " + count));

        //min & max
        Flowable.fromArray(data)
                .to(MathFlowable::max)
                .subscribe(max -> System.out.println("Max: " + max));

        Flowable.fromArray(data)
                .to(MathFlowable::min)
                .subscribe(min -> System.out.println("Min: " + min));

        //sun & average
        Flowable<Integer> flowable = Flowable.fromArray(data)
                .to(MathFlowable::sumInt);
        flowable.subscribe(sum -> System.out.println("Sum: " + sum));

        Flowable<Double> flowable1 = Observable.fromArray(data)
                .toFlowable(BackpressureStrategy.BUFFER)
                .to(MathFlowable::averageDouble);
        flowable1.subscribe(avg -> System.out.println("Avg: " + avg));
    }
}