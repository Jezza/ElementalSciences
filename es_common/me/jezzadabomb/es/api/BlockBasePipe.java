package me.jezzadabomb.es.api;

import me.jezzadabomb.es.blocks.BlockES;
import net.minecraft.block.material.Material;

public abstract class BlockBasePipe extends BlockES {

    public int blockID;
    public double pipeWidth;
    
    public BlockBasePipe(int id, String name, double pipeWidth) {
        super(id, Material.iron, name);
        this.blockID = id;
        this.pipeWidth = pipeWidth;
        setBlockBounds(getMinX(), getMinZ(), getMinY(), getMaxX(), getMaxZ(), getMaxY());
    }
    
    public float getMinX() {
        return ((float) (16 / pipeWidth) / 10);
    }

    public float getMaxX() {
        return 1f - getMinX();
    }

    public float getMinZ() {
        return ((float) (16 / pipeWidth) / 10);
    }

    public float getMaxZ() {
        return 1f - getMinZ();
    }

    public float getMinY() {
        return ((float) (16 / pipeWidth) / 10);
    }

    public float getMaxY() {
        return 1f - getMinY();
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
