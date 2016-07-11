package com.eric.managepomodoro.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.adapter.CustomAdapter;

/**
 * Created by Eric on 06/07/2016.
 */
public class FragmentDetalheAtividade extends Activity {

    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datalhe_atividade);

        Intent i=getIntent();
        pos=i.getExtras().getInt("Position");

        final CustomAdapter adapter=new CustomAdapter(this);
        final TextView name=(TextView)findViewById(R.id.nameTxt);
        final TextView goal=(TextView) findViewById(R.id.goalTxt);

       // name.setText(adapter.name[pos]);
       // goal.setText(adapter.goals[pos]);


        Button nextBtn=(Button) findViewById(R.id.button1);

        nextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                int position=pos+1;

                //name.setText("Name: "+ adapter.names[position]);
                //goal.setText("Goals: "+ adapter.goals[position]);

                if(!(position>=adapter.getCount()-1))
                {
                    pos +=1;
                }else
                {
                    pos = -1;
                }

            }
        });
    }
}
