package com.reactnativenavigation.presentation;

import android.view.View;
import android.view.ViewGroup;

import com.reactnativenavigation.parse.Options;
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

    private void mergeBackgroundColor(ComponentLayout view, Options options) {
        if (options.layout.componentBackgroundColor.hasValue()) {
            view.setBackgroundColor(options.layout.componentBackgroundColor.get());
        }
    }

    public void applyTopInsets(View view, int topInsets) {
        if (view != null) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin = topInsets;
            view.requestLayout();
        }
    }
}
