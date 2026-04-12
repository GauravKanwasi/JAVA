package esm;

import javax.swing.*;
import java.awt.*;

public class AppTheme {

    public static void darkTheme() {
        UIManager.put("Panel.background", new Color(40,40,40));
        UIManager.put("Label.foreground", Color.WHITE);
        UIManager.put("Button.background", new Color(70,130,180));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TextField.background", new Color(60,60,60));
        UIManager.put("TextField.foreground", Color.WHITE);
        UIManager.put("Table.background", new Color(50,50,50));
        UIManager.put("Table.foreground", Color.WHITE);
        UIManager.put("Table.selectionBackground", new Color(100,150,200));
        UIManager.put("Table.selectionForeground", Color.WHITE);
    }

    public static void lightTheme() {
        UIManager.put("Panel.background", Color.WHITE);
        UIManager.put("Label.foreground", Color.BLACK);
        UIManager.put("Button.background", Color.LIGHT_GRAY);
        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("TextField.background", Color.WHITE);
        UIManager.put("TextField.foreground", Color.BLACK);
        UIManager.put("Table.background", Color.WHITE);
        UIManager.put("Table.foreground", Color.BLACK);
    }
}