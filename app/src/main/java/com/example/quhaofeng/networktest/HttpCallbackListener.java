package com.example.quhaofeng.networktest;

/**
 * Created by Quhaofeng on 2016-3-26-0026.
 * 用于服务器响应回调
 */
public interface HttpCallbackListener {

   /**
    * 当服务器成功响应请求时调用
    * 参数（response）：服务器返回的数据
    * */
    void onFinish(String response);

    /**
     * 当服务器出错时调用
     * 参数（e）：记录着错误的详细信息
     * */
    void onError(Exception e);
}
