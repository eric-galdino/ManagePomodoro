package com.eric.managepomodoro.main;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.adapter.SlidingMenuAdapter;
import com.eric.managepomodoro.fragment.FragmentTimer;
import com.eric.managepomodoro.fragment.FragmentAtividades;
import com.eric.managepomodoro.fragment.FragmentEstatisticas;
import com.eric.managepomodoro.fragment.FragmentConfiguracoes;
import com.eric.managepomodoro.fragment.FragmentSobre;
import com.eric.managepomodoro.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 27/05/2015.
 */

public class MainActivity extends AppCompatActivity {

    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init component
        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listSliding = new ArrayList<>();

        //Add item para a lista lateral
        listSliding.add(new ItemSlideMenu(R.drawable.ic_time, "Timer"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_atividade, "Atividades"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_grafico, "Estatística"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_configuracao, "Configurações"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_about, "Sobre"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_logout,"Logout"));

        adapter = new SlidingMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Set o titulo
        setTitle(listSliding.get(0).getTitle());

        //item selecionado
        listViewSliding.setItemChecked(0, true);

        //Fecha menu
        drawerLayout.closeDrawer(listViewSliding);


        replaceFragment(0);

        //Item cliclado

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set titulo
                setTitle(listSliding.get(position).getTitle());
                //item selecionado
                listViewSliding.setItemChecked(position, true);
                //Susbistitiu o fragment
                replaceFragment(position);
                //Fecha menu
                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_aberto, R.string.drawer_fechado){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    //Cria o metodo para substituir o fragment

    private void replaceFragment(int pos) {
        Fragment fragment = null;
        switch (pos) {
            case 0:
                fragment = new FragmentTimer();
                break;
            case 1:
                fragment = new FragmentAtividades();
                break;
            case 2:
                fragment = new FragmentEstatisticas();
                break;
            case 3:
                fragment = new FragmentConfiguracoes();
                break;
            case 4:
                fragment = new FragmentSobre();
                break;
            default:
                fragment = new FragmentTimer();
                break;
        }

         if(null!=fragment) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}
