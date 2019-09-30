import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class FirstExample {
    public static void main(String[] args) {
        String[] objs = {"6", "4", "2-T", "2", "6-T", "4-T"};
        Observable<GroupedObservable<String, String >> source =
                Observable.fromArray(objs).groupBy(CommonUtils::getShape);

        source.subscribe(obj -> {
            obj.subscribe(
                    val -> System.out.println("GROUP: " + obj.getKey() + "\t Value: " + val)
            );
        });
    }
}