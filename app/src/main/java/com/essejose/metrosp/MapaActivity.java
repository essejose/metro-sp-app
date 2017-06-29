package com.essejose.metrosp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.essejose.metrosp.api.APIUtils;
import com.essejose.metrosp.api.LinhaAPI;
import com.essejose.metrosp.model.Estacao;
import com.essejose.metrosp.model.Linha;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Linha linha;
    private LinhaAPI linhaAPI;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if(getIntent() != null){
            linha = getIntent().getParcelableExtra("LINHA");
        }

        carregaEstaca();
    }

    private  void carregaEstaca(){
        linhaAPI = APIUtils.getLinhaAPI();
        linhaAPI.getEstacao(linha.getCor()).enqueue(new Callback<List<Estacao>>() {
            @Override
            public void onResponse(Call<List<Estacao>> call, Response<List<Estacao>> response) {
                if(response.isSuccessful()){
                   for( Estacao e : response.body()){

                        LatLng estacao = new LatLng(Double.parseDouble(e.getLatitude()),
                                Double.parseDouble(e.getLongitude()));

                        mMap.addMarker(new MarkerOptions().position(estacao).title("Mark" + e.getNome()));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(estacao,18));
                   }
                }

            }

            @Override
            public void onFailure(Call<List<Estacao>> call, Throwable t) {
                Log.v(TAG, t.getMessage());
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,16));
    }
}
