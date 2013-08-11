package me.jezzadabomb.es.blocks;

import java.util.List;

import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChamber extends BlockES {
    public boolean setOutput = false;

    public int Tmeta = 4;
    
    public Icon[] cticons = new Icon[Tmeta];
    
    Icon blockIcon;

    public BlockChamber(int BlockID, String name) {
        super(BlockID, Material.anvil, name);
        setHardness(5.0f);
        setResistance(20.0f);
        setStepSound(soundStoneFootstep);
    }
    
    public Icon[] icons;

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return this.cticons[meta];
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < Tmeta; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @Override
    public Icon getBlockTexture(IBlockAccess w, int x, int y, int z, int par5) {
        return cticons[w.getBlockMetadata(x, y, z)];
    }
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        cticons[0] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL);
        cticons[1] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL);
        cticons[2] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL);
        cticons[3] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING);
    }
}
