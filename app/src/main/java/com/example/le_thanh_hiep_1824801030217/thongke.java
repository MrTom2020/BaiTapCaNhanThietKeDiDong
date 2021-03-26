package com.example.le_thanh_hiep_1824801030217;

import java.io.Serializable;

public class thongke implements Serializable
{
    public  String k;
    public String sl;

    public thongke(String k, String sl)
    {
        this.k = k;
        this.sl = sl;
    }

    public String getK()
    {
        return k;
    }

    public void setK(String k)
    {
        this.k = k;
    }

    public String getSl()
    {
        return sl;
    }

    public void setSl(String sl)
    {
        this.sl = sl;
    }
}
