package com.reactnativenavigation.parse;

import com.reactnativenavigation.parse.params.Bool;
import com.reactnativenavigation.parse.params.Colour;
import com.reactnativenavigation.parse.params.NullBool;
import com.reactnativenavigation.parse.params.NullColor;
import com.reactnativenavigation.parse.params.NullNumber;
import com.reactnativenavigation.parse.params.NullText;
import com.reactnativenavigation.parse.params.Number;
import com.reactnativenavigation.parse.params.Text;
import com.reactnativenavigation.parse.parsers.BoolParser;
import com.reactnativenavigation.parse.parsers.ColorParser;
import com.reactnativenavigation.parse.parsers.NumberParser;
import com.reactnativenavigation.parse.parsers.TextParser;

import org.json.JSONObject;

public class LayoutOptions {
    public static LayoutOptions parse(JSONObject json) {
        LayoutOptions result = new LayoutOptions();
        if (json == null) return result;

        result.backgroundColor = ColorParser.parse(json, "backgroundColor");
        result.componentBackgroundColor = ColorParser.parse(json, "componentBackgroundColor");
        result.topMargin = NumberParser.parse(json, "topMargin");
        result.orientation = OrientationOptions.parse(json);
        result.direction = TextParser.parse(json, "direction");
        result.fitSystemWindows = BoolParser.parse(json, "fitSystemWindows");

        return result;
    }

    public Colour backgroundColor = new NullColor();
    public Colour componentBackgroundColor = new NullColor();
    public Number topMargin = new NullNumber();
    public OrientationOptions orientation = new OrientationOptions();
    public Text direction = new NullText();
    public Bool fitSystemWindows = new NullBool();

    public void mergeWith(LayoutOptions other) {
        if (other.backgroundColor.hasValue()) backgroundColor = other.backgroundColor;
        if (other.componentBackgroundColor.hasValue()) componentBackgroundColor = other.componentBackgroundColor;
        if (other.topMargin.hasValue()) topMargin = other.topMargin;
        if (other.orientation.hasValue()) orientation = other.orientation;
        if (other.direction.hasValue()) direction = other.direction;
        if (other.fitSystemWindows.hasValue()) fitSystemWindows = other.fitSystemWindows;
    }

    public void mergeWithDefault(LayoutOptions defaultOptions) {
        if (!backgroundColor.hasValue()) backgroundColor = defaultOptions.backgroundColor;
        if (!componentBackgroundColor.hasValue()) componentBackgroundColor = defaultOptions.componentBackgroundColor;
        if (!topMargin.hasValue()) topMargin = defaultOptions.topMargin;
        if (!orientation.hasValue()) orientation = defaultOptions.orientation;
        if (!direction.hasValue()) direction = defaultOptions.direction;
        if (!fitSystemWindows.hasValue()) fitSystemWindows = defaultOptions.fitSystemWindows;
    }

    public void mergeWithInitial(LayoutOptions initialOptions) {
        if (!backgroundColor.hasValue()) backgroundColor = initialOptions.backgroundColor;
        if (!componentBackgroundColor.hasValue()) componentBackgroundColor = initialOptions.componentBackgroundColor;
        if (!topMargin.hasValue()) topMargin = initialOptions.topMargin;
        if (!orientation.hasValue()) orientation = initialOptions.orientation;
        if (!direction.hasValue()) direction = initialOptions.direction;
        fitSystemWindows = initialOptions.fitSystemWindows;
    }
}
