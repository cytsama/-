package com.root.flume.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class TimeStampInterceptor implements Interceptor {
    @Override
    public void initialize() {

    }

    @Override
    public Event intercept(Event event) {
        //拦下日志，取出headers里面的key,取出body里的对应的日志时间，将ts里的值赋给key

        //获取header头
        Map<String, String> headers = event.getHeaders();

        //获取body的ts
        byte[] body = event.getBody();
        String log = new String(body, StandardCharsets.UTF_8);

        JSONObject jsonObject = JSONObject.parseObject(log);
        String ts = jsonObject.getString("ts");

        //将ts的值给timestamp
        headers.put("timestamp",ts);




        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {

        for (Event event : list) {
            intercept(event);
        }
        return list;
    }

    @Override
    public void close() {

    }
    public  static class  Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() {
            return new TimeStampInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
