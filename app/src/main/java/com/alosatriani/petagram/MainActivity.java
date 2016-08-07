package com.alosatriani.petagram;

import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout miswiperefresh;
    ListView milista;
    Adapter adaptador;
    static int tipo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        agregarFloatingFAB();

        miswiperefresh = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        milista = (ListView)findViewById(R.id.milista);
        String[] plantetas = getResources().getStringArray(R.array.planetas);

        milista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,plantetas));

        miswiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarContenido();
            }
        });
    }


    public void refrescarContenido(){
        String[] planetas = null;
        if(tipo%2==0)
          planetas = getResources().getStringArray(R.array.otrosplanetas);
        else
            planetas = getResources().getStringArray(R.array.planetas);


        tipo++;

        milista.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas));
        miswiperefresh.setRefreshing(false);

    }
    public void agregarFloatingFAB(){
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.miFloatingButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(getBaseContext(),R.string.toast1,Toast.LENGTH_SHORT).show();
                Snackbar.make(v, R.string.toast1, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.accion, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getBaseContext(),R.string.toast1,Toast.LENGTH_SHORT).show();
                                Log.i("SNACKBAR","CLICK en snack bar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorBlanco))

                        .show();
            }
        });
    }
}
