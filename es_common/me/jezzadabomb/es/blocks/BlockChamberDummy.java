package me.jezzadabomb.es.blocks;

import java.util.List;

import me.jezzadabomb.es.lib.BlockIds;
import me.jezzadabomb.es.lib.Reference;
import me.jezzadabomb.es.lib.Strings;
import me.jezzadabomb.es.tileentity.TileChamberDummy;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChamberDummy extends BlockESContainer {
    public boolean setOutput = false;

    public int Tmeta = 4;
    
    public Icon[][] cticons = new Icon[Tmeta][16];
    
    Icon blockIcon;

    public BlockChamberDummy(int BlockID, String name) {
        super(BlockID, Material.anvil, name);
        setHardness(5.0f);
        setResistance(20.0f);
        setStepSound(soundStoneFootstep);
        setCreativeTab(null);
    }
    
    @Override
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return BlockIds.CHAMBER_BLOCK_DEFAULT;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6)
    {
        TileChamberDummy dummy = (TileChamberDummy)world.getBlockTileEntity(x, y, z);
        
        if(dummy != null && dummy.getCore() != null)
            dummy.getCore().invalidateMultiblock();
        
        super.breakBlock(world, x, y, z, par5, par6);
    }
    
    public Icon[] icons;

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return this.cticons[meta][0];
    }

    @Override
    public int damageDropped(int par1) {
        return par1;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void getSubBlocks(int id, CreativeTabs creativeTab, List list) {
        for (int i = 0; i < Tmeta; i++) {
            list.add(new ItemStack(id, 1, i));
        }
    }

    
    public boolean shouldConnectToBlock(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, int par6) {
        if(par6 == par1IBlockAccess.getBlockMetadata(par2, par3, par4)){
            return par5 == this.blockID;
        }
        return false;
    }

    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        return getConnectedBlockTexture(par1IBlockAccess, par2, par3, par4, par5, icons);
    }

    public Icon getConnectedBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5, Icon[] icons) {
        boolean isOpenUp = false, isOpenDown = false, isOpenLeft = false, isOpenRight = false;
        int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
        switch (par5) {
            case 0:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return cticons[meta][11];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return cticons[meta][12];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return cticons[meta][13];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][14];
                } else if (isOpenDown && isOpenUp) {
                    return cticons[meta][5];
                } else if (isOpenLeft && isOpenRight) {
                    return cticons[meta][6];
                } else if (isOpenDown && isOpenLeft) {
                    return cticons[meta][8];
                } else if (isOpenDown && isOpenRight) {
                    return cticons[meta][10];
                } else if (isOpenUp && isOpenLeft) {
                    return cticons[meta][7];
                } else if (isOpenUp && isOpenRight) {
                    return cticons[meta][9];
                } else if (isOpenDown) {
                    return cticons[meta][3];
                } else if (isOpenUp) {
                    return cticons[meta][4];
                } else if (isOpenLeft) {
                    return cticons[meta][2];
                } else if (isOpenRight) {
                    return cticons[meta][1];
                }
                break;
            case 1:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return cticons[meta][11];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return cticons[meta][12];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return cticons[meta][13];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][14];
                } else if (isOpenDown && isOpenUp) {
                    return cticons[meta][5];
                } else if (isOpenLeft && isOpenRight) {
                    return cticons[meta][6];
                } else if (isOpenDown && isOpenLeft) {
                    return cticons[meta][8];
                } else if (isOpenDown && isOpenRight) {
                    return cticons[meta][10];
                } else if (isOpenUp && isOpenLeft) {
                    return cticons[meta][7];
                } else if (isOpenUp && isOpenRight) {
                    return cticons[meta][9];
                } else if (isOpenDown) {
                    return cticons[meta][3];
                } else if (isOpenUp) {
                    return cticons[meta][4];
                } else if (isOpenLeft) {
                    return cticons[meta][2];
                } else if (isOpenRight) {
                    return cticons[meta][1];
                }
                break;
            case 2:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return cticons[meta][13];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return cticons[meta][14];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return cticons[meta][11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][12];
                } else if (isOpenDown && isOpenUp) {
                    return cticons[meta][6];
                } else if (isOpenLeft && isOpenRight) {
                    return cticons[meta][5];
                } else if (isOpenDown && isOpenLeft) {
                    return cticons[meta][9];
                } else if (isOpenDown && isOpenRight) {
                    return cticons[meta][10];
                } else if (isOpenUp && isOpenLeft) {
                    return cticons[meta][7];
                } else if (isOpenUp && isOpenRight) {
                    return cticons[meta][8];
                } else if (isOpenDown) {
                    return cticons[meta][1];
                } else if (isOpenUp) {
                    return cticons[meta][2];
                } else if (isOpenLeft) {
                    return cticons[meta][4];
                } else if (isOpenRight) {
                    return cticons[meta][3];
                }
                break;
            case 3:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 - 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 - 1, par3, par4))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2 + 1, par3, par4), par1IBlockAccess.getBlockMetadata(par2 + 1, par3, par4))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return cticons[meta][14];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return cticons[meta][13];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return cticons[meta][11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][12];
                } else if (isOpenDown && isOpenUp) {
                    return cticons[meta][6];
                } else if (isOpenLeft && isOpenRight) {
                    return cticons[meta][5];
                } else if (isOpenDown && isOpenLeft) {
                    return cticons[meta][10];
                } else if (isOpenDown && isOpenRight) {
                    return cticons[meta][9];
                } else if (isOpenUp && isOpenLeft) {
                    return cticons[meta][8];
                } else if (isOpenUp && isOpenRight) {
                    return cticons[meta][7];
                } else if (isOpenDown) {
                    return cticons[meta][1];
                } else if (isOpenUp) {
                    return cticons[meta][2];
                } else if (isOpenLeft) {
                    return cticons[meta][3];
                } else if (isOpenRight) {
                    return cticons[meta][4];
                }
                break;
            case 4:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return cticons[meta][14];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return cticons[meta][13];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return cticons[meta][11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][12];
                } else if (isOpenDown && isOpenUp) {
                    return cticons[meta][6];
                } else if (isOpenLeft && isOpenRight) {
                    return cticons[meta][5];
                } else if (isOpenDown && isOpenLeft) {
                    return cticons[meta][10];
                } else if (isOpenDown && isOpenRight) {
                    return cticons[meta][9];
                } else if (isOpenUp && isOpenLeft) {
                    return cticons[meta][8];
                } else if (isOpenUp && isOpenRight) {
                    return cticons[meta][7];
                } else if (isOpenDown) {
                    return cticons[meta][1];
                } else if (isOpenUp) {
                    return cticons[meta][2];
                } else if (isOpenLeft) {
                    return cticons[meta][3];
                } else if (isOpenRight) {
                    return cticons[meta][4];
                }
                break;
            case 5:
                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 - 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4))) {
                    isOpenDown = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3 + 1, par4), par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4))) {
                    isOpenUp = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 - 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 - 1))) {
                    isOpenLeft = true;
                }

                if (shouldConnectToBlock(par1IBlockAccess, par2, par3, par4, par1IBlockAccess.getBlockId(par2, par3, par4 + 1), par1IBlockAccess.getBlockMetadata(par2, par3, par4 + 1))) {
                    isOpenRight = true;
                }

                if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][15];
                } else if (isOpenUp && isOpenDown && isOpenLeft) {
                    return cticons[meta][13];
                } else if (isOpenUp && isOpenDown && isOpenRight) {
                    return cticons[meta][14];
                } else if (isOpenUp && isOpenLeft && isOpenRight) {
                    return cticons[meta][11];
                } else if (isOpenDown && isOpenLeft && isOpenRight) {
                    return cticons[meta][12];
                } else if (isOpenDown && isOpenUp) {
                    return cticons[meta][6];
                } else if (isOpenLeft && isOpenRight) {
                    return cticons[meta][5];
                } else if (isOpenDown && isOpenLeft) {
                    return cticons[meta][9];
                } else if (isOpenDown && isOpenRight) {
                    return cticons[meta][10];
                } else if (isOpenUp && isOpenLeft) {
                    return cticons[meta][7];
                } else if (isOpenUp && isOpenRight) {
                    return cticons[meta][8];
                } else if (isOpenDown) {
                    return cticons[meta][1];
                } else if (isOpenUp) {
                    return cticons[meta][2];
                } else if (isOpenLeft) {
                    return cticons[meta][4];
                } else if (isOpenRight) {
                    return cticons[meta][3];
                }
                break;
        }

        return cticons[meta][0];
    }
    
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconReg) {
        cticons[0][0] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL);
        cticons[0][1] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_D);
        cticons[0][2] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_U);
        cticons[0][3] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_L);
        cticons[0][4] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_R);
        cticons[0][5] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_H);
        cticons[0][6] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_V);
        cticons[0][7] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_DL);
        cticons[0][8] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_DR);
        cticons[0][9] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_UL);
        cticons[0][10] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_UR);
        cticons[0][11] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_SD);
        cticons[0][12] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_SU);
        cticons[0][13] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_SL);
        cticons[0][14] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_SR);
        cticons[0][15] = iconReg.registerIcon(Reference.MOD_ID + ":ct/cw/" + Strings.CHAMBER_WALL_P);
        
        cticons[1][0] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL);
        cticons[1][1] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_D);
        cticons[1][2] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_U);
        cticons[1][3] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_L);
        cticons[1][4] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_R);
        cticons[1][5] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_H);
        cticons[1][6] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_V);
        cticons[1][7] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_DL);
        cticons[1][8] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_DR);
        cticons[1][9] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_UL);
        cticons[1][10] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_UR);
        cticons[1][11] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_SD);
        cticons[1][12] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_SU);
        cticons[1][13] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_SL);
        cticons[1][14] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_SR);
        cticons[1][15] = iconReg.registerIcon(Reference.MOD_ID + ":ct/scw/" + Strings.ST_CHAMBER_WALL_P);
        
        cticons[2][0] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL);
        cticons[2][1] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_D);
        cticons[2][2] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_U);
        cticons[2][3] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_L);
        cticons[2][4] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_R);
        cticons[2][5] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_H);
        cticons[2][6] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_V);
        cticons[2][7] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_DL);
        cticons[2][8] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_DR);
        cticons[2][9] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_UL);
        cticons[2][10] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_UR);
        cticons[2][11] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_SD);
        cticons[2][12] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_SU);
        cticons[2][13] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_SL);
        cticons[2][14] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_SR);
        cticons[2][15] = iconReg.registerIcon(Reference.MOD_ID + ":ct/rcw/" + Strings.RE_CHAMBER_WALL_P);
        
        cticons[3][0] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING);
        cticons[3][1] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_D);
        cticons[3][2] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_U);
        cticons[3][3] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_L);
        cticons[3][4] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_R);
        cticons[3][5] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_H);
        cticons[3][6] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_V);
        cticons[3][7] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_DL);
        cticons[3][8] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_DR);
        cticons[3][9] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_UL);
        cticons[3][10] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_UR);
        cticons[3][11] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_SD);
        cticons[3][12] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_SU);
        cticons[3][13] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_SL);
        cticons[3][14] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_SR);
        cticons[3][15] = iconReg.registerIcon(Reference.MOD_ID + ":ct/casing/" + Strings.CHAMBER_CASING_P);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileChamberDummy();
    }
}
