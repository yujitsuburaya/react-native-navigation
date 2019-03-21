package com.reactnativenavigation.utils;

import android.support.design.widget.CoordinatorLayout;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class CoordinatorLayoutUtils {
    public static CoordinatorLayout.LayoutParams matchParentLP() {
        return new CoordinatorLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
    }
}
