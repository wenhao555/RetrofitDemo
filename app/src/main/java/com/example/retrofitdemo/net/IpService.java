package com.example.retrofitdemo.net;

import com.example.retrofitdemo.model.IpModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface IpService
{
    @GET("getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg();


    @GET("getIpInfo.php?")
    Call<IpModel> getIp(@Query("ip") String ip);//拼接ip  后面的是正式数值

    @GET("getIpInfo.php?")
    Call<IpModel> getIpMsgMap(@QueryMap Map<String, String> options);//拼接ip 活其他数值

    @FormUrlEncoded  //注明为表单请求
    @POST("getIpInfo.php?")
    Call<IpModel> getIpMsg(@Field("ip") String first);  //Field后面为一对键值

    @POST("getIpInfo.php?")
    Call<IpModel> getMsg(@Body IpModel ip);//传递表单，将整个类多为一个体传递


    @Multipart//表示可以多个Part
    @POST("user/photo")
    Call<IpModel> updateModel(@Part MultipartBody.Part photo, @Part("description") RequestBody requestBody);//第一个参数是准备上传的文件，另一个参数是用来传递简单的键值对
}
