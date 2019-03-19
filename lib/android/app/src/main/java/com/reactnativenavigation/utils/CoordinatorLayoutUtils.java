package com.reactnativenavigation.utils;

import android.support.design.widget.CoordinatorLayout;
import android.view.Gravity;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class CoordinatorLayoutUtils {
    public static CoordinatorLayout.LayoutParams matchParentLP() {
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        lp.gravity = Gravity.FILL;
        return lp;
    }
}
