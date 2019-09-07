import io.reactivex.Observable;

import java.util.Scanner;

public class FirstExam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("input");
        int dan = Integer.parseInt(in.nextLine());

//        Observable<String> source = Observable.just(dan)
//                .flatMap(num -> Observable.range(1, 9)
//                .map(row -> num + "*" + row + "=" + num*row));
        Observable<String> source = Observable.just(dan)
                .flatMap(gugu -> Observable.range(1, 9),
                        (gugu, i) -> gugu + "*" + i + "=" + gugu*i);
        source.subscribe(System.out::println);
    }
}
