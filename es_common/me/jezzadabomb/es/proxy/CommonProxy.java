package me.jezzadabomb.es.proxy;

import me.jezzadabomb.es.tileentity.TileChamberDummy;
import me.jezzadabomb.es.tileentity.TileConstructionPlate;
import me.jezzadabomb.es.tileentity.TileLaserEmitter;
import me.jezzadabomb.es.tileentity.TileLinearEmitter;
import me.jezzadabomb.es.tileentity.TilePowerEmitter;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void runClientSide() {
    };

    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileLinearEmitter.class, "linearAcc");
        GameRegistry.registerTileEntity(TileLaserEmitter.class, "laserEmitter");
        GameRegistry.registerTileEntity(TileConstructionPlate.class, "constructionPlate");
        GameRegistry.registerTileEntity(TileStorageChamber.class, "storageChamber");
        GameRegistry.registerTileEntity(TileChamberDummy.class, "chamberBlockdummy");
        GameRegistry.registerTileEntity(TilePowerEmitter.class, "powerEmitter");
    }

}