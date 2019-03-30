package com.reactnativenavigation.views.insets;

public class Insets {
    private int bottomTabsInsets = 0;

    public void update(Insets insets) {
        if (insets.bottomTabsInsets != 0) bottomTabsInsets = insets.bottomTabsInsets;
    }

    public int getBottomTabsInsets() {
        return bottomTabsInsets;
    }

    public void setBottomTabsInsets(int bottomTabsInsets) {
        this.bottomTabsInsets = bottomTabsInsets;
    }
}
