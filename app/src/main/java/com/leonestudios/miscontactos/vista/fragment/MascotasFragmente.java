package com.leonestudios.miscontactos.vista.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leonestudios.miscontactos.R;
import com.leonestudios.miscontactos.adapter.MascotaAdapter;
import com.leonestudios.miscontactos.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFragmente extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;
    public MascotaAdapter adaptadormascota;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_mascotas_fragmente, container, false);

        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llmmascotas = new LinearLayoutManager(getActivity());
        llmmascotas.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llmmascotas);
        inicializarListaMascota();
        inicializarAdaptador();
        return v;
    }
    public void inicializarAdaptador(){
        adaptadormascota = new MascotaAdapter(mascotas, getActivity());
        listamascotas.setAdapter(adaptadormascota);
    }
    public void inicializarListaMascota(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
        mascotas.add(new Mascota("Capitan", 2, R.drawable.pina));
    }
}