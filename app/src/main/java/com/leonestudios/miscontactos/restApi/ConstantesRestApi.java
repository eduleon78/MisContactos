package com.leonestudios.miscontactos.restApi;

public class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/V1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3259702353.aa0d01865afc914ecc8ffc8f6dc84aa17b";
    public static final String KEY_ACCESS_TOKEN = "?acces_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/?acces_token=3259702353.aa0d01865afc914ecc8ffc8f6dc84aa17b
    //https://api.instagram.com/v1/users/self/media/recent/?acces_token=ACCESS-TOKEN"

}
