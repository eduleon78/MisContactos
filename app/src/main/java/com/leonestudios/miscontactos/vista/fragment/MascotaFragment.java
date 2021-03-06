package com.leonestudios.miscontactos.vista.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leonestudios.miscontactos.R;
import com.leonestudios.miscontactos.adapter.PerfilMascotaAdapter;
import com.leonestudios.miscontactos.pojo.Mascota;

import java.util.ArrayList;

public class MascotaFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public PerfilMascotaAdapter adaptadormascota;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MascotaFragment(){

    }
    public static MascotaFragment newInstance (String mParam1, String mParam2){
        MascotaFragment fragment = new MascotaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mascota, container, false);
        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        GridLayoutManager llmmascotas = new GridLayoutManager(getActivity(), 3);
        listamascotas.setLayoutManager(llmmascotas);
        iniciarListaMascotas();
        iniciarAdaptador();
        return v;
    }
    public void iniciarAdaptador(){
        adaptadormascota = new PerfilMascotaAdapter(mascotas, getActivity());
        listamascotas.setAdapter(adaptadormascota);
    }
    public void iniciarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));

    }
}