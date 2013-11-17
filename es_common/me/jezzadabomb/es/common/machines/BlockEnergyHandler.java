package me.jezzadabomb.es.common.machines;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import me.jezzadabomb.es.common.api.BlockESContainer;
import me.jezzadabomb.es.common.lib.Reference;
import me.jezzadabomb.es.common.tileentity.TileEnergyHandler;

public class BlockEnergyHandler extends BlockESContainer{

    public BlockEnergyHandler(int id, String name) {
        super(id, Material.iron, name);
    }

    public boolean getDebug() {
        return false;
    }

    @Override
    public int tickRate(World world) {
        return Reference.convertSecondsToTicks(1);
    }

    public void updateTick(World world, int x, int y, int z, Random par5Random) {

        TileEnergyHandler core = (TileEnergyHandler) world.getBlockTileEntity(x, y, z);
        //If the core isn't null
        if (core != null) {
            //If it isn't already formed.
            if (!core.getIsValid()) {
                //Check for the formation
                if (core.checkIfProperlyFormed()) {
                    //Correctly formed, then continue converting.
                    core.validateMultiblock();
                    log.print(String.valueOf(core.getIsValid()));
                }
                Update(world, x, y, z);
            }
        }
        log.print(String.valueOf((core.getIsValid())));
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }

    public void Update(World world, int x, int y, int z) {
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        TileEnergyHandler core = (TileEnergyHandler) world.getBlockTileEntity(x, y, z);

        if (getDebug()) {
            core.convertDummies();
        } else {

        }

        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEnergyHandler();
    }

}
