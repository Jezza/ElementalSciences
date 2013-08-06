package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.blocks.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.tileentity.TileLinearEmitter;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLinearEmitter extends BlockESContainer implements PipeComponent {

    public Icon face;
    public Icon other;
    
    public BlockLinearEmitter(int id, String name) {
        super(id, Material.anvil);
        setUnlocalizedName(name);
    }
    
    @Override
    public Icon getIcon(int side, int metadata)
    {
        int facing = (metadata & MASK_DIR);
        if(side == getSideFromFacing(facing)){
            return face;
        }
        return other;
    }
    
    private static int getSideFromFacing(int facing)
    {
        switch(facing)
        {
        case META_DIR_WEST:
            return 4;
            
        case META_DIR_EAST:
            return 5;
            
        case META_DIR_NORTH:
            return 2;
            
        case META_DIR_SOUTH:
            return 3;
            
        default:
            return 4;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        face = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_face");
        other = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")));
    }
    
    @Override
    public PipeComponentType getIonComponentType() {
        return PipeComponentType.SOURCE;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        int facing = (w.getBlockMetadata(x, y, z) & MASK_DIR);
        if(side == getSideFromFacing(facing)){
            return true;
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileLinearEmitter();
    }    
}
