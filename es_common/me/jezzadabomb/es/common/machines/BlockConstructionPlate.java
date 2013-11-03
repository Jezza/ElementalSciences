package me.jezzadabomb.es.common.machines;

import me.jezzadabomb.es.common.api.BlockESContainer;
import me.jezzadabomb.es.common.lib.Reference;
import me.jezzadabomb.es.common.lib.Textures;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockConstructionPlate extends BlockESContainer{
    
    public Icon walls;
    public Icon top;
    public Icon bottom;
    
    public BlockConstructionPlate(int id, String name) {
        super(id, Material.iron,name);
        setBlockBounds(0.0F, 0.25F, 0.0F, 1.0F, 0.75F, 1.0F);
    }
    
    public boolean isOpaqueCube() {
        return false;
    }
    
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2) {
        return (par1 == 1) ? this.top : (par1 == 0) ? this.bottom : this.walls;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        walls = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_walls");
        top = iconReg.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().replace("tile.", "")) + "_top");
        bottom = iconReg.registerIcon(Reference.MOD_ID + ":" + Textures.DEFAULT_CHAMBER_TEXTURE);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }
}
