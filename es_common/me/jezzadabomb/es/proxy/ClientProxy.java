package me.jezzadabomb.es.proxy;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerKeyBindingHandler() {

        //KeyBindingRegistry.registerKeyBinding(new KeyBindingHandler());
    }

    @Override
    public void registerRenderTickHandler() {

    }

    @Override
    public void registerSoundHandler() {

        //MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }

    @Override
    public void initRenderingAndTextures() {

    }

    @Override
    public void registerTileEntities() {

        super.registerTileEntities();

    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getBlockTileEntity(x, y, z);

    }
    
    @Override
    public void handleTileWithItemPacket(int x, int y, int z, ForgeDirection orientation, byte state, String customName, int itemID, int metaData) {
        
    }
}