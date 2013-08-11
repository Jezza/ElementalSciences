package me.jezzadabomb.es.core.util;

import me.jezzadabomb.es.lib.Reference;

public class ESLogger {

    public static String title = "[" + Reference.MOD_ID + "]";

    public static String info = "[INFO]";
    public static String warning = "[WARNING]";
    public static String severe = "[SEVERE]";
    public static String block = "[BLOCK]";

    // Local Debug Settings, and other shit. :D
    public boolean debug = true;
    public boolean debugBlock = false;

    public void print(String msg) {
        System.out.println(title + msg);
    }

    public void print(String msg, int type) {
        switch (type) {
            case 1:
                printInfo(msg);
                break;
            case 2:
                printWarning(msg);
                break;
            case 3:
                printSevere(msg);
                break;
            case 4:
                printDebugInfo(msg);
                break;
            case 5:
                printDebugWarning(msg);
                break;
            case 6:
                printDebugSevere(msg);
                break;
            case 7:
                printDebug(msg);
                break;
            default:
                printInfo(msg);
                break;
        }
    }

    public void printInfo(String msg) {
        print(info + msg);
    }

    public void printWarning(String msg) {
        print(warning + msg);
    }

    public void printSevere(String msg) {
        print(severe + msg);
    }

    public void printDebugInfo(String msg) {
        if (debug) {
            print(info + msg);
        }
    }

    public void printDebugWarning(String msg) {
        if (debug) {
            print(warning + msg);
        }
    }

    public void printDebugSevere(String msg) {
        if (debug) {
            print(severe + msg);
        }
    }

    public void printDebug(String msg) {
        if (debugBlock) {
            print(info + msg);
        }
    }
}
