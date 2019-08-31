import io.reactivex.Observable;

public class FirstExam {
    public void emit(){
        Observable.just("Hello", "RxJava 2!!")
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        FirstExam demo = new FirstExam();
        demo.emit(); 
    }
}
