package shealabs.nysthruway.widget.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import shealabs.nysthruway.R;

public class FabBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private static final int FAB_SPACING = 50;

    public FabBehavior() {
        super();
    }

    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency.getId() == R.id.bottom_sheet;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        child.setY(dependency.getTop() - child.getHeight() - FAB_SPACING);
        return true;
    }
}
