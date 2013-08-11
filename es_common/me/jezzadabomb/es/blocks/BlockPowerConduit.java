package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.api.BlockBasePipe;
import me.jezzadabomb.es.api.BlockPowerComponent.PowerComponent;
import me.jezzadabomb.es.core.helpers.Helper;
import me.jezzadabomb.es.renderers.RenderPowerConduit;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPowerConduit extends BlockBasePipe implements PowerComponent{
    
    public BlockPowerConduit(int id, String name, double pipeWidth) {
        super(id, name, pipeWidth);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        float[] min = { getMinX(), getMinZ(), getMinY() };
        float[] max = { getMaxX(), getMaxZ(), getMaxY() };
        if (Block.blocksList[world.getBlockId(x - 1, y, z)] instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x - 1, y, z)).canTubeConnectOnSide(world, x - 1, y, z, Helper.dirXPos))
                min[0] = 0.0F;
        }
        if (Block.blocksList[world.getBlockId(x + 1, y, z)] instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x + 1, y, z)).canTubeConnectOnSide(world, x + 1, y, z, Helper.dirXNeg))
                max[0] = 1.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y - 1, z)] instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y - 1, z)).canTubeConnectOnSide(world, x, y - 1, z, Helper.dirYPos))
                min[1] = 0.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y + 1, z)] instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y + 1, z)).canTubeConnectOnSide(world, x, y + 1, z, Helper.dirYNeg))
                max[1] = 1.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y, z - 1)] instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y, z - 1)).canTubeConnectOnSide(world, x, y, z - 1, Helper.dirZPos))
                min[2] = 0.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y, z + 1)] instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y, z + 1)).canTubeConnectOnSide(world, x, y, z + 1, Helper.dirZNeg))
                max[2] = 1.0F;
        }
        this.setBlockBounds(min[0], min[1], min[2], max[0], max[1], max[2]);
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(w, x, y, z);
        return AxisAlignedBB.getAABBPool().getAABB((double) x + this.minX, (double) y + this.minY, (double) z + this.minZ, (double) x + this.maxX, (double) y + this.maxY, (double) z + this.maxZ);
    }

    
    @Override
    public int getRenderType() {
        return RenderPowerConduit.instance().getRenderId();
    }
    
    @Override
    public PowerComponentType getPowerComponentType() {
        return PowerComponentType.TUBE;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        return true;
    }
}
