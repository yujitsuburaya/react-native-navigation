package com.reactnativenavigation.views.bottomtabs;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.WindowInsetsCompat;
import android.view.ViewGroup;

public class BottomTabsBehaviour<V extends ViewGroup> extends CoordinatorLayout.Behavior<V> {
    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V child, WindowInsetsCompat insets) {
        return super.onApplyWindowInsets(coordinatorLayout, child, insets);
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
