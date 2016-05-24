package shealabs.nysthruway.mvp.model;

import org.greenrobot.eventbus.EventBus;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import shealabs.nysthruway.api.ApiProvider;
import shealabs.nysthruway.api.NYSThruwayApi;
import shealabs.nysthruway.datamodel.TrafficEvents;

public class MapsModel extends BaseModel {

    NYSThruwayApi nysThruwayApi;

    public MapsModel(ApiProvider apiProvider) {
        nysThruwayApi = apiProvider.getNYSThruwayApi();
    }

    public void makeTrafficEventsCall(){
        Observable<TrafficEvents> trafficEventsObservable = nysThruwayApi.getTrafficEvents();
        trafficEventsObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<TrafficEvents>() {
                    @Override
                    public void call(TrafficEvents trafficEvents) {
                        EventBus.getDefault().post(new TrafficEventNext(trafficEvents));
                    }
                });
    }


    //    Events    //
    public static class TrafficEventError { }
    public static class TrafficEventNext {
        public TrafficEvents trafficEvents;

        public TrafficEventNext(TrafficEvents trafficEvents) {
            this.trafficEvents = trafficEvents;
        }
    }
}
