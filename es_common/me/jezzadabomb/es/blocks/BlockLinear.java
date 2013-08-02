package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.blocks.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockLinear extends BlockES implements PipeComponent {

    public BlockLinear(int id, String name) {
        super(id, Material.anvil);
        setUnlocalizedName(name);
    }
    
    @Override
    public PipeComponentType getIonComponentType() {
        return PipeComponentType.SOURCE;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        return true;
    }
    
    
}
