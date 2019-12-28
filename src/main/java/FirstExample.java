import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import okhttp3.*;
import org.graalvm.compiler.nodes.PrefetchAllocateNode;

import java.util.prefs.PreferenceChangeEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstExample {

    private static final String URL =
            "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=";
    private static final String API_KEY =
            "7ca2f60e46f39207e2f1514370cc9832";

    public static void main(String[] args) {
        FirstExample example = new FirstExample();
        example.run();
    }

    private String parse(String json, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);
        if (matcher.find()){
            return matcher.group();
        }
        return "N/A";
    }

    private String parseTemp(String json){
        return parse(json, "\"temp\":[0-9]*.[0-9]*");
    }

    private String parseCity(String json){
        return parse(json, "\"name\":\"[a-zA-Z]*\"");
    }

    private String parseCountry(String json){
        return parse(json, "\"country\":\"[a-zA-Z]*\"");
    }

    public void run(){
        CommonUtils.exampleStart();

        Observable<String> source = Observable.just(URL + API_KEY)
                .map(OkHttpHelper::getWithLog)
                .subscribeOn(Schedulers.io())
                .share()
                .observeOn(Schedulers.newThread());

        source.map(this::parseTemp).subscribe(Log::it);
        source.map(this::parseCity).subscribe(Log::it);
        source.map(this::parseCountry).subscribe(Log::it);

        CommonUtils.sleep(3000);
    }
}