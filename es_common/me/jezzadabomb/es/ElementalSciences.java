package me.jezzadabomb.es;

import me.jezzadabomb.es.blocks.ModBlocks;
import me.jezzadabomb.es.core.handlers.LocalizationHandler;
import me.jezzadabomb.es.creativetab.MachineTabES;
import me.jezzadabomb.es.creativetab.MiscTabES;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class ElementalSciences {
    // The instance of your mod that Forge uses.
    @Instance(Reference.MOD_ID)
    public static ElementalSciences instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public static CreativeTabs machineTab = new MachineTabES(CreativeTabs.getNextID(), Reference.MOD_ID);
    public static CreativeTabs miscTab = new MiscTabES(CreativeTabs.getNextID(), Reference.MOD_ID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Loading Localizations.");
        LocalizationHandler.loadLanguages();
        System.out.println("Finished Loading Localizations.");
        ModBlocks.init();
        proxy.runClientSide();
    }
        
    @EventHandler
    public void load(FMLInitializationEvent event) {
        LanguageRegistry.instance().addStringLocalization("itemGroup.ElementalSciences", "en_US", "Elemental Sciences");
        
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
    }
           
}