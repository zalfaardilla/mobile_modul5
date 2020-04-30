package com.example.maps_praktikum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng Home = new LatLng( -8.263785, 112.692314 );
        map.addMarker(new MarkerOptions() .position(Home).title("Marker in Home"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Home));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.maps_place, menu);
        inflater.inflate(R.menu.maps_background, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case R.id.Pilihan_Background:
                Toast.makeText( this, "Silahkan Pilih", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.normal_map:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;

            case R.id.hybrid_map:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                return true;

            case R.id.satellite_map:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                return true;

            case R.id.terrain_map:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                return true;


            case R.id.Pilihan_Tempat:
                Toast.makeText( this, "Silahkan Pilih", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.spbu:
                LatLng spbu = new LatLng(-8.266044, 112.693463 );
                map.addMarker(new MarkerOptions() .position(spbu).title("Marker in SPBU"));
                map.moveCamera(CameraUpdateFactory.newLatLng(spbu));
                return true;

            case R.id.restoran:
                LatLng restoran = new LatLng(-8.266559, 112.693482);
                map.addMarker(new MarkerOptions() .position(restoran).title("Marker in Restoran"));
                map.moveCamera(CameraUpdateFactory.newLatLng(restoran));
                return true;

            case R.id.kantor_polisi:
                LatLng kantor_polisi = new LatLng(-8.278878, 112.690275 );
                map.addMarker(new MarkerOptions() .position(kantor_polisi).title("Marker in Kantor Polisi"));
                map.moveCamera(CameraUpdateFactory.newLatLng(kantor_polisi));
                return true;

            case R.id.tempat_wisata:
                LatLng tempat_wisata = new LatLng(-8.310037, 112.667562);
                map.addMarker(new MarkerOptions() .position(tempat_wisata).title("Marker in Tempat Wisata"));
                map.moveCamera(CameraUpdateFactory.newLatLng(tempat_wisata));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
