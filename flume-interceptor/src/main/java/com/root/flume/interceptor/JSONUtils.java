package com.root.flume.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

public class JSONUtils {
    public static void main(String[] args) {
//        System.out.println(isValidate("{dabdka"));
//        System.out.println(isValidate("123"));
//        System.out.println(isValidate("{\"nmjm\":10}"));
    }
    //验证数据是否是json
    public static boolean isValidate(String log) {
        try {
            JSON.parse(log);
            return true;
        } catch (JSONException e) {

            return false;
        }
    }
}
