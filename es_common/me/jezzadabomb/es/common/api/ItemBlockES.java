package me.jezzadabomb.es.common.api;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class ItemBlockES extends ItemBlock {

    public ItemBlockES(int par1) {
        super(par1);
    }

    public int getMetadata(int meta) {
        return meta;
    }
    
    @SuppressWarnings("rawtypes")
    public abstract void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4);
}
