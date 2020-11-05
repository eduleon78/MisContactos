package com.leonestudios.miscontactos.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.leonestudios.miscontactos.pojo.Contacto;
import com.leonestudios.miscontactos.restApi.JsonKeys;
import com.leonestudios.miscontactos.restApi.model.ContactoResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);
        JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setContactos(deserializadorContactoDeJeson(contactoResponseData));
        return contactoResponse;
    }

    private ArrayList<Contacto> deserializadorContactoDeJeson(JsonArray contactoResponseData){
        ArrayList<Contacto> contactos = new ArrayList<>();
        for (int i = 0; i< contactoResponseData.size() ; i++){
            JsonObject contactoResponseDataObject = contactoResponseData.get(i).getAsJsonObject();

            JsonObject userJson     = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson    = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDAR_RESOLUTION);
            String urlFoto          = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Contacto contactoActual = new Contacto();
            contactoActual.setId(id);
            contactoActual.setNombreCompleto(nombreCompleto);
            contactoActual.setUrlFoto(urlFoto);
            contactoActual.setLikes(likes);

            contactos.add(contactoActual);

        }
        return contactos;
    }
}
