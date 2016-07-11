package com.eric.communicatingfragments_bundle;

/**
 * Created by Eric on 28/06/2016.
 */
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyFragment3 extends Fragment implements View.OnClickListener{
    private String v = null;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private MyConnector myConnector;

    public MyFragment3() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        v = bundle.getString("akey");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fragment_my_fragment3, container, false);
        TextView fragText = (TextView)viewGroup.findViewById(R.id.fragtext);
        Button fragButton = (Button)viewGroup.findViewById(R.id.fragbutton);
        fragButton.setOnClickListener(this);
        if (!v.equals(null)){
            fragText.setText(v);
        }
        return viewGroup;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof MyConnector){
            myConnector = (MyConnector)activity;
        }
    }
    @Override
    public void onClick(View v) {
        //getActivity().getValuesFromFragment();
        /*
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.getValuesFromFragment("A value sent from Fragment");
        */
        myConnector.getValueFromFragmentUsingInterface("A value sent from Fragment");
    }
}
