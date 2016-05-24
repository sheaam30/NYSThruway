package shealabs.nysthruway.api;

import retrofit2.http.GET;
import rx.Observable;
import shealabs.nysthruway.datamodel.TrafficEvents;

public interface NYSThruwayApi {

    @GET("events.xml")
    Observable<TrafficEvents> getTrafficEvents();
}
