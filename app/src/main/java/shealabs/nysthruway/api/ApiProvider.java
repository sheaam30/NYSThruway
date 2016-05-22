package shealabs.nysthruway.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ApiProvider {
    private static final String API_BASE_URL = "http://www.thruway.ny.gov/xml/netdata/";

    public NYSThruwayApi getNYSThruwayApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        return retrofit.create(NYSThruwayApi.class);
    }
}
