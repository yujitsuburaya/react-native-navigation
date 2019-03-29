package com.reactnativenavigation.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

import com.reactnativenavigation.BuildConfig;
import com.reactnativenavigation.utils.UiUtils;
import com.reactnativenavigation.viewcontrollers.topbar.TopBarController;
import com.reactnativenavigation.views.topbar.TopBar;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

@SuppressLint("ViewConstructor")
public class StackLayout extends CoordinatorLayout implements Component {
    private String stackId;

    public StackLayout(Context context, TopBarController topBarController, String stackId) {
        super(context);
        this.stackId = stackId;
        createLayout(topBarController);
        if (BuildConfig.DEBUG) setContentDescription("StackLayout");
    }

    private void createLayout(TopBarController topBarController) {
        View topBar = topBarController.createView(getContext(), this);
        CoordinatorLayout.LayoutParams lp = new LayoutParams(MATCH_PARENT, UiUtils.getTopBarHeight(getContext()));
        addView(topBar, lp);
    }

    public String getStackId() {
        return stackId;
    }

    @Override
    public void drawBehindTopBar() {

    }

    @Override
    public void drawBelowTopBar(TopBar topBar) {

    }

    @Override
    public boolean isRendered() {
        return getChildCount() >= 2 &&
               getChildAt(1) instanceof Renderable &&
               ((Renderable) getChildAt(1)).isRendered();
    }
}
