package me.jezzadabomb.es.common.blocks;

import java.util.List;

import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.common.api.BlockES;
import me.jezzadabomb.es.common.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPureColour extends BlockES {

    public int BlockID;

    public BlockPureColour(int id, String name) {
        super(id, Material.rock, name);
        setHardness(0.1f);
        this.BlockID = id;
        setCreativeTab(ElementalSciences.miscTab);
    }

    public Icon[] icons;

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return this.icons[par2 % this.icons.length];
    }

    public static int getDyeFromBlock(int par0) {
        return ~par0 & 15;
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < 16; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        icons = new Icon[16];
        for (int i = 0; i < icons.length; i++) {
            // System.out.println(Reference.MOD_ID.toLowerCase() + ":" +
            // (this.getUnlocalizedName().replace("tile.", "")) + i );
            icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "colour/" + (this.getUnlocalizedName().replace("tile.", "")) + "_" + (ItemDye.dyeColorNames[i]));
        }
    }
}