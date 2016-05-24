package shealabs.nysthruway.mvp.view;

import android.app.Activity;

import butterknife.ButterKnife;

abstract public class BaseView {

    private Activity activity;

    public BaseView(Activity activity) {
        this.activity = activity;
    }

    public final void setupViews() {
        ButterKnife.bind(this, activity);
        onSetupViews();
    }

    abstract public void onSetupViews();
}
