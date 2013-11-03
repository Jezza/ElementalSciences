package me.jezzadabomb.es.common.machines;

import java.util.Random;

import me.jezzadabomb.es.common.ModBlocks;
import me.jezzadabomb.es.common.api.BlockES;
import me.jezzadabomb.es.common.api.BlockESContainer;
import me.jezzadabomb.es.common.lib.Reference;
import me.jezzadabomb.es.common.lib.Textures;
import me.jezzadabomb.es.common.tileentity.TileGravCompressor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGravityCompressor extends BlockESContainer {

    public Icon walls;
    public Icon top;
    public Icon bottom;

    public BlockGravityCompressor(int id, String name) {
        super(id, Material.anvil, name);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return (par1 == 1) ? this.top : (par1 == 0) ? this.bottom : this.walls;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        walls = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_walls");
        top = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
        bottom = iconReg.registerIcon(Reference.MOD_ID + ":" + Textures.DEFAULT_CHAMBER_TEXTURE);
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
        updateGravForce(world, x, y, z);
        super.breakBlock(world, x, y, z, par5, par6);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int par5) {
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if ((te != null) && ((te instanceof TileGravCompressor))) {
            updateGravForce(world, x, y, z);
        }
        super.onNeighborBlockChange(world, x, y, z, par5);
    }

    private void updateGravForce(World worldObj, int xCoord, int yCoord, int zCoord) {
        int count = 1;
        while (worldObj.getBlockId(xCoord, yCoord - count, zCoord) == ModBlocks.gravCompressor.blockID) {
            TileEntity te = worldObj.getBlockTileEntity(xCoord, yCoord - count, zCoord);
            if ((te != null) && ((te instanceof TileGravCompressor)))
                ((TileGravCompressor) te).requiresUpdate = true;
            count++;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random par5Random) {
        int height = 3;
        for (int i = 0; i < 6; ++i) {
            double d0 = (double) ((float) x + par5Random.nextFloat());
            double d1 = (double) ((float) y + height);
            double d2 = (double) ((float) z + par5Random.nextFloat());
            double d3 = -height;
            world.spawnParticle("portal", d0, d1, d2, 0, d3, 0);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileGravCompressor();
    }
}
