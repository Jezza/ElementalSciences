package me.jezzadabomb.es.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockES extends Block {

    public BlockES(int id, Material material) {

        super(id, material);
        setCreativeTab(ElementalSciences.tabsES);
    }

    public void printDebug(String msg){
        if(Reference.debug){
            System.out.println(msg);
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().replace("tile.", ""));
    }
}
