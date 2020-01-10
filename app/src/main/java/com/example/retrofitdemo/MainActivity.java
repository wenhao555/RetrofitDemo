package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.example.retrofitdemo.model.IpModel;
import com.example.retrofitdemo.net.IpSercieceForPath;
import com.example.retrofitdemo.net.IpService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        strToJson();
        getIp();
    }

    private void getIp()
    {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())//增加返回值Json支持
                .build();
        IpService ipService = retrofit.create(IpService.class);
        File file = new File(Environment.getExternalStorageDirectory(), "wa.png");
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part photo = MultipartBody.Part.createFormData("photos", "wanshu.png", requestBody);
        Call<IpModel> call = ipService.updateModel(photo, RequestBody.create(null, "wa"));
        call.enqueue(new Callback<IpModel>()
        {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response)
            {
                String country = response.body().getData().getCountry();
                Log.e("得到的请求返回", country);
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t)
            {
                Log.e("得到的请求返回", t.getMessage());
            }
        });
    }

    /**
     * 动态URL
     */
    private void getIp2()
    {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())//增加返回值Json支持
                .build();
        IpSercieceForPath ipService = retrofit.create(IpSercieceForPath.class);
        Call<IpModel> call = ipService.getIpMsg("http://ip.taobao.com/service");//动态链接

        call.enqueue(new Callback<IpModel>()
        {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response)
            {
                String country = response.body().getData().getCountry();
                Log.e("得到的请求返回", country);
            }

            @Override
            public void onFailure(Call<IpModel> call, Throwable t)
            {
                Log.e("得到的请求返回", t.getMessage());
            }
        });
    }

    private void strToJson()
    {
        JsonArray array = new JsonArray();
        JsonObject object = new JsonObject();
        JsonObject obj = new JsonObject();
        object.addProperty("name", "ta");
        object.addProperty("name2", "ta2");
        array.add(object);
        obj.addProperty("a1", new Gson().toJson(array));
        Log.e("la", obj.toString());
        //查看数组转字符串
    }

}
