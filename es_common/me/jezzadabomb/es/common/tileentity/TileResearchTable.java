package me.jezzadabomb.es.common.tileentity;

import me.jezzadabomb.es.common.ModBlocks;

public class TileResearchTable extends TileES {
    
    public TileResearchTable() {
    }
    
    public boolean isComplete(){
        
        for(int i = 0; i < 3; i++){
            for(int q = 0; q < 2; q++){
                for(int s = 0; s < 2; s++){
                    if(worldObj.getBlockId(xCoord - (q == 0 ? 2 : -2), yCoord + i, zCoord - (s == 0 ? 2 : -2)) != ModBlocks.chamberBlock.blockID)return false;
                }
            }
        }
        
        return true;
    }
}
