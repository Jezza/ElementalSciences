package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.core.util.ESLogger;
import me.jezzadabomb.es.core.util.IconRegistry;
import me.jezzadabomb.es.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockES extends Block {

    protected Icon[] override = new Icon[6];
    protected boolean isOverride = false;

    protected ESLogger log = new ESLogger();

    public BlockES(int id, Material material, String name) {
        super(id, material);
        setHardness(0.5f);
        setUnlocalizedName(name);
        setCreativeTab(ElementalSciences.machineTab);
    }

    public void printDebug(String msg) {
        log.print(msg, 4);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        if (isOverride)
            return override[side];
        else
            return getTextureFromSide(side, metadata);
    }

    public Icon getTextureFromSide(int side, int meta) {
        return getTextureFromSide(side);
    }

    public Icon getTextureFromSide(int side) {
        return getTexture();
    }

    public Icon getTexture() {
        return this.blockIcon;
    }

    public void overrideTextures(Icon[] tmap) {
        isOverride = true;
        override = tmap;
    }

    public void restoreTextures() {
        isOverride = false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        IconRegistry.instance.loadAllBlocks(iconRegister);
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().replace("tile.", ""));
    }
}
