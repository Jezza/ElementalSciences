package me.jezzadabomb.es.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;

public class MachineTabES extends CreativeTabs {

    public MachineTabES(int par1, String par2Str) {
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return ModBlocks.chamberBlock.blockID;
    }
}
