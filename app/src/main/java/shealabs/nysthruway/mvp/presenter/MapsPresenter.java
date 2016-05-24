package shealabs.nysthruway.mvp.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import shealabs.nysthruway.mvp.model.MapsModel;
import shealabs.nysthruway.mvp.view.MapsView;
import timber.log.Timber;

public class MapsPresenter extends BasePresenter<MapsModel, MapsView> {

    public MapsPresenter(MapsModel model, MapsView view) {
        super(model, view);
    }

    @Override
    public void onSetupViews() {
        EventBus.getDefault().register(this);
        model.makeTrafficEventsCall();
    }

    @Subscribe
    public void onTrafficEventsReceived(MapsModel.TrafficEventNext eventNext) {
        Timber.i("Next");
    }

    @Subscribe
    public void onTrafficEventsFail(MapsModel.TrafficEventError eventError) {
        Timber.i("Error");
    }
}
