package me.jezzadabomb.es.blocks;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
    
    public double MaxXVel = 3;
    public double MaxZVel = 3;
    public double MaxYVel = 1;
    public double MinXVel = -1;
    public double MinZVel = -1;
    public double MinYVel = -1;
    
    
    public BlockGravityCompressor(int id) {
        super(id, Material.anvil);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        setUnlocalizedName(Strings.GRAVITY_COMPRESSOR);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }

    @Override
    public AxisAlignedBB getSensitiveAABB(int par1, int par2, int par3) {
        float f = 0.5F;
        double h = 4D;
        return AxisAlignedBB.getAABBPool().getAABB((double) ((float) par1 + f), (double) par2, (double) ((float) par3 + f), (double) ((float) (par1 + 1) - f), (double) par2 + h, (double) ((float) (par3 + 1) - f));
    }

    @Override
    public void onActive(World world, int x, int y, int z, Entity entity) {
        if (entity != null) {
            applyMotion(entity, 0, entity.motionY / 2, 0, false);
        }
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Entity getEntity(World world, int x, int y, int z) {
        List list = null;
        // list = world.getEntitiesWithinAABB(EntityLivingBase.class, this.getSensitiveAABB(x, y, z));
        list = world.getEntitiesWithinAABB(Entity.class, this.getSensitiveAABB(x, y, z));
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
        
        printDebug(String.valueOf(entity.motionX));
        printDebug(String.valueOf(entity.motionY));
        printDebug(String.valueOf(entity.motionZ));
        
        if (set) {
            entity.setVelocity(velX, velY, velZ);
        } else {
            double motionY = entity.motionY;
            double motionX = entity.motionX;
            double motionZ = entity.motionZ;
            
            
            if(motionY > MaxYVel){
                motionY = MaxYVel;
            }
            if(motionX > MaxXVel){
                motionX = MaxXVel;
            }
            if(motionZ > MaxZVel){
                motionZ = MaxZVel;
            }
            
            if(motionY < MinYVel){
                motionY = MinYVel;
            }
            if(motionX < MinXVel){
                motionX = MinXVel;
            }
            if(motionZ < MinZVel){
                motionZ = MinZVel;
            }
            
            if(motionY < 0){
                System.out.println("Y Motion < 0");
                entity.setVelocity(motionX * 2, motionY + 0.2, motionZ * 2);
            }else if(motionY > 0){
                System.out.println("Y Motion > 0");
                entity.setVelocity(motionX * 2, motionY + 0.2, motionZ * 2);
            }else{
                System.out.println("Y Motion is 0");
                entity.setVelocity(motionX *2, motionY + 0.2, motionZ * 2);
            }
        }
        entity.velocityChanged = true;
        entity.fallDistance = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return (par1 == 1) ? this.top : (par1 == 0) ? this.bottom : this.walls;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        walls = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_walls");
        top = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
        bottom = iconReg.registerIcon(Reference.MOD_ID + ":" + Strings.DEFAULT_CHAMBER_TEXTURE);
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
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() // Put 0 for fully transparent or opaque
                                    // blocks, and 1 for semi-transparent
    {
        return 1;
    }
}
