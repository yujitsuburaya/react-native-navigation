package com.reactnativenavigation.presentation;

import android.support.design.widget.CoordinatorLayout;
import android.view.View.MeasureSpec;

import com.reactnativenavigation.parse.Options;
import com.reactnativenavigation.viewcontrollers.ViewController;
import com.reactnativenavigation.views.ComponentLayout;

public class ComponentPresenter {
    public Options defaultOptions;

    public ComponentPresenter(Options defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    public void setDefaultOptions(Options defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    public void applyOptions(ComponentLayout view, Options options) {
        mergeBackgroundColor(view, options);
    }

    public void mergeOptions(ComponentLayout view, Options options) {
        if (options.overlayOptions.interceptTouchOutside.hasValue()) view.setInterceptTouchOutside(options.overlayOptions.interceptTouchOutside);
        mergeBackgroundColor(view, options);
    }

    public boolean onMeasure(CoordinatorLayout parent, ViewController child, Options resolvedOptions, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        int height = MeasureSpec.getSize(parentHeightMeasureSpec);
        height -= child.getInsets().getBottomTabsInsets();
        if (resolvedOptions.statusBar.drawBehind.isFalseOrUndefined()) {
            height -= 63;
        }
        int spec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        parent.onMeasureChild(child.getView(), parentWidthMeasureSpec, widthUsed, spec, heightUsed);
        return true;
    }


    private void mergeBackgroundColor(ComponentLayout view, Options options) {
        if (options.layout.componentBackgroundColor.hasValue()) {
            view.setBackgroundColor(options.layout.componentBackgroundColor.get());
        }
    }
}
