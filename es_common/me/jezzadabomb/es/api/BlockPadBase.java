package me.jezzadabomb.es.api;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import me.jezzadabomb.es.blocks.BlockES;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class BlockPadBase extends BlockES {
    private String pressurePlateIconName;

    protected BlockPadBase(int par1, Material par3Material, String name) {
        super(par1, par3Material, name);
    }

    /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World) {
        return 1;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube? This determines whether
     * or not to render the shared face of two adjacent blocks and also whether
     * the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False
     * (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
        return true;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random par5Random) {
        if (!world.isRemote) {
            Entity entity = getEntity(world, x, y, z);
            this.onActive(world, x, y, z, entity);
        }
    }

    public abstract void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity);

    public abstract void onActive(World world, int x, int y, int z, Entity entity);

    public abstract AxisAlignedBB getSensitiveAABB(int par1, int par2, int par3);

    public int getMobilityFlag() {
        return 2;
    }
    @SuppressWarnings("rawtypes")
    protected Entity getEntity(World world, int x, int y, int z) {
        List list = null;
        list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, this.getSensitiveAABB(x, y, z));
        if (list != null && !list.isEmpty()) {
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                Entity entity = (Entity) iterator.next();

                if (!entity.doesEntityNotTriggerPressurePlate()) {
                    return entity;
                }
            }
        }

        return null;
    }

    @SideOnly(Side.CLIENT)
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(this.pressurePlateIconName);
    }
}
