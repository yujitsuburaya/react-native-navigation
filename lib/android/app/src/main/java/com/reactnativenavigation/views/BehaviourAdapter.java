package com.reactnativenavigation.views;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;

public interface BehaviourAdapter<V extends ViewGroup> {
    WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V child, WindowInsetsCompat insets);

    boolean onMeasureChild(CoordinatorLayout parent, V child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed);

    boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection);

    boolean getInsetDodgeRect(@NonNull CoordinatorLayout parent, @NonNull V child, @NonNull Rect rect);

    boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency);
}
