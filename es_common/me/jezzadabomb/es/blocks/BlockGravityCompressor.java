package me.jezzadabomb.es.blocks;

import java.util.Random;

import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGravityCompressor extends BlockES {
    
    public Icon walls;
    public Icon top;
    public Icon bottom;
    
    public BlockGravityCompressor(int id) {
        super(id, Material.anvil);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        setUnlocalizedName(Strings.GRAVITY_COMPRESSOR);
    }
    
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        if(par1 == 1){
            return this.top;
        }else if(par1 == 0){
            return this.bottom;
        }else{
            return this.walls;
        }
        
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg){
        walls = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_walls");
        top = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
        bottom = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Strings.CHAMBER_WALL + "_de");
    }
    
    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        for(int i = 1; i < 20; ++i){
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + 4);
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            double d3 = 0.0D;
            double d4 = -4.0D;
            double d5 = 0.0D;
//            d3 = ((double)par5Random.nextFloat() - 0.5D) * i;
//            d4 = ((double)par5Random.nextFloat() - 0.5D) * i;
//            d5 = ((double)par5Random.nextFloat() - 0.5D) * i;
            
            par1World.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() //Put 0 for fully transparent or opaque blocks, and 1 for semi-transparent
    {
             return 1;
    }

    public boolean isOpaqueCube() //Tells the game if the block is transparent
    {
             return false;
    }
    
    public boolean renderAsNormalBlock() //Tells the game how to render the block
    {
             return false;
    }
}
