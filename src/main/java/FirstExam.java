import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.operators.observable.ObservableError;

import java.util.Scanner;

public class FirstExam {
    public static void main(String[] args) {
        BiFunction<String, String , String> mergeBalls = (ball1, ball2) -> ball2 + "(" + ball1 + ")";
        String[] balls = {"1", "2", "3"};
        Maybe<String> source = Observable.fromArray(balls).reduce(mergeBalls);
        source.subscribe(System.out::println);
    }
}
