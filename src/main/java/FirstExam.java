import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class FirstExam {
    public static void main(String[] args) {
        String[] balls = {"1", "3", "5"};
        Observable<String> source = Observable.fromArray(balls)
                .flatMap(data -> Observable.just(data + "<>", data + "<>"));
        source.subscribe(System.out::println);
    }
}
