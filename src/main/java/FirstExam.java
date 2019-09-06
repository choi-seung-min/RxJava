import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class FirstExam {
    public static void main(String[] args) {
        Float[] temp = {10.4f, 13.4f, 12.5f};
        Observable<Float> source = Observable.fromArray(temp);


        AsyncSubject<Float> subject = AsyncSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));

        source.subscribe(subject);
    }
}
