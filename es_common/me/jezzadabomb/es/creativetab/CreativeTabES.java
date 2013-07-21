package me.jezzadabomb.es.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabES extends CreativeTabs {
 
    public CreativeTabES(int par1, String par2Str) {

        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex() {

        return ModBlocks.chamberBlock.blockID;
    }
}
