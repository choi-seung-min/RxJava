import com.sun.tools.jdeprscan.scan.Scan;
import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.*;
import io.reactivex.functions.Action;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;
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
        String[] orgs = {"1", "3", "5"};
        Observable.fromArray(orgs).doOnNext(data -> Log.it("Original data: " + data))
                .map(data -> "<<" + data + ">>")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::it);
        CommonUtils.sleep(500);

        Observable.fromArray(orgs).doOnNext(data -> Log.it("Original data: " + data))
                .map(data -> "##" + data + "##")
                .subscribeOn(Schedulers.newThread())
                .subscribe(Log::it);
        CommonUtils.sleep(500);
    }
}