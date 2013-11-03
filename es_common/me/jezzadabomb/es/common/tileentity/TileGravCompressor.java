package me.jezzadabomb.es.common.tileentity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;

import me.jezzadabomb.es.common.ModBlocks;

public class TileGravCompressor extends TileES {
    
    private int counter = 0;
    public int rangeAbove = 0;
    public boolean requiresUpdate = true;
    
    @Override
    public boolean canUpdate()
    {
      return true;
    }
    
    @Override
    public void updateEntity()
    {
      super.updateEntity();
      this.counter += 1;
      if ((this.requiresUpdate) || (this.counter % 100 == 0))
      {
        this.requiresUpdate = false;

        int max = 10;
        int count = 1;
        while ((this.worldObj.getBlockId(this.xCoord, this.yCoord - count, this.zCoord) == ModBlocks.gravCompressor.blockID))
        {
          count++;
          max += 10;
        }
        this.rangeAbove = 0;
        while ((this.rangeAbove < max) && (!this.worldObj.isBlockOpaqueCube(this.xCoord, this.yCoord + 1 + this.rangeAbove, this.zCoord))) {
          this.rangeAbove += 1;
        }

      }

      if ((this.rangeAbove > 0)) {
        List<Entity> targets = this.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getAABBPool().getAABB(this.xCoord, this.yCoord + 1, this.zCoord, this.xCoord + 1, this.yCoord + 1 + this.rangeAbove, this.zCoord + 1));

        if (targets.size() > 0)
          for (Entity e : targets)
            if (e.canBePushed()) {
              if (e.isSneaking()) {
                if (e.motionY < 0.0D) e.motionY *= 0.8999999761581421D;
              }
              else if (e.motionY < 0.3499999940395355D) e.motionY += 0.1000000014901161D;

              e.fallDistance = 0.0F;
            }
      }
    }
}
