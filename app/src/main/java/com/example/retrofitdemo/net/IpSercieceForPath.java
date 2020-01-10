package com.example.retrofitdemo.net;

import com.example.retrofitdemo.model.IpModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IpSercieceForPath
{
    @GET("{path}/getIpInfo.php?ip=59.108.54.37")
    Call<IpModel> getIpMsg(@Path("path") String path);//动态链接url
}
