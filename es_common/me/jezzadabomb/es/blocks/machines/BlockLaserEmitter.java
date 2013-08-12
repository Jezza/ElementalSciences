package me.jezzadabomb.es.blocks.machines;

import me.jezzadabomb.es.ElementalSciences;
import me.jezzadabomb.es.common.BlockPowerComponent.PowerComponent;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.renderers.RenderLaserEmitter;
import me.jezzadabomb.es.tileentity.TileLaserEmitter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.common.ForgeDirection;

public class BlockLaserEmitter extends BlockContainer implements PowerComponent{
    
    @SideOnly(Side.CLIENT)
    private Icon textureTop, textureBottom, textureSide;
    
    public BlockLaserEmitter(int id, String name) {
        super(id, Material.iron);
        setHardness(0.5F);
        setUnlocalizedName(name);
        setCreativeTab(ElementalSciences.machineTab);
    }
    
    @Override
    public int getRenderType() {
        return RenderLaserEmitter.instance().getRenderId();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileLaserEmitter();
    }
    
    @Override
    public Icon getIcon(int i, int j) {
        if (i == ForgeDirection.values()[j].getOpposite().ordinal())
            return textureBottom;
        else if (i == j)
            return textureTop;
        else
            return textureSide;

    }
    
    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float par6, float par7, float par8, int meta) {
        super.onBlockPlaced(world, x, y, z, side, par6, par7, par8, meta);

        if (side <= 6) {
            meta = side;
        }

        return meta;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        textureTop = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
        textureBottom = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_bottom");
        textureSide = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_side");
    }

    @Override
    public PowerComponentType getPowerComponentType() {
        return PowerComponentType.COLLECTOR;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        if(w.getBlockMetadata(x, y, z) == ForgeDirection.values()[side].getOpposite().ordinal()){
            return true;
        }
        return false;
    }
    
}
