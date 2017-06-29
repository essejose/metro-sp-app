package com.essejose.metrosp.api;

/**
 * Created by essejose on 26/06/2017.
 */

public class APIUtils {
    private APIUtils() {}

    public static final String BASE_URL = "http://10.3.1.20:3000/";

    public static LinhaAPI getLinhaAPI() {

        return RetrofitClient.getClient(BASE_URL).create(LinhaAPI.class);
    }


}
