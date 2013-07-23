package me.jezzadabomb.es.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class BlockItemES extends ItemBlock{
    
    public BlockItemES(int id){
        super(id);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata (int meta){
        return meta;
    }
    
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return super.getUnlocalizedName() + "." + ItemDye.dyeColorNames[BlockDyedQuartz.getDyeFromBlock(par1ItemStack.getItemDamage())];
    }
}
