package com.example.le_thanh_hiep_1824801030217;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class thongtinAdapter extends BaseAdapter
{
    public Context context;
    public int Layout;
    public List<thongtincanhan> thongtincanhanList;
    @Override
    public int getCount()
    {
        return thongtincanhanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }
    public class ViewHoler
    {
        TextView txtid,txtten,txtsdt,txtdc,txtqq;
    }

    public thongtinAdapter(Context context, int layout, List<thongtincanhan> thongtincanhanList)
    {
        this.context = context;
        Layout = layout;
        this.thongtincanhanList = thongtincanhanList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHoler viewHoler;
        if(convertView == null)
        {
            viewHoler = new ViewHoler();
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(Layout,null);
            viewHoler.txtid = (TextView)convertView.findViewById(R.id.txtstt);
            viewHoler.txtdc = (TextView)convertView.findViewById(R.id.txtdiachi);
            viewHoler.txtsdt = (TextView)convertView.findViewById(R.id.txtsdt);
            viewHoler.txtqq = (TextView)convertView.findViewById(R.id.txtquequan);
            viewHoler.txtten = (TextView)convertView.findViewById(R.id.txtten);
            convertView.setTag(viewHoler);
        }
        else
        {
            viewHoler = (ViewHoler)convertView.getTag();
        }
        thongtincanhan ttcn = thongtincanhanList.get(position);
        viewHoler.txtid.setText(ttcn.getId());
        viewHoler.txtten.setText(ttcn.getTen());
        viewHoler.txtqq.setText(ttcn.getQueQuan());
        viewHoler.txtsdt.setText(ttcn.getSDT());
        viewHoler.txtdc.setText(ttcn.getDiaChi());

        return convertView;
    }
}
