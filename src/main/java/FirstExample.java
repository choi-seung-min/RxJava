import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import okhttp3.*;

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
        Observable<String> source = Observable.just(URL + API_KEY)
                .map(OkHttpHelper::getWithLog)
                .subscribeOn(Schedulers.io());

        Observable<String> temp = source.map(this::parseTemp);
        Observable<String> city = source.map(this::parseCity);
        Observable<String> country = source.map(this::parseCountry);

        Observable.concat(temp, city, country)
                .observeOn(Schedulers.newThread())
                .subscribe(Log::it);
        CommonUtils.sleep(3000);
    }
}