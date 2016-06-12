package shealabs.nysthruway.widget;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

public class NYMapFragment extends SupportMapFragment {
    View contentView;
    MapDragLayout dragLayout;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        contentView = super.onCreateView(layoutInflater, viewGroup,
                bundle);
        dragLayout = new MapDragLayout(getActivity());
        dragLayout.addView(contentView);

        return dragLayout;
    }

    @Nullable
    @Override
    public View getView() {
        return contentView;
    }
}
