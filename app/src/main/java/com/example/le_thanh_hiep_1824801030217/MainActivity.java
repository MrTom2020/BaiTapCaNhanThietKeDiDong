package com.example.le_thanh_hiep_1824801030217;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private Button btnthem,btnthoat,btnloc;
    private thongtinAdapter adapter;
    private ListView ls;
    public static final int k = 123;
    private  String qq;
    private ProgressDialog progressDialog;
    private ArrayList<thongtincanhan> arrayList;
    private  String ten,dc,sdt;
    private String loctheo;
    private int vt = -1;
    private ArrayList<thongke> thongkes;
    public static final int k1 = 456;
    public static final int k2 = 789;
    public ArrayList<String> arrayList2;
    private Spinner spinner;
    private EditText edtt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dangkynut();
        ax();
        locdl();
        registerForContextMenu(ls);
        dangkysukien();
    }
    private void dangkynut()
    {
        ls = (ListView)findViewById(R.id.ls);
        btnloc = (Button)findViewById(R.id.btnloc);
        btnthem = (Button)findViewById(R.id.btnthem);
        btnthoat = (Button)findViewById(R.id.btnthoat);
        edtt = (EditText)findViewById(R.id.edtcantim);
        ls.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                vt = position;
                return false;
            }
        });
        spinner = (Spinner)findViewById(R.id.spinner2);
    }
    private void dangkysukien()
    {
        btnthoat.setOnClickListener(new sukiencuatoi());
        btnthem.setOnClickListener(new sukiencuatoi());
        btnloc.setOnClickListener(new sukiencuatoi());
    }
    private void locdl()
    {
        arrayList2 = new ArrayList<>();
        arrayList2.add("Sài gòn");
        arrayList2.add("Nha Trang");
        arrayList2.add("Hà Nội");
        arrayList2.add("Bình Dương");
        arrayList2.add("Hải Phòng");
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item,arrayList2);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                loctheo = arrayList2.get(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    private void demchuoi()
    {

        Toast.makeText(MainActivity.this,loctheo,Toast.LENGTH_SHORT).show();
        int kt = arrayList.size();
        int dem = 0;
        thongkes = new ArrayList<>();
        String kk = "",kkk="";
       // Toast.makeText(MainActivity.this,String.valueOf(kt),Toast.LENGTH_SHORT).show();
        try
        {
            for(int i = 0; i < arrayList.size();i++)
            {

                if(loctheo.equals(arrayList.get(i).getQueQuan().toString()))
                {
                    thongkes.add(new thongke(arrayList.get(i).getTen().toString(),arrayList.get(i).getQueQuan().toString()));
                }
            }
            Intent intent = new Intent(MainActivity.this,dstk.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("dstk",thongkes);
            intent.putExtra("kkk",bundle);
            startActivity(intent);
        }
        catch (Exception e)
        {
            Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
        }

    }
    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(btnthoat))
            {
                laycauhoi();
            }
            if(view.equals(btnthem))
            {
                Intent intent = new Intent(MainActivity.this,themthongtin.class);
                startActivityForResult(intent,k);
            }
            if(view.equals(btnloc))
            {
                demchuoi();
            }
        }
    }

    private void ax()
    {
        arrayList = new ArrayList<>();
        arrayList.add(new thongtincanhan("Stt","Tên","Sdt","Địa chỉ","Quê quán"));
        adapter = new thongtinAdapter(MainActivity.this,R.layout.danhsachthongtin,arrayList);
        ls.setAdapter(adapter);
    }


    private void laycauhoi()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn thoát");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.xoa:
                if(arrayList.size() >= 2)
                {
                    hoixoa();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Bạn phải nhập thêm thông tin ",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.capnhat:
                if(arrayList.size() >= 2)
                {
                    String ten = arrayList.get(vt).getTen().toString();
                    String dc = arrayList.get(vt).getDiaChi().toString();
                    String sdt = arrayList.get(vt).getSDT().toString();
                    String quequan = arrayList.get(vt).getQueQuan().toString();
                    Intent intent = new Intent(MainActivity.this, capnhat.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("tencs",ten);
                    bundle.putString("diachics",dc);
                    bundle.putString("sdtcs",sdt);
                    bundle.putString("qqcs",quequan);
                    intent.putExtra("cs",bundle);
                    startActivityForResult(intent,k1);
                }
                else
                    {
                    Toast.makeText(MainActivity.this,"Bạn phải nhập thêm thông tin ",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.setHeaderTitle("Thông báo");
        getMenuInflater().inflate(R.menu.menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    private void hoixoa()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn xóa ? ");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                arrayList.remove(vt);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode == k && resultCode == RESULT_OK && data != null)
        {
            Bundle bundle = data.getBundleExtra("ok");
            String ten = bundle.getString("ten").toString();
            String dc = bundle.getString("diachi").toString();
            String qq = bundle.getString("quequan").toString();
            String sdt = bundle.getString("sdt").toString();
            String id = String.valueOf(arrayList.size() + 1);
            arrayList.add(new thongtincanhan(id,ten,sdt,dc,qq));
            adapter.notifyDataSetChanged();
        }
        if(requestCode == k1 && resultCode == RESULT_OK && data != null)
        {
            Bundle bundle = data.getBundleExtra("dlmoi");
            String ten = bundle.getString("tenmoi").toString();
            String dc = bundle.getString("diachimoi").toString();
            String qq = bundle.getString("quequanmoi").toString();
            String sdt = bundle.getString("sdtmoi").toString();
            String id = String.valueOf(arrayList.size() + 1);
           arrayList.set(vt,new thongtincanhan(String.valueOf(vt),ten,sdt,dc,qq));
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}