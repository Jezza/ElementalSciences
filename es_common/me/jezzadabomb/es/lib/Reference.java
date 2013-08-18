package me.jezzadabomb.es.lib;

public class Reference {

    // Main Reference Classes
    public static final String MOD_ID = "ElementalSciences";
    public static final String MOD_NAME = "Elemental Sciences";
    public static final String VERSION = "";

    public static final String SERVER_PROXY_CLASS = "me.jezzadabomb.es.proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "me.jezzadabomb.es.proxy.ClientProxy";
    
    public static int tickRate(){
        return convertSecondsToTicks(2);
    }
    
    public static int convertSecondsToTicks(int sec){
        return sec*20;
    }
}
