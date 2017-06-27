package com.essejose.metrosp.api;

import com.essejose.metrosp.model.Linha;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by essejose on 26/06/2017.
 */

public interface LinhaAPI {
    @GET("/linhas")
    Call<List<Linha>> getLinhas();
}
