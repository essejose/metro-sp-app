package com.essejose.metrosp.api;

import com.essejose.metrosp.model.Estacao;
import com.essejose.metrosp.model.Linha;
import com.google.android.gms.common.data.DataBufferObserver;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by essejose on 26/06/2017.
 */

public interface LinhaAPI {
    @GET("/linhas")
    Call<List<Linha>> getLinhas();

    @GET("/linhas/{linha}/estacoes")
    Call<List<Estacao>> getEstacao(@Path("linha") String linha);
}
