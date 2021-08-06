package org.javaemailclinet.view;

import javafx.scene.paint.Color;

public enum ColorTheme {
    LIGHT,
    DARK;

    public static String getCssPath(ColorTheme colorTheme){
        switch (colorTheme){
            case LIGHT:
                return "css/themeLight.css";
            case DARK:
                return "css/themeDark.css";
            default:
                return null;
        }
    }
}
