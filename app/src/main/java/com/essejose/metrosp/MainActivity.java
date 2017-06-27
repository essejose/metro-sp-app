package com.essejose.metrosp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.essejose.metrosp.adpter.LinhaAdpter;
import com.essejose.metrosp.adpter.OnItemClickListner;
import com.essejose.metrosp.api.APIUtils;
import com.essejose.metrosp.api.LinhaAPI;
import com.essejose.metrosp.model.Linha;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rvLinhas;
    private LinhaAdpter linhaAdpter;
    private LinhaAPI    linhaAPI;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvLinhas = (RecyclerView) findViewById(R.id.rvLinhas);

        linhaAdpter = new LinhaAdpter(new ArrayList<Linha>(),
                new OnItemClickListner() {
                    @Override
                    public void onItemClick(Linha item) {
                        Toast.makeText(getApplicationContext(),
                                item.getCor(),Toast.LENGTH_SHORT).show();
                    }
                });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLinhas.setLayoutManager(layoutManager);
        rvLinhas.setAdapter(linhaAdpter);
        rvLinhas.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration
                = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        rvLinhas.addItemDecoration(itemDecoration);

        carregaDados();
    }

    private  void carregaDados(){


        linhaAPI = APIUtils.getLinhaAPI();
        linhaAPI.getLinhas().enqueue(new Callback<List<Linha>>() {
            @Override
            public void onResponse(Call<List<Linha>> call, Response<List<Linha>> response) {
                if(response.isSuccessful()){

                    linhaAdpter.update(
                            response
                                    .body()
                                    );
                }
                Log.v(TAG, "index= 1");
            }

            @Override
            public void onFailure(Call<List<Linha>> call, Throwable t) {
                Log.v(TAG, t.getMessage());
            }
        });
    }
}
