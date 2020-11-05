package com.leonestudios.miscontactos.restApi;

import com.leonestudios.miscontactos.pojo.Contacto;
import com.leonestudios.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();
}
