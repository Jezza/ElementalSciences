package me.jezzadabomb.es;

import me.jezzadabomb.es.common.WorldTicker;
import me.jezzadabomb.es.common.tileentity.TileChamberDummy;
import me.jezzadabomb.es.common.tileentity.TileConstructionPlate;
import me.jezzadabomb.es.common.tileentity.TileGravCompressor;
import me.jezzadabomb.es.common.tileentity.TileLaserEmitter;
import me.jezzadabomb.es.common.tileentity.TilePowerEmitter;
import me.jezzadabomb.es.common.tileentity.TileResearchTable;
import me.jezzadabomb.es.common.tileentity.TileStorageChamber;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
    
    public WorldTicker worldTicker = new WorldTicker();
    
    public void runClientSide() {
    };
    
    public void registerTickHandlers() {
        TickRegistry.registerTickHandler(this.worldTicker, Side.SERVER);
    }
    
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileLaserEmitter.class, "laserEmitter");
        GameRegistry.registerTileEntity(TileConstructionPlate.class, "constructionPlate");
        GameRegistry.registerTileEntity(TileStorageChamber.class, "storageChamber");
        GameRegistry.registerTileEntity(TileChamberDummy.class, "chamberBlockdummy");
        GameRegistry.registerTileEntity(TilePowerEmitter.class, "powerEmitter");
        GameRegistry.registerTileEntity(TileResearchTable.class, "researchTable");
        GameRegistry.registerTileEntity(TileGravCompressor.class, "gravCompressor");
   }

}