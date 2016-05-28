package shealabs.nysthruway.mvp.view;

import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import shealabs.nysthruway.activity.BaseActivity;
import shealabs.nysthruway.activity.MapsActivity;

abstract public class BaseView {

    private MapsActivity activity;

    public BaseView(MapsActivity activity) {
        this.activity = activity;
    }

    public final void setupViews() {
        ButterKnife.bind(this, activity);
        onSetupViews();
    }

    final FragmentManager getSupportFragmentManager() {
        return activity.getSupportFragmentManager();
    }

    protected Resources getResources() {
        return activity.getResources();
    }

    abstract public void onSetupViews();
}
