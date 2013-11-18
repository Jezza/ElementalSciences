package me.jezzadabomb.es.common.machines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import me.jezzadabomb.es.common.api.BlockESContainer;
import me.jezzadabomb.es.common.tileentity.TileEnergyOutput;

public class BlockEnergyOutput extends BlockESContainer{

    public BlockEnergyOutput(int par1, String name) {
        super(par1, Material.anvil, name);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEnergyOutput();
    }
}
