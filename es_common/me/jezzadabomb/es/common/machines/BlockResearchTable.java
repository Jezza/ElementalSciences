package me.jezzadabomb.es.common.machines;

import me.jezzadabomb.es.common.api.BlockESContainer;
import me.jezzadabomb.es.common.tileentity.TileResearchTable;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockResearchTable extends BlockESContainer{
    
    public BlockResearchTable(int id, String name) {
        super(id, Material.anvil, name);
        setUnlocalizedName(name);
        setBlockBounds(0F, 0.4F, 0F, 1F, 1F, 1F);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileResearchTable();
    }
    
    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return -1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}
