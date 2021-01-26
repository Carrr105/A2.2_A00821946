package com.example.act22_a00821946;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsFragment extends Fragment {

    public TextView nom, dir, hob, ed, tel;

    public static DetailsFragment newInstance() {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        return fragment;
    }
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_details_fragment, container, false);

        nom = v.findViewById(R.id.textView);
        ed = v.findViewById(R.id.textView2);
        hob = v.findViewById(R.id.textView6);
        tel = v.findViewById(R.id.textView8);
        dir = v.findViewById(R.id.textView9);
        nom.setText(getArguments().getString("nombre"));
        ed.setText("Edad: " + getArguments().getInt("edad"));
        hob.setText("Hobby: " + getArguments().getString("hobby"));
        tel.setText("Telefono: " + getArguments().getInt("telefono"));
        dir.setText("Direccion: " + getArguments().getString("direccion"));


        return v;
    }

    public void onBackPressed()
    {
     //   FragmentManager fm = getActivity().getSupportFragmentManager();
     //   fm.popBackStack();
        getFragmentManager().beginTransaction().
                remove(this).commit();
    }

}