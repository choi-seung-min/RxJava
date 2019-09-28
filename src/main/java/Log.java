public class Log {
    public static void it(Object obj){
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println("RxJava | " + time + "|" + "value" + obj);
    }
}
