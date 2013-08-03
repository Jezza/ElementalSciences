package me.jezzadabomb.es.proxy;

import me.jezzadabomb.es.tileentity.TileLinearEmitter;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void runClientSide(){};
    
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileLinearEmitter.class, "linearAcc");
    }
    
}