package me.jezzadabomb.es;

import me.jezzadabomb.es.blocks.ModBlocks;
import me.jezzadabomb.es.creativetab.MachineTabES;
import me.jezzadabomb.es.creativetab.MiscTabES;
import me.jezzadabomb.es.items.ModItems;
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

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
//@NetworkMod(channels = { Reference.CHANNEL_NAME }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class ElementalSciences {
    
    @Instance(Reference.MOD_ID)
    public static ElementalSciences instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs machineTab = new MachineTabES(CreativeTabs.getNextID(), Reference.MOD_ID + ".machines");
    public static CreativeTabs miscTab = new MiscTabES(CreativeTabs.getNextID(), Reference.MOD_ID + ".misc");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
        proxy.runClientSide();
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerTileEntities();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
}