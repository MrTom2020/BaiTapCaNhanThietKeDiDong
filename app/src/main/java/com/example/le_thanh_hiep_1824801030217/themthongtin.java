package com.example.le_thanh_hiep_1824801030217;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class themthongtin extends Activity
{

    private Button btndy,btnthoat;
    private EditText edtten,edtdt,edtdc;
    private Spinner spinner;
    private List<String> arrayList;
    private String qq;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themthongtin);
        dangkynut();
        ax();
        dangkysk();
    }
    private void dangkynut()
    {
        btndy = (Button)findViewById(R.id.btndongy);
        btnthoat = (Button)findViewById(R.id.btnexit);
        spinner = (Spinner)findViewById(R.id.spinner);
        edtdc = (EditText)findViewById(R.id.edtdiachi);
        edtdt = (EditText)findViewById(R.id.edtsdt);
        edtten = (EditText)findViewById(R.id.edtthemten);

    }
    public void ax()
    {
        arrayList = new ArrayList<>();
        arrayList.add("Sài gòn");
        arrayList.add("Nha Trang");
        arrayList.add("Hà Nội");
        arrayList.add("Bình Dương");
        arrayList.add("Hải Phòng");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                qq = arrayList.get(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
    private void dangkysk()
    {
        btndy.setOnClickListener(new sukiencuatoi());
    }
    private class sukiencuatoi implements View.OnClickListener
    {
        @Override
        public void onClick(View view)
        {
            String ten = edtten.getText().toString();
            String sdt = edtdt.getText().toString();
            String diachi = edtdc.getText().toString();
            Bundle bundle = new Bundle();
            Intent intent = new Intent();
            bundle.putString("ten",ten);
            bundle.putString("diachi",diachi);
            bundle.putString("quequan",qq);
            bundle.putString("sdt",sdt);
            intent.putExtra("ok",bundle);
            setResult(RESULT_OK,intent);
           // startActivityForResult(intent,RESULT_OK);
            finish();
        }
    }
}