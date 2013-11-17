package me.jezzadabomb.es.common.tileentity;

import me.jezzadabomb.es.common.lib.BlockIds;
import me.jezzadabomb.es.common.lib.Reference;

public class TileEnergyHandler extends TileES {

    public boolean isValidMultiblock = false;

    public TileEnergyHandler() {
    }

    public boolean getIsValid() {
        return isValidMultiblock;
    }

    public void invalidateMultiblock() {
        revertDummies();
        restartUpdateLoop();
        isValidMultiblock = false;
    }

    public void restartUpdateLoop(){
        int x = xCoord;
        int y = yCoord;
        int z = zCoord;
        
        worldObj.scheduleBlockUpdate(x, y, z, worldObj.getBlockId(x, y, z), Reference.tickRate());
    }
    
    public void validateMultiblock() {
        convertDummies();

        isValidMultiblock = true;
    }

    public void convertDummies() {
        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                for (int y = -1; y <= 1; ++y) {
                    int x2 = xCoord + x;
                    int z2 = zCoord + z;
                    int y2 = yCoord + y;
                    System.out.println(x);
                    System.out.println(z);
                    System.out.println(y);
                    if (x == 0 && z == 0 && y == 0) {
                        continue;
                    }
                    if (x == -1 && z == 0 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 4, 3);
                        setPowerCore(x2, y2, z2);
                    } else if (x == 1 && z == 0 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 5, 3);
                        setPowerCore(x2, y2, z2);
                    } else if (x == 0 && z == -1 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 2, 3);
                        setPowerCore(x2, y2, z2);
                    } else if (x == 0 && z == 1 && y == 0) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 3, 3);
                        setPowerCore(x2, y2, z2);
                    } else if (x == 0 && z == 0 && y == -1) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 0, 3);
                        setPowerCore(x2, y2, z2);
                    } else if (x == 0 && z == 0 && y == 1) {
                        worldObj.setBlock(x2, y2, z2, BlockIds.POWER_EMITTER_DEFAULT, 1, 3);
                        setPowerCore(x2, y2, z2);
                    } else {
                        int meta2 = worldObj.getBlockMetadata(x2, y2, z2);
                        worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DUMMY_DEFAULT, meta2, 2);
                        setDummyCore(x2, y2, z2);
                    }
                    worldObj.markBlockForUpdate(x2, y2, z2);
                }
            }
        }
    }

    public void setDummyCore(int x, int y, int z) {
        TileChamberDummy dummyTE = (TileChamberDummy) worldObj.getBlockTileEntity(x, y, z);
        if (dummyTE != null) {
            dummyTE.setCore(this);
        }
    }

    public void setPowerCore(int x, int y, int z) {
        TilePowerEmitter dummy = (TilePowerEmitter) worldObj.getBlockTileEntity(x, y, z);
        if (dummy != null) {
            dummy.setCore(this);
        }
    }

    public void revertDummies() {
        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                for (int y = -1; y <= 1; ++y) {
                    int x2 = xCoord + x;
                    int z2 = zCoord + z;
                    int y2 = yCoord + y;
                    System.out.println(x);
                    System.out.println(z);
                    System.out.println(y);

                    if (x == 0 && z == 0 && y == 0) {
                        continue;
                    }

                    if (worldObj.getBlockId(x2, y2, z2) == 0) {
                        continue;
                    } else {

                        if (x == -1 && z == 0 && y == 0) {
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                        } else if (x == 1 && z == 0 && y == 0) {
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                        } else if (x == 0 && z == -1 && y == 0) {
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                        } else if (x == 0 && z == 1 && y == 0) {
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                        } else if (x == 0 && z == 0 && y == -1) {
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                        } else if (x == 0 && z == 0 && y == 1) {
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, 3, 3);
                        } else {
                            int meta2 = worldObj.getBlockMetadata(x2, y2, z2);
                            worldObj.setBlock(x2, y2, z2, BlockIds.CHAMBER_BLOCK_DEFAULT, meta2, 2);
                        }
                    }
                    worldObj.markBlockForUpdate(x2, y2, z2);
                }
            }
        }
    }

    public boolean checkIfProperlyFormed() {
        
        for (int x = -1; x <= 1; ++x) {
            for (int z = -1; z <= 1; ++z) {
                for (int y = -1; y <= 1; ++y) {
                    int x2 = xCoord + x;
                    int z2 = zCoord + z;
                    int y2 = yCoord + y;
                    int blockId = worldObj.getBlockId(x2, y2, z2);
                    int meta = worldObj.getBlockMetadata(x2, y2, z2);
                    
//                    System.out.println(x);
//                    System.out.println(z);
//                    System.out.println(y);
//                    System.out.println("ID: " + blockId + ". META: " + meta + ". XCOORD: " + x2 + ". ZCOORD: " + z2 + " . YCOORD: " + y2);
                    if (x == 0 && z == 0 && y == 0) {
                        continue;
                    }

                    if (x == -1 && z == 0 && y == 0) {
                        if (compareIdAndMeta(BlockIds.CHAMBER_BLOCK_DEFAULT, 3, blockId, meta)) {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (x == 1 && z == 0 && y == 0) {
                        if (compareIdAndMeta(BlockIds.CHAMBER_BLOCK_DEFAULT, 3, blockId, meta)) {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (x == 0 && z == -1 && y == 0) {
                        if (compareIdAndMeta(BlockIds.CHAMBER_BLOCK_DEFAULT, 3, blockId, meta)) {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (x == 0 && z == 1 && y == 0) {
                        if (compareIdAndMeta(BlockIds.CHAMBER_BLOCK_DEFAULT, 3, blockId, meta)) {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (x == 0 && z == 0 && y == -1) {
                        if (compareIdAndMeta(BlockIds.CHAMBER_BLOCK_DEFAULT, 3, blockId, meta)) {
                            continue;
                        } else {
                            return false;
                        }
                    } else if (x == 0 && z == 0 && y == 1) {
                        if (compareIdAndMeta(BlockIds.CHAMBER_BLOCK_DEFAULT, 3, blockId, meta)) {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        if (blockId == BlockIds.CHAMBER_BLOCK_DEFAULT) {
                            continue;
                        } else {
                            System.out.println("Broken!");
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean compareIdAndMeta(int Cid, int Cmeta, int id, int meta) {
        if (Cid == id && Cmeta == meta) {
            return true;
        }
        return false;
    }

    @Override
    public void updateEntity() {
    }
}
