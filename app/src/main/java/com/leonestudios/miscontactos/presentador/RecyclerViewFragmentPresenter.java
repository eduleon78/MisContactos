package com.leonestudios.miscontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.leonestudios.miscontactos.db.ConstructorContactos;
import com.leonestudios.miscontactos.pojo.Contacto;
import com.leonestudios.miscontactos.restApi.EndpointsApi;
import com.leonestudios.miscontactos.restApi.adapter.RestApiAdapter;
import com.leonestudios.miscontactos.restApi.model.ContactoResponse;
import com.leonestudios.miscontactos.vista.fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentPresenter iRecyclerViewFragmentPresenter, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();

    }

    //Se establece la llamada al servidor, ejecuta la llamada a getRecentMedia
    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
       Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaCenter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponsecCall = endpointsApi.getRecentMedia();

        contactoResponsecCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoresponse= response.body();
                contactoresponse.getContactos();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable throwable) {
                Toast.makeText(context, "!Algo pasó en la conexion¡ Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", toString().toString());

            }
        });


    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayou();

    }
}
