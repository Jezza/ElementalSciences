package me.jezzadabomb.es.blocks;

import java.util.List;

import me.jezzadabomb.es.items.ItemBlockChamber;
import me.jezzadabomb.es.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChamber extends BlockES {
    public boolean setOutput = false;

    Icon blockIcon;

    public BlockChamber(int BlockID, String name) {
        super(BlockID, Material.anvil);
        setHardness(5.0f);
        setResistance(20.0f);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(name);
    }

    public Icon[] icons;

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return (meta == 3) ? (side == 1) ? this.icons[meta % this.icons.length] : this.icons[0 % this.icons.length] : this.icons[meta % this.icons.length];
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            return false;
        }

        if (world.getBlockMetadata(x, y, z) == 3) {

        } else {
            return false;
        }
        return true;
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < 4; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        icons = new Icon[4];
        for (int i = 0; i < icons.length; i++) {
            // System.out.println(Reference.MOD_ID.toLowerCase() + ":" +
            // (this.getUnlocalizedName().replace("tile.", "")) + i );
            icons[i] = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_" + (ItemBlockChamber.chamberNames[i]));
        }
    }
}
