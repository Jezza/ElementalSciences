package me.jezzadabomb.es.blocks.machines;

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
    
    public boolean getDebug(){
        return false;
    }
    
    @Override
    public PowerComponentType getPowerComponentType() {
        return PowerComponentType.SOURCE;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        TileStorageChamber core = (TileStorageChamber)world.getBlockTileEntity(x, y, z);
        
        if(getDebug()){
            core.convertDummies();
        }else{
            
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
