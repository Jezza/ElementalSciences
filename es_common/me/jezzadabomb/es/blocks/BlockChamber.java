package me.jezzadabomb.es.blocks;
import java.util.Random;

import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;


public class BlockChamber extends BlockES
{

    public int MetaBlock;
    public int BlockID;
    public boolean setOutput = false;
    public boolean check[] = new boolean[9];
    
    public BlockChamber(int BlockID, String BlockName)
    {
        super(BlockID, Material.wood);
        setHardness(2.0f);
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(Strings.CHAMBER_WALL);
        this.BlockID = BlockID;
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return BlockID;
    }
    
    @Override
    public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity entity) {
//        if (this.MetaBlock == 4){
//            setOutput = true;
//            if(entity instanceof EntityLiving){
//                ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.invisibility.getId(),200,10));
//                ((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.jump.getId(),200,10));
//            }
//        }else{
//            setOutput = false;
//        }
    }
}
