package shealabs.nysthruway.widget.behavior;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

import shealabs.nysthruway.R;


public class FabBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private ValueAnimator mFabTranslationYAnimator;
    private float mFabTranslationY;


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
        updateFabTranslationForSnackbar(parent, child, dependency);
        return true;
    }

    private void updateFabTranslationForSnackbar(CoordinatorLayout parent,
                                                 final FloatingActionButton fab, View snackbar) {

        final float targetTransY = getFabTranslationYForSnackbar(parent, fab);
        if (mFabTranslationY == targetTransY) {
            // We're already at (or currently animating to) the target value, return...
            return;
        }

        final float currentTransY = ViewCompat.getTranslationY(fab);

        // Make sure that any current animation is cancelled
        if (mFabTranslationYAnimator != null && mFabTranslationYAnimator.isRunning()) {
            mFabTranslationYAnimator.cancel();
        }

        if (fab.isShown()
                && Math.abs(currentTransY - targetTransY) > (fab.getHeight() * 0.667f)) {
            // If the FAB will be travelling by more than 2/3 of it's height, let's animate
            // it instead
            if (mFabTranslationYAnimator == null) {
                mFabTranslationYAnimator = new ValueAnimator();
                mFabTranslationYAnimator.setInterpolator(new FastOutSlowInInterpolator());
                mFabTranslationYAnimator.addUpdateListener(
                        new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                ViewCompat.setTranslationY(fab,
                                        (float) animation.getAnimatedValue());
                            }
                        });
            }
            mFabTranslationYAnimator.setFloatValues(currentTransY, targetTransY);
            mFabTranslationYAnimator.start();
        } else {
            // Now update the translation Y
            ViewCompat.setTranslationY(fab, targetTransY);
        }

        mFabTranslationY = targetTransY;
    }

    private float getFabTranslationYForSnackbar(CoordinatorLayout parent,
                                                FloatingActionButton fab) {
        float minOffset = 0;
        final List<View> dependencies = parent.getDependencies(fab);
        for (int i = 0, z = dependencies.size(); i < z; i++) {
            final View view = dependencies.get(i);
            if (view instanceof Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
                minOffset = Math.min(minOffset,
                        ViewCompat.getTranslationY(view) - view.getHeight());
            }
        }

        return minOffset;
    }
}
