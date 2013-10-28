package me.jezzadabomb.es.proxy;

import me.jezzadabomb.es.lib.BlockIds;
import me.jezzadabomb.es.renderers.RenderHadronPipe;
import me.jezzadabomb.es.renderers.RenderLaserEmitter;
import me.jezzadabomb.es.renderers.RenderPowerConduit;
import me.jezzadabomb.es.renderers.TileResearchTableRenderer;
import me.jezzadabomb.es.renderers.items.ItemResearchTableRenderer;
import me.jezzadabomb.es.tileentity.TileResearchTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
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
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileResearchTable.class, new TileResearchTableRenderer());
        MinecraftForgeClient.registerItemRenderer(BlockIds.RESEARCH_TABLE_DEFAULT, new ItemResearchTableRenderer());
    }
}