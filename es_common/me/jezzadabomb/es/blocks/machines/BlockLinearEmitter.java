package me.jezzadabomb.es.blocks.machines;

import me.jezzadabomb.es.api.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.blocks.BlockESContainer;
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
        super(id, Material.anvil,name);
    }
    
    @Override
    public Icon getIcon(int side, int metadata)
    {
        if(side == metadata){
            return face;
        }
        return other;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        face = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_face");
        other = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")));
    }
    
    @Override
    public PipeComponentType getPipeComponentType() {
        return PipeComponentType.SOURCE;
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        int metadata = w.getBlockMetadata(x, y, z);
        if(side == metadata){
            return true;
        }
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileLinearEmitter();
    }    
}
