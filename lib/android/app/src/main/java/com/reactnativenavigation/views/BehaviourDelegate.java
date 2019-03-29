package com.reactnativenavigation.views;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.WindowInsetsCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class BehaviourDelegate<V extends ViewGroup> extends CoordinatorLayout.Behavior<V> {

    private BehaviourAdapter delegate;

    public BehaviourDelegate(BehaviourAdapter<V> delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency) {
        return delegate.onDependentViewChanged(parent, child, dependency);
    }

    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V child, WindowInsetsCompat insets) {
        Log.d("BottomTabsBehaviour", "onApplyWindowInsets ");
        return delegate.onApplyWindowInsets(coordinatorLayout, child, insets);
    }

    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        Log.i("BottomTabsBehaviour", "onMeasureChild ");
        return delegate.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
//        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
//        int height = MeasureSpec.getSize(parentHeightMeasureSpec) -
//                     ((BottomTabsLayout) parent).getBottomTabsHeight();
//        int height = MeasureSpec.getSize(parentHeightMeasureSpec) - 63;
//
//        parent.onMeasureChild(
//                child,
//                parentWidthMeasureSpec, widthUsed,
//                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY), heightUsed
//        );
//        return true;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        return delegate.onLayoutChild(parent, child, layoutDirection);
//        parent.onLayoutChild(child, layoutDirection);
//        child.offsetTopAndBottom(63);
//        return true;
    }

    @Override
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull Rect rect) {
        return delegate.getInsetDodgeRect(parent, child, rect);
    }

    //    @Override
//    public boolean onMeasureChild(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
//        int height = MeasureSpec.getSize(parentHeightMeasureSpec) -
//                     ((BottomTabsLayout) parent).getBottomTabsHeight();
////        int height = MeasureSpec.getSize(parentHeightMeasureSpec);
//
//        parent.onMeasureChild(
//                child,
//                parentWidthMeasureSpec, widthUsed,
//                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY), heightUsed
//        );
//        return true;
//    }
}
