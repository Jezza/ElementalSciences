package me.jezzadabomb.es.proxy;

import me.jezzadabomb.es.renders.RenderHadronPipe;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void runClientSide(){
        setupRenderers();
    }
    
    private void setupRenderers() {
        System.out.println("Yep");
        RenderingRegistry.registerBlockHandler(RenderHadronPipe.instance());
    }
}