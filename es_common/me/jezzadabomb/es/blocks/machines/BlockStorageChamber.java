package me.jezzadabomb.es.blocks.machines;

import java.util.Random;

import me.jezzadabomb.es.blocks.BlockESContainer;
import me.jezzadabomb.es.common.BlockPowerComponent.PowerComponent;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStorageChamber extends BlockESContainer implements PowerComponent {

    public BlockStorageChamber(int id, String name) {
        super(id, Material.iron, name);
    }

    public boolean getDebug() {
        return false;
    }

    @Override
    public int tickRate(World world) {
        return 40;
    }

    public void updateTick(World world, int x, int y, int z, Random par5Random) {

        TileStorageChamber core = (TileStorageChamber) world.getBlockTileEntity(x, y, z);
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
    public PowerComponentType getPowerComponentType() {
        return PowerComponentType.SOURCE;
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
        TileStorageChamber core = (TileStorageChamber) world.getBlockTileEntity(x, y, z);

        if (getDebug()) {
            core.convertDummies();
        } else {

        }

        return true;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileStorageChamber();
    }
}
