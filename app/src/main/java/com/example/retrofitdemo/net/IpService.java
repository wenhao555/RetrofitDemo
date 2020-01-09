package com.example.retrofitdemo.net;

import com.example.retrofitdemo.model.IpModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IpService
{
    @GET("getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg();
}
