package shealabs.nysthruway.mvp.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import shealabs.nysthruway.mvp.model.MapsModel;
import shealabs.nysthruway.mvp.model.MapsModel.TrafficEventError;
import shealabs.nysthruway.mvp.model.MapsModel.TrafficEventNext;
import shealabs.nysthruway.mvp.view.MapsView;
import shealabs.nysthruway.mvp.view.MapsView.StartMovingMapCameraEvent;
import timber.log.Timber;

import static shealabs.nysthruway.mvp.view.MapsView.*;

public class MapsPresenter extends BasePresenter<MapsModel, MapsView> {

    public MapsPresenter(MapsModel model, MapsView view) {
        super(model, view);
    }

    @Override
    public void onSetupViews() {
        EventBus.getDefault().register(this);
        model.makeTrafficEventsCall();
        view.setupViews();
    }

    @Subscribe
    public void onTrafficEventsReceived(TrafficEventNext eventNext) {
        Timber.i("Next");
    }

    @Subscribe
    public void onTrafficEventsFail(TrafficEventError eventError) {
        Timber.i("Error");
    }

    @Subscribe
    public void onStartMovingMapCameraEvent(StartMovingMapCameraEvent event) {
        view.hideViews();
    }

    @Subscribe
    public void onStopMovingMapCameraEvent(StoppedMovingMapCameraEvent event) {
        view.showViews();
    }
}
