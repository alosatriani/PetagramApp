package com.alosatriani.petagram;

import android.os.Bundle;
import android.os.PersistableBundle;

import android.support.v7.app.AppCompatActivity;

import com.alosatriani.petagram.R;

/**
 * Created by Sergio on 19/07/2016.
 */
public class DetallePerroAct extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.detalle_perro);
    }
}
