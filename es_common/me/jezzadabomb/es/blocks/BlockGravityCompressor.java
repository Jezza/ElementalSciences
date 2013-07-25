package me.jezzadabomb.es.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGravityCompressor extends BlockPadBase {

    public Icon walls;
    public Icon top;
    public Icon bottom;

    public BlockGravityCompressor(int id) {
        super(id, Material.anvil);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        setUnlocalizedName(Strings.GRAVITY_COMPRESSOR);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
        onActive(world, x, y, z, player);
        return true;
    }

    @Override
    protected AxisAlignedBB getSensitiveAABB(int par1, int par2, int par3) {
        float f = 4F;
        double h = 4D;
        return AxisAlignedBB.getAABBPool().getAABB((double) ((float) par1 + f), (double) par2, (double) ((float) par3 + f), (double) ((float) (par1 + 1) - f), (double) par2 + h, (double) ((float) (par3 + 1) - f));
    }

    @Override
    protected void onActive(World world, int x, int y, int z, Entity entity) {
        if (entity != null) {
            System.out.println("Yes");
            applyMotion(entity, 0, 1, 0, true);
        }
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Entity getEntity(World world, int x, int y, int z) {
        List list = null;
        list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, this.getSensitiveAABB(x, y, z));
        //System.out.println(list.toString());
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

    public void applyMotion(Entity entity, double velX, double velY, double velZ, boolean set) {
        if (set) {
            printDebug("Setting Motion: VelX: " + velX + ". VelY: " + velY + ". VelZ: " + velZ);
            entity.setVelocity(velX, velY, velZ);
        } else {
            printDebug("Adding Motion: VelX: " + velX + ". VelY: " + velY + ". VelZ: " + velZ);
            double motionX = entity.motionX + velX;
            double motionY = entity.motionY + velY;
            double motionZ = entity.motionZ + velZ;
            entity.setVelocity(0, 0, 0);
            entity.setVelocity(motionX, motionY, motionZ);
        }
        entity.velocityChanged = true;
        entity.fallDistance = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return (par1 ==1) ? this.top : (par1 == 0) ? super.defaultIron : this.walls;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        walls = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_walls");
        top = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random par5Random) {
        int height = 3;
        for(int i = 0; i < 6; ++i){
            double d0 = (double) ((float) x + par5Random.nextFloat());
            double d1 = (double) ((float) y + height);
            double d2 = (double) ((float) z + par5Random.nextFloat());
            double d3 = -height;
            
            world.spawnParticle("portal", d0, d1, d2, 0, d3, 0);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() // Put 0 for fully transparent or opaque
                                    // blocks, and 1 for semi-transparent
    {
        return 1;
    }
}
