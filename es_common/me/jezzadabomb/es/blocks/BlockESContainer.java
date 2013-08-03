package me.jezzadabomb.es.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.tileentity.TileES;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public abstract class BlockESContainer extends BlockContainer{

    public static final int MASK_DIR = 0x00000007;
    public static final int META_DIR_NORTH = 0x00000001;
    public static final int META_DIR_SOUTH = 0x00000002;
    public static final int META_DIR_EAST = 0x00000003;
    public static final int META_DIR_WEST = 0x00000000;
    
    protected BlockESContainer(int par1, Material par2Material) {
        super(par1, par2Material);
        setCreativeTab(ElementalSciences.machineTab);
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entity, ItemStack itemStack)
    {
        int metadata = 0;
        int facing = META_DIR_WEST;
        
        int dir = MathHelper.floor_double((double)(entity.rotationYaw * 4f / 360f) + 0.5) & 3;
        if(dir == 0)
            facing = META_DIR_NORTH;
        if(dir == 1)
            facing = META_DIR_EAST;
        if(dir == 2)
            facing = META_DIR_SOUTH;
        if(dir == 3)
            facing = META_DIR_WEST;
        
        metadata |= facing;
        world.setBlockMetadataWithNotify(x, y, z, metadata, 2);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().replace("tile.", ""));
    }
    
    
}
