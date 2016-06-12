package shealabs.nysthruway.mvp.view;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.OnClick;
import shealabs.nysthruway.R;
import shealabs.nysthruway.activity.MapsActivity;

public class MapsView extends BaseView implements OnMapReadyCallback {

    GoogleMap googleMap;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.bottom_sheet) FrameLayout bottomSheet;
    BottomSheetBehavior bottomSheetBehavior;

    public MapsView(MapsActivity activity) {
        super(activity);
    }

    @Override
    public void onSetupViews() {
        toolbar.inflateMenu(R.menu.home);
        toolbar.setBackgroundColor(ContextCompat.getColor(toolbar.getContext(), R.color.colorPrimary));
        MenuItem refreshItem = toolbar.getMenu().findItem(R.id.refresh);
        refreshItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Snackbar.make(toolbar, "TODO: Refresh data", Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });
        MenuItem filterItem = toolbar.getMenu().findItem(R.id.filter);
        filterItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Snackbar.make(toolbar, "TODO: Filter Button Dialog", Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        this.googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        this.googleMap.getUiSettings().setCompassEnabled(false);
        this.googleMap.getUiSettings().setMapToolbarEnabled(false);
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                return false;
            }
        });

    }

    public void hideViews() {
        fab.setVisibility(View.INVISIBLE);
    }

    public void showViews() {
        fab.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.fab)
    public void onListButtonClicked(View view) {
        Snackbar.make(view, "TODO: Switch to list Activity", Snackbar.LENGTH_SHORT).show();
    }

    public static final class StartMovingMapCameraEvent { }
    public static final class StoppedMovingMapCameraEvent { }
}
