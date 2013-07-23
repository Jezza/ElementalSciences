package me.jezzadabomb.es.blocks;

import java.util.Random;
import me.jezzadabomb.es.lib.Strings;
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
    
    Icon blockIcon;
    
    public BlockChamber(int BlockID, String BlockName)
    {
        super(BlockID, Material.anvil);
        if(BlockName == Strings.CHAMBER_WALL){
            setHardness(5.0f);
            setResistance(20.0f);
        }else if(BlockName == Strings.ST_CHAMBER_WALL){
            setHardness(12.5f);
            setResistance(500.0f);
        }else if(BlockName == Strings.RE_CHAMBER_WALL){
            setHardness(20.0f);
            setResistance(2000.0f);
        }
        setStepSound(soundStoneFootstep);
        setUnlocalizedName(BlockName);
        this.BlockID = BlockID;
    }

//    @Override
//    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
//        world.setBlock(x, y, z, BlockID);
//    }
    
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return BlockID;
    }
    
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void registerIcons(IconRegister iconRegister) {
//        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().replace("tile.", ""));
//    }
}
