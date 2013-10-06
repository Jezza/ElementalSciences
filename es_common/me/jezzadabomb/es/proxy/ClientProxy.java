package me.jezzadabomb.es.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import me.jezzadabomb.es.lib.BlockIds;
import me.jezzadabomb.es.renderers.RenderHadronPipe;
import me.jezzadabomb.es.renderers.RenderLaserEmitter;
import me.jezzadabomb.es.renderers.RenderPowerConduit;
import me.jezzadabomb.es.renderers.TileStorageChamberRenderer;
import me.jezzadabomb.es.renderers.items.ItemStorageChamberRenderer;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void runClientSide(){
        setupRenderers();
    }
    
    private void setupRenderers() {
        RenderingRegistry.registerBlockHandler(RenderHadronPipe.instance());
        RenderingRegistry.registerBlockHandler(RenderLaserEmitter.instance());
        RenderingRegistry.registerBlockHandler(RenderPowerConduit.instance());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileStorageChamber.class, new TileStorageChamberRenderer());
        MinecraftForgeClient.registerItemRenderer(BlockIds.STORAGE_CHAMBER_DEFAULT, new ItemStorageChamberRenderer());
    }
}