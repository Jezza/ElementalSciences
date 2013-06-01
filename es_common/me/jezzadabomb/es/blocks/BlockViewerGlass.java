package me.jezzadabomb.es.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockViewerGlass extends BlockES
{	
	public BlockViewerGlass(int BlockID, String BlockName)
	{
		super(BlockID, Material.wood);
		setHardness(2.0f);
        setResistance(5.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(ElementalSciences.tabsES);
        setUnlocalizedName(BlockName);
	}
	
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() //Put 0 for fully transparent or opaque blocks, and 1 for semi-transparent
	{
	         return 0;
	}

	public boolean isOpaqueCube() //Tells the game if the block is transparent
	{
	         return false;
	}

	public boolean renderAsNormalBlock() //Tells the game how to render the block
	{
	         return false;
	}
	
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) //Renders neighbouring blocks
	{

	int i = par1IBlockAccess.getBlockId(par2, par3, par4);

	return i == blockID ? false:true;
	}
}
