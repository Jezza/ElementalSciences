package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockES extends Block {

    public BlockES(int id, Material material) {

        super(id, material);
        setCreativeTab(ElementalSciences.tabsES);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
    }
    
//    @Override
//    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
//        
//        int direction = 0;
//        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
//
//        if (facing == 0) {
//            direction = ForgeDirection.NORTH.ordinal();
//        }
//        else if (facing == 1) {
//            direction = ForgeDirection.EAST.ordinal();
//        }
//        else if (facing == 2) {
//            direction = ForgeDirection.SOUTH.ordinal();
//        }
//        else if (facing == 3) {
//            direction = ForgeDirection.WEST.ordinal();
//        }
//
//        world.setBlockMetadataWithNotify(x, y, z, direction, 3);
//
//        if (itemStack.hasDisplayName()) {
//            ((TileEE) world.getBlockTileEntity(x, y, z)).setCustomName(itemStack.getDisplayName());
//        }
//
//        ((TileEE) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
//    }
}
