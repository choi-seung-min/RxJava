import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class FirstExam {
    public static void main(String[] args) {
        String[] balls = {"RED", "YELLOW", "GREEN", "BLUE"};
        Observable<Integer> source = Observable.fromArray(balls).map(data -> {
            switch (data){
                case "RED": return 1;
                case "YELLOW": return 2;
                case "GREEN": return 3;
                case "BLUE": return 5;
                default: return -1;
            }
        });
        source.subscribe(System.out::println);
    }
}
