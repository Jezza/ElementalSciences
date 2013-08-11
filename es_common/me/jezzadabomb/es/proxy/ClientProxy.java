package me.jezzadabomb.es.proxy;

import me.jezzadabomb.es.renderers.RenderHadronPipe;
import me.jezzadabomb.es.renderers.RenderLaserEmitter;
import me.jezzadabomb.es.renderers.RenderPowerConduit;
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
    }
}