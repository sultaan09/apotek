package com.example.apotek;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng home = new LatLng(-0.846621, 119.904634);
        LatLng Apotek= new LatLng(-0.843727, 119.903986);
        int tinggi = 100;
        int lebar = 100;
        BitmapDrawable bitmapstart = (BitmapDrawable)getResources().getDrawable(R.drawable.home);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(R.drawable.pharmacy);
        Bitmap s = bitmapstart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        mMap.addMarker(new MarkerOptions().position(home).title("Home daddy sugar")
                .snippet("Ini adalah rumah saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));

        mMap.addMarker(new MarkerOptions().position(Apotek).title("Marker in Apotek")
                .snippet("Ini adalah Apotek")
                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        mMap.addPolyline(new PolylineOptions().add(
                home,
                new LatLng(-0.846621, 119.904634),
                new LatLng(-0.846604, 119.904356),
                new LatLng(-0.843581, 119.904335),
                new LatLng(-0.843572, 119.903990),
                        new LatLng(-0.843727, 119.903986),
                Apotek
                ).width(10)
                        .color(Color.RED)

        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 14.5f));
    }
}

        // Add a marker in Sydney and move the camera
