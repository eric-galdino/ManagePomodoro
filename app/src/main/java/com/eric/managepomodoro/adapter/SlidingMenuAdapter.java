package com.eric.managepomodoro.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.model.ItemSlideMenu;

import java.util.List;

/**
 * Created by Eric on 31/05/2016.
 */
public class SlidingMenuAdapter extends BaseAdapter {

    private Context context;
    private List<ItemSlideMenu> listItem;

    public SlidingMenuAdapter(Context context, List<ItemSlideMenu> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.item_sliding_menu, null);
        ImageView img = (ImageView)view.findViewById(R.id.item_img);
        TextView txv = (TextView)view.findViewById(R.id.item_title);

        ItemSlideMenu item = listItem.get(position);
        img.setImageResource(item.getImgId());
        txv.setText(item.getTitle());

        return view;
    }
}
