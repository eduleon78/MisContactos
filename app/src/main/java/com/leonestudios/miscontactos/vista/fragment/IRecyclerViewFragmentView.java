package com.leonestudios.miscontactos.vista.fragment;

import com.leonestudios.miscontactos.adapter.ContactoAdaptador;
import com.leonestudios.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayou();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
