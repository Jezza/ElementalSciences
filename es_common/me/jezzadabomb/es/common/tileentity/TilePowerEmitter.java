package me.jezzadabomb.es.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TilePowerEmitter extends TileES {
    TileEnergyHandler tileEntityCore;
    int coreX;
    int coreY;
    int coreZ;
    
    public TilePowerEmitter()
    {
    }
    
    public void setCore(TileEnergyHandler core)
    {
        coreX = core.xCoord;
        coreY = core.yCoord;
        coreZ = core.zCoord;
        tileEntityCore = core;
    }
    
    public TileEnergyHandler getCore()
    {
        if(tileEntityCore == null)
            tileEntityCore = (TileEnergyHandler)worldObj.getBlockTileEntity(coreX, coreY, coreZ);
        
        return tileEntityCore;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        
        coreX = tagCompound.getInteger("CoreX");
        coreY = tagCompound.getInteger("CoreY");
        coreZ = tagCompound.getInteger("CoreZ");
    }
    
    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);
        
        tagCompound.setInteger("CoreX", coreX);
        tagCompound.setInteger("CoreY", coreY);
        tagCompound.setInteger("CoreZ", coreZ);
    }
}
