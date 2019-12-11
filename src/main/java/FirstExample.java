import com.sun.tools.jdeprscan.scan.Scan;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.*;
import io.reactivex.functions.Action;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;

import java.io.File;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class FirstExample {
    public static void main(String[] args) {
        final int THREAD_NUM = 10;

        String[] data = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(data);
        Executor executor = Executors.newFixedThreadPool(THREAD_NUM);

        source.subscribeOn(Schedulers.from(executor)).subscribe(Log::it);
        source.subscribeOn(Schedulers.from(executor)).subscribe(Log::it);
        CommonUtils.sleep(500);
    }
}