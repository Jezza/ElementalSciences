package me.jezzadabomb.es.client;

import me.jezzadabomb.es.CommonProxy;
import me.jezzadabomb.es.client.renderers.blocks.BlockLaserEmitterRenderer;
import me.jezzadabomb.es.client.renderers.items.ItemResearchTableRenderer;
import me.jezzadabomb.es.client.renderers.tile.TileResearchTableRenderer;
import me.jezzadabomb.es.common.lib.BlockIds;
import me.jezzadabomb.es.common.tileentity.TileResearchTable;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void runClientSide(){
        setupRenderers();
    }
    
    private void setupRenderers() {
        RenderingRegistry.registerBlockHandler(BlockLaserEmitterRenderer.instance());
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileResearchTable.class, new TileResearchTableRenderer());
        MinecraftForgeClient.registerItemRenderer(BlockIds.RESEARCH_TABLE_DEFAULT, new ItemResearchTableRenderer());
    }
}