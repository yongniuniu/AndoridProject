package com.example.myapplication;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * OkHttp工具类
 *
 * */
public class OkHttpUtil {
   static ExecutorService threadPoll= Executors.newFixedThreadPool(30);

    /* 发送get请求*/
    public static String getReuest(String url) throws ExecutionException, InterruptedException {
        FutureTask futureTask=new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                //实现http内容
                return null;
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
