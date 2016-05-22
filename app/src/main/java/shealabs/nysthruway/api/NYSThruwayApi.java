package shealabs.nysthruway.api;

import retrofit2.http.GET;
import shealabs.nysthruway.datamodel.TrafficEvents;

interface NYSThruwayApi {

    @GET("events")
    TrafficEvents getTrafficEvents();
}
