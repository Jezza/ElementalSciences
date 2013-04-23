package me.jezzadabomb.es;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class TileMultiBlockMachine extends Block
{

	public int MetaBlock;
	public int BlockID;
	public boolean setOutput = false;
	public boolean check[] = new boolean[9];
	
	public TileMultiBlockMachine(int BlockID, String BlockName, int TextureID, int MetaBlock)
	{
		super(BlockID, Material.wood);
		setHardness(2.0f);
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(ElementalSciences.tabGeneMachines);
        this.MetaBlock = MetaBlock;
        this.BlockID = BlockID;
	}
	
	public int grabXNeighbour(int x, int side){
		switch (side) {
		    case 4:
		      return x - 1;
		    case 5:
		      return x + 1;
		}
		return x;
	}
	
	public int grabYNeighbour(int y, int side){
		
		switch (side) {
		    case 0:
		      return y - 1;
		    case 1:
		      return y + 1;
		}
		return y;
	}

	public int grabZNeighbour(int z, int side){
	
		switch (side) {
			case 2:
				return z - 1;
			case 3:
				return z + 1;
		}
		return z;
	}
	
	public boolean grabNeighbourID(World world, int x, int y, int z, int side){
		switch(side){
			case 0:
				if (world.getBlockId(x, y + 1, z) == ElementalSciences.geneChamber.blockID) {
					return true;
				} else {
					return false;
				}
			case 1:
				if (world.getBlockId(x, y - 1, z) == ElementalSciences.geneChamber.blockID) {
					return true;
				} else {
					return false;
				}
			case 2:
				if (world.getBlockId(x + 1, y, z) == ElementalSciences.geneChamber.blockID) {
					return true;
				} else {
					return false;
				}
			case 3:
				if (world.getBlockId(x - 1, y, z) == ElementalSciences.geneChamber.blockID) {
					return true;
				} else {
					return false;
				}
			case 4:
				if (world.getBlockId(x, y, z + 1) == ElementalSciences.geneChamber.blockID) {
					return true;
				} else {
					return false;
				}
			case 5:
				if (world.getBlockId(x, y, z + 1) == ElementalSciences.geneChamber.blockID) {
					return true;
				} else {
					return false;
				}
		}
		return false;
	}
	
	public boolean getId(World world,int x, int y, int z){
		if(world.getBlockId(x,y,z) == ElementalSciences.geneChamber.blockID){
			return true;
		}
		return false;
	}

	

	public void print(int msg){
		System.out.println(msg);
	}
	
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
		if (MetaBlock == 4){
			return ElementalSciences.geneChamber.blockID;
		}else{
			return BlockID;
		}
    }
	
	public void updateIcons(IconRegister iconRegister)
	{
	         blockIcon = iconRegister.registerIcon("ElementalScience:Machines");
	}
	
	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity entity) {
		if (this.MetaBlock == 4){
			setOutput = true;
			if(entity instanceof EntityLiving){
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.invisibility.getId(),200,10));
				((EntityLiving)entity).addPotionEffect(new PotionEffect(Potion.jump.getId(),200,10));
			}
		}else{
			setOutput = false;
		}
	}
}
