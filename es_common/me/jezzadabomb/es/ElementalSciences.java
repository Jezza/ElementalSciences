package me.jezzadabomb.es;

import me.jezzadabomb.es.blocks.ModBlocks;
import me.jezzadabomb.es.core.handlers.LocalizationHandler;
import me.jezzadabomb.es.creativetab.CreativeTabES;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
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
        
    public static CreativeTabs tabsES = new CreativeTabES(CreativeTabs.getNextID(), Reference.MOD_ID);
                
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        LocalizationHandler.loadLanguages();
        
        ModBlocks.init();
    }
        
    @Init
    public void load(FMLInitializationEvent event) {
        LanguageRegistry.instance().addStringLocalization("itemGroup.ElementalSciences", "en_US", "Elemental Sciences");
    }
        
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
    }
           
}