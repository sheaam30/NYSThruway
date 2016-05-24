package shealabs.nysthruway.activity;

import shealabs.nysthruway.R;
import shealabs.nysthruway.api.ApiProvider;
import shealabs.nysthruway.mvp.model.BaseModel;
import shealabs.nysthruway.mvp.model.MapsModel;
import shealabs.nysthruway.mvp.presenter.BasePresenter;
import shealabs.nysthruway.mvp.presenter.MapsPresenter;
import shealabs.nysthruway.mvp.view.BaseView;
import shealabs.nysthruway.mvp.view.MapsView;

public class MapsActivity extends BaseActivity {

    MapsPresenter presenter;

    @Override
    void createPresenter() {
        presenter = new MapsPresenter(new MapsModel(new ApiProvider()), new MapsView(this));
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_maps;
    }

    @Override
    BasePresenter<? extends BaseModel, ? extends BaseView> getPresenter() {
        return presenter;
    }
}
