package com.example.myapplication;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttp工具类
 *
 * */
public class OkHttpUtil {
   static OkHttpClient okHttpClient=new OkHttpClient();

    /*创建线程池*/
   static ExecutorService threadPoll= Executors.newFixedThreadPool(30);
    /* 发送get请求*/
    public static String getReuest(final String url) throws ExecutionException, InterruptedException {
        FutureTask futureTask=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                //实现http内容
                Request request=new Request.Builder()
                        .url(url)
                        .build();
                /*打开网址*/
                //得到服务器响应
                Response response=okHttpClient.newCall(request).execute();
                //预处理
                if(response.isSuccessful() && response.body()!=null){
                    return  response.body().string();
                }else{
                    return  null;
                }

            }
        });
        threadPoll.execute(futureTask);

        return futureTask.get().toString() ;

    }

   /* 发送Post请求*/
    public static String postReuest(String url, Map<String,String > map){

        return  null;
    }


}
