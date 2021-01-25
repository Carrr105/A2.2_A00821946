package com.example.act22_a00821946;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    // definir un view holder
    // - un objeto que se encarga de administrar una vista de renglón
    public class ListViewHolder extends RecyclerView.ViewHolder {

        public TextView texto1, texto2;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            texto1 = itemView.findViewById(R.id.textView4);
            texto2 = itemView.findViewById(R.id.textView5);
        }
    }

    // extremadamente común, casi regla
    // referencia a fuente de datos
    private ArrayList<String> nombres;
    private ArrayList<String> hobby;
    private View.OnClickListener listener;

    public ListAdapter(ArrayList<String> nombres, ArrayList<String> hobby, View.OnClickListener listener){
        this.hobby = hobby;
        this.nombres = nombres;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // crear view específica de renglón
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        Button b = v.findViewById(R.id.button7);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.wtf("BOTONAZO", "BOTON PRESIONADO");
                Toast.makeText(v.getContext(), "SI FUNCIONA", Toast.LENGTH_SHORT).show();
            }
        });

        v.setOnClickListener(listener);

        ListViewHolder pvh = new ListViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        // asocia un viewholder con datos en particular
        holder.texto1.setText(nombres.get(position));
        holder.texto2.setText(hobby.get(position));
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }


}
