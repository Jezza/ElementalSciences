package me.jezzadabomb.es.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


public class BlockChamber extends BlockES
{

    public int MetaBlock;
    public int BlockID;
    public World world;
    public int x; 
    public int y; 
    public int z; 
    public boolean setOutput = false;
    public boolean check[] = new boolean[9];
    
    Icon blockIcon_middle;
    Icon blockIcon_middle_top;
    Icon blockIcon_middle_top_left;
    Icon blockIcon_middle_top_right;
    Icon blockIcon_middle_top_bottom;
    Icon blockIcon_middle_bottom;
    Icon blockIcon_middle_bottom_left;
    Icon blockIcon_middle_bottom_right;
    Icon blockIcon_middle_left;
    Icon blockIcon_middle_right;
    
    public BlockChamber(int BlockID, String BlockName)
    {
        super(BlockID, Material.wood);
        setHardness(2.0f);
        setResistance(2000.0f);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(BlockName);
        this.BlockID = BlockID;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        world.setBlock(x, y, z, BlockID);
    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return BlockID;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName2());
    }
    
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return blockIcon;
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
