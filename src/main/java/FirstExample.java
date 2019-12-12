import com.sun.tools.jdeprscan.scan.Scan;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.*;
import io.reactivex.functions.Action;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
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

    private final OkHttpClient client = new OkHttpClient();

    private static final String FIRST_URL = "https://api.github.com/zen";
    private static final String SECOND_URL = CommonUtils.GITHUB_ROOT + "/samples/callback_heaven";

    public void usingConcat() {
        CommonUtils.exampleStart();
        Observable<String> source = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get)
                .concatWith(Observable.just(SECOND_URL)
                        .map(OkHttpHelper::get));
        source.subscribe(Log::it);
        CommonUtils.sleep(5000);
        CommonUtils.exampleComplete();
    }

    public void usingZip() {
        CommonUtils.exampleStart();
        Observable<String> first = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);
        Observable<String> second = Observable.just(SECOND_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);

        Observable.zip(first, second,
                (a, b) -> ("\n>>" + a + "\n>>" + b))
                .subscribe(Log::it);
        CommonUtils.sleep(5000);
    }

    public static void main(String[] args) {
        FirstExample example = new FirstExample();
//        example.usingConcat();
        example.usingZip();
    }
}