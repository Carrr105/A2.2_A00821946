package com.example.act22_a00821946;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements View.OnClickListener, Handler.Callback  {

    private RecyclerView recyclerView;
    private ArrayList<String> datos;
    private ArrayList<String> nombres;
    private ArrayList<String> hobby;
    private Handler handler;


    public static ListFragment newInstance() {

        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nombres = new ArrayList<>();
        hobby = new ArrayList<>();
        datos = new ArrayList<>();
        // handler
        handler = new Handler(Looper.getMainLooper(), this);

        Request request = new Request("https://raw.githubusercontent.com/Carrr105/A2.2_A00821946/master/json/amigos.json", handler);
        request.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_list_fragment, container, false);

        // obtener referencia al widget de recycler view (GUI)
        recyclerView = v.findViewById(R.id.recycler);

        return v;
    }

    @Override
    public void onClick(View view) {
        int pos = recyclerView.getChildLayoutPosition(view);
        //        Toast.makeText(getContext(), datos.get(pos), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        try {
            JSONArray datos = (JSONArray) msg.obj;


            for (int i = 0; i < datos.length(); i++) {

                JSONObject temp = datos.getJSONObject(i);
                nombres.add(temp.getString("nombre"));
                hobby.add(temp.getString("hobby"));

                Log.wtf("JSON", "--------------------------------------");
                Log.wtf("JSON", temp.getString("nombre"));
                Log.wtf("JSON", temp.getInt("edad") + "");
            }

            ListAdapter adapter = new ListAdapter(nombres, hobby, this);

            // layout manager
            // define cómo se van a organizar los elementos en el recycler view
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            GridLayoutManager glm = new GridLayoutManager(getContext(), 1);

            recyclerView.setLayoutManager(llm);
            recyclerView.setAdapter(adapter);
        }catch (JSONException e) {
            e.printStackTrace();
        }

        return true;
    }
}