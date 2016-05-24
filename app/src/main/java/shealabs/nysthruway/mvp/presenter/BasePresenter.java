package shealabs.nysthruway.mvp.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import shealabs.nysthruway.mvp.model.BaseModel;
import shealabs.nysthruway.mvp.view.BaseView;

abstract public class BasePresenter<M extends BaseModel, V extends BaseView> {
    M model;
    V view;

    public BasePresenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    public final void setupViews() {
        view.setupViews();
        onSetupViews();
    }

    public final void register() {
        onRegister();
    }

    public void onRegister() { /*Override*/ }
    public void onSetupViews() { /*Override*/ }

    public static class TestEvent { }
}
