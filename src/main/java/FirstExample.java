import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import okhttp3.*;

public class FirstExample {

    private final OkHttpClient client = new OkHttpClient();

    private static final String FIRST_URL = "https://api.github.com/zen";
    private static final String SECOND_URL = CommonUtils.GITHUB_ROOT + "/samples/callback_heaven";

    public void usingConcat() {
        CommonUtils.exampleStart();
        Observable<String> source = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get)
                .concatWith(Observable.just(SECOND_URL)
                        .map(OkHttpHelper::get));
        source.subscribe(Log::it);
        CommonUtils.sleep(5000);
        CommonUtils.exampleComplete();
    }

    public void usingZip() {
        CommonUtils.exampleStart();
        Observable<String> first = Observable.just(FIRST_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);
        Observable<String> second = Observable.just(SECOND_URL)
                .subscribeOn(Schedulers.io())
                .map(OkHttpHelper::get);

        Observable.zip(first, second,
                (a, b) -> ("\n>>" + a + "\n>>" + b))
                .subscribe(Log::it);
        CommonUtils.sleep(5000);
    }

    public static void main(String[] args) {
        FirstExample example = new FirstExample();
        example.usingConcat();
//        example.usingZip();
    }
}