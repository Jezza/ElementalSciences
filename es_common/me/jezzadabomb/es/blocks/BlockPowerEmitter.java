package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.api.BlockPowerComponent.PowerComponent;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import me.jezzadabomb.es.tileentity.TilePowerEmitter;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPowerEmitter extends BlockESContainer implements PowerComponent {

    @SideOnly(Side.CLIENT)
    private Icon other, face;
    
    public BlockPowerEmitter(int id, String name) {
        super(id, Material.iron, name);
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6)
    {
        TilePowerEmitter dummy = (TilePowerEmitter)world.getBlockTileEntity(x, y, z);
        
        if(dummy != null && dummy.getCore() != null)
            dummy.getCore().invalidateMultiblock();
        super.breakBlock(world, x, y, z, par5, par6);
    }
    
    @Override
    public Icon getIcon(int side, int metadata) {
        if(side == metadata){
            return face;
        }
        return other;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        other = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (Strings.DEFAULT_CHAMBER_TEXTURE));
        face = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_face");
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TilePowerEmitter();
    }

    @Override
    public PowerComponentType getPowerComponentType() {
        return PowerComponentType.SOURCE;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        if(side == w.getBlockMetadata(x, y, z)){
            return true;
        }
        return false;
    }
    
}
