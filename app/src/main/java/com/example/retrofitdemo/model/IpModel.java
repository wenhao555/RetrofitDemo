package com.example.retrofitdemo.model;

public class IpModel
{
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public IpData getData()
    {
        return data;
    }

    public void setData(IpData data)
    {
        this.data = data;
    }

    private int code;
    private IpData data;
}
