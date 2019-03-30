package com.reactnativenavigation.views;

import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup;

public interface BehaviourAdapter<V extends ViewGroup> {
    boolean onMeasureChild(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed);

    boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection);

    boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency);
}
