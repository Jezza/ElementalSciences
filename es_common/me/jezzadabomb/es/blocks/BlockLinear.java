package me.jezzadabomb.es.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.blocks.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.tileentity.TileLinear;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLinear extends BlockESContainer implements PipeComponent {

    public Icon facing;
    public Icon other;
    
    public BlockLinear(int id, String name) {
        super(id, Material.anvil);
        setUnlocalizedName(name);
    }
    
    @Override
    public Icon getIcon(int side, int metadata)
    {
        if(){
            
        }
    }
    
    private static int getSideFromFacing(int facing)
    {
        switch(facing)
        {
        case META_DIR_WEST:
            return 4;
            
        case META_DIR_EAST:
            return 5;
            
        case META_DIR_NORTH:
            return 2;
            
        case META_DIR_SOUTH:
            return 3;
            
        default:
            return 4;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        facing = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_facing");
        other = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")));
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
