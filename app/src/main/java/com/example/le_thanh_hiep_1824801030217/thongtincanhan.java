package com.example.le_thanh_hiep_1824801030217;

public class thongtincanhan
{
    public String Id;
    public String Ten;
    public String SDT;
    public String DiaChi;
    public String QueQuan;

    public thongtincanhan(String id, String ten, String SDT, String diaChi, String queQuan)
    {
        Id = id;
        Ten = ten;
        this.SDT = SDT;
        DiaChi = diaChi;
        QueQuan = queQuan;
    }

    public String getId()
    {
        return Id;
    }

    public void setId(String id)
    {
        Id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi()
    {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getQueQuan() {
        return QueQuan;
    }

    public void setQueQuan(String queQuan) {
        QueQuan = queQuan;
    }
}
