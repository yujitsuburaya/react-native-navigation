package com.reactnativenavigation.viewcontrollers.bottomtabs;

import android.support.annotation.VisibleForTesting;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewGroup;

import com.reactnativenavigation.parse.Options;
import com.reactnativenavigation.presentation.BottomTabsPresenter;
import com.reactnativenavigation.viewcontrollers.ViewController;
import com.reactnativenavigation.views.bottomtabs.BottomTabsBehaviour;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public abstract class AttachMode {
    protected final ViewGroup parent;
    protected final BottomTabsPresenter presenter;
    protected final List<ViewController> tabs;
    final ViewController initialTab;
    private final Options resolved;


    public static AttachMode get(ViewGroup parent, List<ViewController> tabs, BottomTabsPresenter presenter, Options resolved) {
        switch (resolved.bottomTabsOptions.tabsAttachMode) {
            case AFTER_INITIAL_TAB:
                return new AfterInitialTab(parent, tabs, presenter, resolved);
            case ON_SWITCH_TO_TAB:
                return new OnSwitchToTab(parent, tabs, presenter, resolved);
            case UNDEFINED:
            case TOGETHER:
            default:
                return new Together(parent, tabs, presenter, resolved);
        }
    }

    AttachMode(ViewGroup parent, List<ViewController> tabs, BottomTabsPresenter presenter, Options resolved) {
        this.parent = parent;
        this.tabs = tabs;
        this.presenter = presenter;
        this.resolved = resolved;
        initialTab = tabs.get(resolved.bottomTabsOptions.currentTabIndex.get(0));
    }

    public abstract void attach();

    public void destroy() {

    }

    public void onTabSelected(ViewController tab) {

    }

    @VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    public void attach(ViewController tab) {
        ViewGroup view = tab.getView();
        view.setTag("tab " + tabs.indexOf(tab));
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
        lp.setBehavior(new BottomTabsBehaviour(tab.getParentController()));
        view.setLayoutParams(lp);

        presenter.applyLayoutParamsOptions(resolved, tabs.indexOf(tab));
        view.setVisibility(tab == initialTab ? View.VISIBLE : View.INVISIBLE);

        parent.addView(view);
    }
}
