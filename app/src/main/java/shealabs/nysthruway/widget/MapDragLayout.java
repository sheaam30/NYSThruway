package shealabs.nysthruway.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;

import shealabs.nysthruway.mvp.view.MapsView;

public class MapDragLayout extends FrameLayout {

    public MapDragLayout(Context context) {
        super(context);
    }

    public MapDragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapDragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MapDragLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                EventBus.getDefault().post(new MapsView.StartMovingMapCameraEvent());
                break;

            case MotionEvent.ACTION_UP:
                EventBus.getDefault().post(new MapsView.StoppedMovingMapCameraEvent());
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
