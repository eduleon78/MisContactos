package com.leonestudios.miscontactos.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.leonestudios.miscontactos.restApi.ConstantesRestApi;
import com.leonestudios.miscontactos.restApi.EndpointsApi;
import com.leonestudios.miscontactos.restApi.deserializador.ContactoDeserializador;
import com.leonestudios.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);

    }

    public Gson construyeGsonDeserializadorMediaCenter(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        return gsonBuilder.create();
    }
}
