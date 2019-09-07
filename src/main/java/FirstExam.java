import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class FirstExam {
    public static void main(String[] args) {
        // PublishSubject example
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.subscribe(data -> System.out.println("PublishSubject Subscriber #1 => " + data));
        publishSubject.onNext("1");
        publishSubject.onNext("3");
        publishSubject.subscribe(data -> System.out.println("PublishSubject Subscriber #2 => " + data));
        publishSubject.onNext("5");
        publishSubject.onComplete();

        // ReplaySubject example
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        replaySubject.subscribe(data -> System.out.println("ReplaySubject Subscriber #1 => " + data));
        replaySubject.onNext("1");
        replaySubject.onNext("3");
        replaySubject.subscribe(data -> System.out.println("ReplaySubject Subscriber #2 => " + data));
        replaySubject.onNext("5");
        replaySubject.onComplete();
    }
}
