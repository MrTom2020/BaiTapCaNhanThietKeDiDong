package com.example.le_thanh_hiep_1824801030217;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class tkadapter extends BaseAdapter
{
    public Context context;
    public int layout;
    public List<thongke> thongkess;

    @Override
    public int getCount() {
        return thongkess.size();
    }
    public class ViewHoler
    {
        TextView txtten,txtqq;
    }
    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHoler viewHoler;
        if(convertView == null)
        {
            viewHoler = new ViewHoler();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);
            viewHoler.txtqq = (TextView)convertView.findViewById(R.id.textView16);
            viewHoler.txtten= (TextView)convertView.findViewById(R.id.textView17);
            convertView.setTag(viewHoler);
        }
        else
        {
            viewHoler = (ViewHoler)convertView.getTag();
        }
        thongke tk = thongkess.get(position);
        viewHoler.txtten.setText(tk.getK());
        viewHoler.txtqq.setText(tk.getSl());
        return convertView;
    }

    public tkadapter(Context context, int layout, List<thongke> thongkess) {
        this.context = context;
        this.layout = layout;
        this.thongkess = thongkess;
    }
}
