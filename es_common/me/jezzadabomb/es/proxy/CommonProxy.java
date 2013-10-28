package me.jezzadabomb.es.proxy;

import me.jezzadabomb.es.tileentity.TileChamberDummy;
import me.jezzadabomb.es.tileentity.TileConstructionPlate;
import me.jezzadabomb.es.tileentity.TileLaserEmitter;
import me.jezzadabomb.es.tileentity.TileLinearEmitter;
import me.jezzadabomb.es.tileentity.TilePowerEmitter;
import me.jezzadabomb.es.tileentity.TileResearchTable;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void runClientSide() {
    };

    public void startChain(EntityPlayer player, World world, int x, int y, int z, int id, int meta, int size){
        Block block = Block.blocksList[world.getBlockId(x, y, z)];
        boolean creative = player.capabilities.isCreativeMode;
        for(int xCoord=-(size / 2);xCoord<(size / 2) + 1;xCoord++){
            for(int zCoord=-(size/2);zCoord<(size / 2) + 1;zCoord++){
                for(int yCoord=-(size/2);yCoord<(size / 2) + 1;yCoord++){
                    int xPos = x + xCoord;
                    int yPos = y + yCoord;
                    int zPos = z + zCoord;
                    
                    int compareID = world.getBlockId(xPos, yPos, zPos);
                    int compareMeta = world.getBlockMetadata(xPos, yPos, zPos);
                    
                    System.out.println(compareID);
                    System.out.println(compareMeta);
                    if(compareID == id && compareMeta == meta){
                        //System.out.println("X: " + xCoord + " Y: " + yCoord + " Z: " + zCoord);
                        if(yPos < 0)yPos = 0;
                        if (block.removeBlockByPlayer(world, player, xPos, yPos, zPos))
                        {
                           block.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, compareMeta);
                        }
                        if(!creative){
                            block.harvestBlock(world, player, xPos, yPos, zPos, compareMeta);    
                        }else{
                            world.setBlockToAir(xPos, yPos, zPos);
                        }
                        block.onBlockHarvested(world, xPos, yPos, zPos, compareMeta, player);
                    }
                }
            }
        }
    };
    
    public void beginSelection(EntityPlayer player, World world, int firstXPos, int firstYPos, int firstZPos, int secondXPos, int secondYPos, int secondZPos){
        
    }
    
    public void registerTileEntities() {
        GameRegistry.registerTileEntity(TileLinearEmitter.class, "linearAcc");
        GameRegistry.registerTileEntity(TileLaserEmitter.class, "laserEmitter");
        GameRegistry.registerTileEntity(TileConstructionPlate.class, "constructionPlate");
        GameRegistry.registerTileEntity(TileStorageChamber.class, "storageChamber");
        GameRegistry.registerTileEntity(TileChamberDummy.class, "chamberBlockdummy");
        GameRegistry.registerTileEntity(TilePowerEmitter.class, "powerEmitter");
        GameRegistry.registerTileEntity(TileResearchTable.class, "researchTable");    }

}