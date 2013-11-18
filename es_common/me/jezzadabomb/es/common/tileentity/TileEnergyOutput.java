package me.jezzadabomb.es.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import ic2.api.energy.tile.*;;

public class TileEnergyOutput extends TileES{
    
    private IEnergySource energySource;
    
    public TileEnergyOutput() {
        
    }
    
    @Override
    public void updateEntity() {
        //energySource.onUpdateEntity();
        int energyProduction = 0;
        
        //energySource.addEnergy(generateEnergy());
    }

    private int generateEnergy() {
        return 128;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        if (worldObj == null) {
            return true;
        }
        if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this) {
            return false;
        }
        return entityplayer.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
    }

    @Override
    public void onChunkUnload() {
        //energySource.onChunkUnload();
    }

    @Override
    public void invalidate() {
        //energySource.onInvalidate();
        super.invalidate();
    }
    
}
