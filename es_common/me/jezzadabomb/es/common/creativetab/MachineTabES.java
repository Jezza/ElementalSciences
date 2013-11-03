package me.jezzadabomb.es.common.creativetab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.common.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;

public class MachineTabES extends CreativeTabs {

    public MachineTabES(int par1, String par2Str) {
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return ModBlocks.researchTable.blockID;
    }
}
