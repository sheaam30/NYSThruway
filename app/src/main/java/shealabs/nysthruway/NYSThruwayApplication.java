package shealabs.nysthruway;


import android.app.Application;

import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class NYSThruwayApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new ThruwayTree());
        }
    }

    public static class ThruwayTree extends Timber.Tree {

        public ThruwayTree() {
            super();
        }

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {

        }
    }
}
