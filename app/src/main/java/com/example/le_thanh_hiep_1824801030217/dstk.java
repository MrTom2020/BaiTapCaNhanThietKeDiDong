package com.example.le_thanh_hiep_1824801030217;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class dstk extends AppCompatActivity
{

    private Button btn;
    private ListView ls;
    private tkadapter tk;
    private ArrayList<thongke> tkk;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dstk);
        dangkynut();
        dangkysk();
    }
    private void dangkynut()
    {
        tkk = new ArrayList<>();
        ls = (ListView)findViewById(R.id.lss);
        btn = (Button)findViewById(R.id.btnthoatr);
        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra("kkk");
            tkk = (ArrayList) bundle.getSerializable("dstk");
            Toast.makeText(this,String.valueOf(tkk.size()),Toast.LENGTH_SHORT).show();
            tk = new tkadapter(this,R.layout.danhs,tkk);
            ls.setAdapter(tk);
        }
        catch (Exception e)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
        }
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
    public void dangkysk()
    {
        btn.setOnClickListener(new sukiencuatoi());
    }
    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(btn))
            {
                laycauhoi();
            }
        }
    }
}