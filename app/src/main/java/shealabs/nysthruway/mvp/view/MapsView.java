package shealabs.nysthruway.mvp.view;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import shealabs.nysthruway.R;
import shealabs.nysthruway.activity.BaseActivity;
import shealabs.nysthruway.activity.MapsActivity;

public class MapsView extends BaseView implements OnMapReadyCallback {

    GoogleMap mMap;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.map_container) FrameLayout mapContainer;

    public MapsView(MapsActivity activity) {
        super(activity);
    }

    @Override
    public void onSetupViews() {
        toolbar.inflateMenu(R.menu.home);
        toolbar.setBackgroundColor(ContextCompat.getColor(toolbar.getContext(), R.color.colorPrimary));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void hideViews() {
        toolbar.setVisibility(View.INVISIBLE);
        fab.setVisibility(View.INVISIBLE);
    }

    public void showViews() {
        toolbar.setVisibility(View.VISIBLE);
        fab.setVisibility(View.VISIBLE);
    }

    public static final class StartMovingMapCameraEvent { }
    public static final class StoppedMovingMapCameraEvent { }
}
