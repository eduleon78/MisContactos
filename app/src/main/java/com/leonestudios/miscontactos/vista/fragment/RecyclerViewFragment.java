package com.leonestudios.miscontactos.vista.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.leonestudios.miscontactos.R;
import com.leonestudios.miscontactos.pojo.Contacto;
import com.leonestudios.miscontactos.adapter.ContactoAdaptador;
import com.leonestudios.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.leonestudios.miscontactos.presentador.RecyclerViewFragmentPresenter;


import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*return super.onCreateView(inflater, container, savedInstanceState);*/
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter((IRecyclerViewFragmentPresenter) this, getContext());
        return v;
    }

    /*

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Eduado Leon", "04248587119", "eduleon78@gmail.com", R.drawable.pina, 0, 2));
        contactos.add(new Contacto("Sonyram Acosta", "04248587119", "sonyacostamillan@gmail.com", R.drawable.pina, 0, 2));
        contactos.add(new Contacto("Christian Leon", "04248587119", "christianleon78@gmail.com", R.drawable.pina, 0, 2));
        contactos.add(new Contacto("Leander Leon", "04248587119", "leanderleon78@gmail.com", R.drawable.pina, 0, 2));

    }*/



    @Override
    public void generarLinearLayoutVertical(){
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayou() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rvContactos.setLayoutManager(gridLayoutManager);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity() );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador){
        rvContactos.setAdapter(adaptador);

    }
}
