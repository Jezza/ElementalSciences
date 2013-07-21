package me.jezzadabomb.es.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMetaBlock extends BlockES {

    public int BlockID;
    
    public BlockMetaBlock(int id){
        super(id, Material.wood);
        this.BlockID = id;
        this.setUnlocalizedName(Strings.BLOCKMETA_NAME);
    }
    
    public Icon[] icons;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg){
        icons = new Icon[8];
        for(int i = 0; i < icons.length ; i++){
            icons[i] = iconReg.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName2()) + i );
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int i, int j){
        return icons[j];
    }

    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list){
        for(int i = 0; i < 8 ; i++){
            list.add(new ItemStack(id, 1, i));
        }
    }
}