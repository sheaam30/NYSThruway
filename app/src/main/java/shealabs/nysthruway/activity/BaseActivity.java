package shealabs.nysthruway.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import shealabs.nysthruway.R;
import shealabs.nysthruway.mvp.model.BaseModel;
import shealabs.nysthruway.mvp.presenter.BasePresenter;
import shealabs.nysthruway.mvp.view.BaseView;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

abstract public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setupCalligraphy();

        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        createPresenter();
        getPresenter().onSetupViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().register();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void setupCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    abstract void createPresenter();
    abstract int getLayoutId();
    abstract BasePresenter<? extends BaseModel, ? extends BaseView> getPresenter();
}
