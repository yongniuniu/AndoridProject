package com.example.myapplication;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {
    //
    private static Map<String, List<Cookie>> cookieStore = new HashMap<>();
    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .cookieJar(new CookieJar()
            {
                @Override
                public void saveFromResponse(@NonNull HttpUrl httpUrl, @NonNull List<Cookie> list)
                {
                    cookieStore.put(httpUrl.host(), list);
                }

                @Override
                public List<Cookie> loadForRequest(@NonNull HttpUrl httpUrl)
                {
                    List<Cookie> cookies = cookieStore.get(httpUrl.host());
                    return cookies == null ? new ArrayList<>() : cookies;
                }
            }).build();


    //创建线程池
    static ExecutorService threadPoll = Executors.newFixedThreadPool(30);


    public static String getRequest(final String url) throws ExecutionException, InterruptedException {

        //
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                //
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()&&response.body()!=null){
                    return response.body().string();
                }else{
                    return null;
                }

            }
        });
        threadPoll.execute(futureTask);

        return futureTask.get().toString();
    }
    public static String postRequest(final String url, final Map<String,String> map) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                //
                FormBody.Builder builder = new FormBody.Builder();
//                builder.add("name","sjxy");
                map.forEach(builder::add);
               FormBody formBody =  builder.build();
                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                if(response.isSuccessful()&&response.body()!=null){
                    return response.body().string();
                }else{
                    return null;
                }

            }
        });
        threadPoll.execute(futureTask);

        return futureTask.get().toString();
    }
}
