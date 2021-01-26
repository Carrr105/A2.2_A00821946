// Actividad 2.2
// Carlos Gerardo Herrera Cortina - A00821946
// https://raw.githubusercontent.com/Carrr105/A2.2_A00821946/master/json/amigos.json
package com.example.act22_a00821946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListFragment fragment;
    private static final String TAG_FRAGMENTO = "fragmento";
    private boolean cargado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = fragment.newInstance();
        cargado = false;
    }

    public void cambiarFragmento (Fragment nuevo){
        // como obtener referencia a un fragmento ya agregado
        FragmentManager manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentByTag(TAG_FRAGMENTO);
        FragmentTransaction transaction = manager.beginTransaction();

        if (!cargado) {
            // si el fragmento que queremos agregar es el que ya está
            if (nuevo == f) {
                return;
            }

            if (f != null) {
                transaction.remove(f);
            }
            transaction.add(R.id.contenedor, nuevo, TAG_FRAGMENTO);
            transaction.commit();
            cargado = true;
        }

    }

    public void fragmentoL(View v){
        cambiarFragmento(fragment);
    }


    public void toast(View v){
        Toast.makeText(this, "XDDDD", Toast.LENGTH_SHORT).show();
    }


}