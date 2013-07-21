package me.jezzadabomb.es.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class BlockItemES extends ItemBlock{
    
    private final static String[] subNames = {
        "white", "orange",  "magenta", "lightBlue", "yellow", "lightGreen",
        "pink", "darkGrey"
    };
    
    public BlockItemES(int id){
        super(id);
        this.setHasSubtypes(true);
    }
    
    public String getItemNameIS(ItemStack itemstack) {
        return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
    }

    public int getMeta (int meta){
        return meta;
    }
}
