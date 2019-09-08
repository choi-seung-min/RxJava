import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.operators.observable.ObservableError;

import java.util.Scanner;

public class FirstExam {
    public static void main(String[] args) {
        String[] obj = {"1 CIRCLE", "2 DIAMOND", "3 TRIANGLE", "4 DIAMOND", "5 CIRCLE", "6 HEXAGON"};
        Observable<String> source = Observable.fromArray(obj).filter(data -> data.endsWith("CIRCLE"));
        source.subscribe(System.out::println);

        Integer[] obj2 = {100, 34, 27, 99, 50};
        Observable<Integer> source2 = Observable.fromArray(obj2).filter(data -> data%2 == 0);
        source2.subscribe(System.out::println);

        Single<Integer> single;
        Observable<Integer> observable;

        //first
        single = Observable.fromArray(obj2).first(-1);
        single.subscribe(data -> System.out.println("first() value " + data));

        //last
        single = Observable.fromArray(obj2).last(999);
        single.subscribe(data -> System.out.println("last() value " + data));

        //take
        observable = Observable.fromArray(obj2).take(3);
        observable.subscribe(data -> System.out.println("take(3) values " + data));

        //takeLast
        observable = Observable.fromArray(obj2).takeLast(3);
        observable.subscribe(data -> System.out.println("takeLast(3) values " + data));

        //skip
        observable = Observable.fromArray(obj2).skip(2);
        observable.subscribe(data -> System.out.println("skip(2) values " + data));

        //skipLast
        observable = Observable.fromArray(obj2).skipLast(2);
        observable.subscribe(data -> System.out.println("skipLast(2) values " + data));
    }
}
