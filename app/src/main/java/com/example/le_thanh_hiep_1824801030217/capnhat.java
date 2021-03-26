package com.example.le_thanh_hiep_1824801030217;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class capnhat extends AppCompatActivity {

    private EditText edttencu,edttenmoi,edtdccu,edtdcmoi,edtqqcu,edtqqmoi,edtsdtcu,edtsdtmoi;
    private Button btndy,btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capnhat);
        dangkynut();
        kiemtra();
        dangkysukien();
    }
    private void dangkynut()
    {
        btndy = (Button)findViewById(R.id.btnyes);
        btnthoat = (Button)findViewById(R.id.btnthoatra);
        edtdccu = (EditText)findViewById(R.id.edtdccs);
        edtdcmoi = (EditText)findViewById(R.id.edtdcsua);
        edtsdtcu = (EditText)findViewById(R.id.edtsdtcs);
        edtsdtmoi = (EditText)findViewById(R.id.edtsdtsua);
        edttencu = (EditText)findViewById(R.id.edttencs);
        edttenmoi = (EditText)findViewById(R.id.edttenmoi);
        edtqqcu = (EditText)findViewById(R.id.edtqqcs);
        edtqqmoi = (EditText)findViewById(R.id.edtqqsua);
        edttencu.setEnabled(false);
        edtdccu.setEnabled(false);
        edtsdtcu.setEnabled(false);
        edtqqcu.setEnabled(false);
        btndy.setEnabled(false);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("cs");
        String tencu = bundle.getString("tencs").toString();
        String diachicu = bundle.getString("diachics").toString();
        String sdtcu = bundle.getString("sdtcs").toString();
        String quequancu = bundle.getString("qqcs").toString();
        edttencu.setText(tencu);
        edtdccu.setText(diachicu);
        edtsdtcu.setText(sdtcu);
        edtqqcu.setText(quequancu);
    }
    private void dangkysukien()
    {
        btndy.setOnClickListener(new sukiencuatoi());
        btnthoat.setOnClickListener(new sukiencuatoi());
    }
    private void kiemtra()
    {
        edttenmoi.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    if(edttenmoi.getText().toString().trim().length() < 1)
                    {
                        edtqqmoi.setEnabled(false);
                        edtdcmoi.setEnabled(false);
                        edtsdtmoi.setEnabled(false);
                        btndy.setEnabled(false);
                    }
                    else if(edttenmoi.getText().toString().trim().length() >= 1)
                    {
                        edtsdtmoi.setEnabled(true);
                    }
                }
                return false;
            }
        });
        edtsdtmoi.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(edtsdtmoi.getText().toString().trim().length() < 1)
                {
                    edtqqmoi.setEnabled(false);
                    edtdcmoi.setEnabled(false);
                    btndy.setEnabled(false);
                }
                else if(edtsdtmoi.getText().toString().trim().length() >= 1)
                {
                    edtdcmoi.setEnabled(true);
                }
                return false;
            }
        });
        edtdcmoi.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(edtdcmoi.getText().toString().trim().length() < 1)
                {
                    edtqqmoi.setEnabled(false);
                    edtsdtmoi.setEnabled(false);
                    btndy.setEnabled(false);
                }
                else if(edtdcmoi.getText().toString().trim().length() >= 1)
                {
                    edtqqmoi.setEnabled(true);
                }
                return false;
            }
        });
        edtqqmoi.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(edttenmoi.getText().toString().trim().length() < 1)
                {
                    btndy.setEnabled(false);
                }
                else if(edttenmoi.getText().toString().trim().length() >= 1)
                {
                    btndy.setEnabled(true);
                }
                return false;
            }
        });
    }
    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            if(view.equals(btndy))
            {
                String tenmoi = edttenmoi.getText().toString();
                String sdtmoi  = edtsdtmoi.getText().toString();
                String dcmoi  = edtdcmoi.getText().toString();
                String qqmoi  = edtqqmoi.getText().toString();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("tenmoi",tenmoi);
                bundle.putString("sdtmoi",sdtmoi);
                bundle.putString("diachimoi",dcmoi);
                bundle.putString("quequanmoi", qqmoi);
                intent.putExtra("dlmoi",bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
            if(view.equals(btnthoat))
            {

            }
        }
    }


}