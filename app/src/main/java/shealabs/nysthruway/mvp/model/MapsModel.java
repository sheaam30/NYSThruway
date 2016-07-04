package shealabs.nysthruway.mvp.model;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import shealabs.nysthruway.api.ApiProvider;
import shealabs.nysthruway.api.NYSThruwayApi;
import shealabs.nysthruway.datamodel.data.TrafficEvents;
import shealabs.nysthruway.datamodel.response.TrafficEventsResponse;

import static shealabs.nysthruway.datamodel.data.TrafficEvents.*;

public class MapsModel extends BaseModel {

    NYSThruwayApi nysThruwayApi;
    //TODO Add a database eventually
    TrafficEvents trafficEvents;

    public MapsModel(ApiProvider apiProvider) {
        nysThruwayApi = apiProvider.getNYSThruwayApi();
    }

    public void makeTrafficEventsCall(){
        Observable<TrafficEventsResponse> trafficEventsObservable = nysThruwayApi.getTrafficEvents();
        trafficEventsObservable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Action1<TrafficEventsResponse>() {
                    @Override
                    public void call(TrafficEventsResponse trafficEventsResponse) {
                        TrafficEvents trafficEvents = mapResponse(trafficEventsResponse);
                        saveTrafficEvents(trafficEvents);
                        EventBus.getDefault().post(new TrafficEventNext(trafficEventsResponse));
                    }
                });
    }

    private TrafficEvents mapResponse(TrafficEventsResponse trafficEventsResponse) {
        TrafficEvents trafficEvents = new TrafficEvents();
        int trafficEventsSize = trafficEventsResponse.eventList.size();
        for (int i = 0; i < trafficEventsSize; i++) {
            TrafficEventsResponse.Event trafficEventResponse = trafficEventsResponse.eventList.get(i);
            TrafficEvents.Event event = new TrafficEvents.Event();
            event.setCategory(trafficEventResponse.category);
            event.setEventId(trafficEventResponse.eventId);
            event.setEventType(trafficEventResponse.eventType);
            event.setOrgId(trafficEventResponse.orgId);
            event.setUpdateTime(trafficEventResponse.updateTime);
            event.setDirection(trafficEventResponse.direction);
            event.setEventDesc(trafficEventResponse.eventDesc);
            event.setExpirationDateTime(trafficEventResponse.expirationDateTime);
            event.setLatitude(trafficEventResponse.latitude);
            event.setLongitude(trafficEventResponse.longitude);
            event.setMilePost(trafficEventResponse.milePost);
            event.setRegion(trafficEventResponse.region);
            event.setRoute(trafficEventResponse.route);
            trafficEvents.getEventList().add(event);
        }
        return trafficEvents;
    }

    private void saveTrafficEvents(TrafficEvents trafficEvents) {
        this.trafficEvents = trafficEvents;
    }

    public TrafficEvents getTrafficEvents() {
        if (trafficEvents == null) trafficEvents = new TrafficEvents();
        return trafficEvents;
    }

    //    Events    //
    public static class TrafficEventError { }
    public static class TrafficEventNext {
        public TrafficEventsResponse trafficEventsResponse;

        public TrafficEventNext(TrafficEventsResponse trafficEventsResponse) {
            this.trafficEventsResponse = trafficEventsResponse;
        }
    }
}
