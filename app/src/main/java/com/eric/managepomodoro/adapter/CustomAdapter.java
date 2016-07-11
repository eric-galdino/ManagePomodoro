package com.eric.managepomodoro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.fragment.FragmentAtividades;
import com.eric.managepomodoro.fragment.FragmentEstatisticas;

/**
 * Created by Eric on 06/07/2016.
 */

public class CustomAdapter extends BaseAdapter {

    private Context c;

    String[] names={"Verificar notas fiscais","Verificar Estoque","Verificar cargas","Estudar"};
    String[] goals={"1","3","2","1"};

    ;  public CustomAdapter(Context ctx) {
        // TODO Auto-generated constructor stub

        this.c=ctx;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.length;
    }
    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return names[pos];
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return pos;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.fragment_atividades, null);
        }

        TextView nameTxt=(TextView) convertView.findViewById(R.id.nameTxt);
        TextView goalsTxt=(TextView) convertView.findViewById(R.id.goalTxt);

        nameTxt.setText(names[pos]);
        goalsTxt.setText(goals[pos]);

        return convertView;
    }
}