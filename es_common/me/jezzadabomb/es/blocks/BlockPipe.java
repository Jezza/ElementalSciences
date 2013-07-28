package me.jezzadabomb.es.blocks;

import java.util.Random;

import me.jezzadabomb.es.lib.BlockIds;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPipe extends BlockES {

    public int blockID;

    public BlockPipe(int id) {
        super(id, Material.anvil);
        this.blockID = id;
        setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
        setUnlocalizedName(Strings.COLLIDER_PIPE);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
        boolean zpos = false;
        boolean zneg = false;
        boolean xpos = false;
        boolean xneg = false;
        boolean ypos = false;
        boolean yneg = false;
        if (this.blockID == blockAccess.getBlockId(x, y, z + 1) || (blockAccess.getBlockMetadata(x, y, z + 1)) == 3 && (blockAccess.getBlockId(x, y, z + 1) == BlockIds.CHAMBER_BLOCK_DEFAULT)) {
            zpos = true;
        }
        if (this.blockID == blockAccess.getBlockId(x, y, z - 1) || (blockAccess.getBlockMetadata(x, y, z - 1)) == 3 && (blockAccess.getBlockId(x, y, z - 1) == BlockIds.CHAMBER_BLOCK_DEFAULT)) {
            zneg = true;
        }
        if (this.blockID == blockAccess.getBlockId(x + 1, y, z) || (blockAccess.getBlockMetadata(x + 1, y, z)) == 3 && (blockAccess.getBlockId(x + 1, y, z) == BlockIds.CHAMBER_BLOCK_DEFAULT)) {
            xpos = true;
        }
        if (this.blockID == blockAccess.getBlockId(x - 1, y, z) || (blockAccess.getBlockMetadata(x - 1, y, z)) == 3 && (blockAccess.getBlockId(x - 1, y, z) == BlockIds.CHAMBER_BLOCK_DEFAULT)) {
            xneg = true;
        }
        if (this.blockID == blockAccess.getBlockId(x, y + 1, z) || (blockAccess.getBlockMetadata(x, y + 1, z)) == 3 && (blockAccess.getBlockId(x, y + 1, z) == BlockIds.CHAMBER_BLOCK_DEFAULT)) {
            ypos = true;
        }
        if (this.blockID == blockAccess.getBlockId(x, y - 1, z) || (blockAccess.getBlockMetadata(x, y - 1, z)) == 3 && (blockAccess.getBlockId(x, y - 1, z) == BlockIds.CHAMBER_BLOCK_DEFAULT)) {
            yneg = true;
        }
        if (zpos || zneg || xpos || xneg || ypos || yneg) {
            float zpos2 = 0;
            float zneg2 = 0;
            float xpos2 = 0;
            float xneg2 = 0;
            float ypos2 = 0;
            float yneg2 = 0;
            if (zpos) {
                zpos2 = 0.25f;
            }
            if (zneg) {
                zneg2 = 0.25f;
            }
            if (xpos) {
                xpos2 = 0.25f;
            }
            if (xneg) {
                xneg2 = 0.25f;
            }
            if (ypos) {
                ypos2 = 0.25f;
            }
            if (yneg) {
                yneg2 = 0.25f;
            }
            // printDebug("zpos" + String.valueOf(zpos2));
            // printDebug("zneg" + String.valueOf(zneg2));
            // printDebug("xpos" + String.valueOf(xpos2));
            // printDebug("xneg" + String.valueOf(xneg2));
            // printDebug("ypos" + String.valueOf(ypos2));
            // printDebug("yneg" + String.valueOf(yneg2));
            this.setBlockBounds(0.25F - xneg2, 0.25F - yneg2, 0.25F - zneg2, 0.75F + xpos2, 0.75F + ypos2, 0.75F + zpos2);
        }
    }

    public void setBlockBoundsForItemRender() {
        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int maxLink() {
        return 24;
    }

    public boolean compareID(World world, int x, int y, int z, int id) {
        if (id == world.getBlockId(x, y, z)) {
            return true;
        }
        return false;
    }

    public int checkZPos(World world, int x, int y, int z, int id) {
        int localCounter = 0;

        if (getZPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getZNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        printDebug(String.valueOf("ZPOS: " + localCounter));
        return localCounter;
    }

    public int checkZNeg(World world, int x, int y, int z, int id) {
        int localCounter = 0;

        if (getZPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getZNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        printDebug(String.valueOf("ZNEG: " + localCounter));
        return localCounter;
    }

    public int checkXPos(World world, int x, int y, int z, int id) {
        int localCounter = 0;

        if (getZPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getZNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        printDebug(String.valueOf("XPOS: " + localCounter));
        return localCounter;
    }

    public int checkXNeg(World world, int x, int y, int z, int id) {
        int localCounter = 0;

        if (getZPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getZNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        printDebug(String.valueOf("XNEG: " + localCounter));
        return localCounter;
    }

    public int checkYPos(World world, int x, int y, int z, int id) {
        int localCounter = 0;

        if (getZPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getZNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        printDebug(String.valueOf("YPOS: " + localCounter));
        return localCounter;
    }

    public int checkYNeg(World world, int x, int y, int z, int id) {
        int localCounter = 0;

        if (getZPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getZNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getXNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYPos(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        if (getYNeg(world, x, y, z, this.blockID)) {
            localCounter += 1;
        }
        printDebug(String.valueOf("YNEG: " + localCounter));
        return localCounter;
    }

    public boolean getZPos(World world, int x, int y, int z, int id) {
        if (compareID(world, x, y, z + 1, id)) {
            return true;
        }
        return false;
    }

    public boolean getZNeg(World world, int x, int y, int z, int id) {
        if (compareID(world, x, y, z - 1, id)) {
            return true;
        }
        return false;
    }

    public boolean getXPos(World world, int x, int y, int z, int id) {
        if (compareID(world, x + 1, y, z, id)) {
            return true;
        }
        return false;
    }

    public boolean getXNeg(World world, int x, int y, int z, int id) {
        if (compareID(world, x - 1, y, z, id)) {
            return true;
        }
        return false;
    }

    public boolean getYPos(World world, int x, int y, int z, int id) {
        if (compareID(world, x, y + 1, z, id)) {
            return true;
        }
        return false;
    }

    public boolean getYNeg(World world, int x, int y, int z, int id) {
        if (compareID(world, x, y - 1, z, id)) {
            return true;
        }
        return false;
    }

    public boolean checkSurrounding(World world, int x, int y, int z, int id) {
        int localCounter = 0;
        if (compareID(world, x, y, z + 1, this.blockID)) {
            localCounter += checkZPos(world, x, y, z + 1, this.blockID) + 1;
        }
        if (compareID(world, x, y, z - 1, this.blockID)) {
            localCounter += checkZNeg(world, x, y, z - 1, this.blockID) + 1;
        }
        if (compareID(world, x + 1, y, z, this.blockID)) {
            localCounter += checkXPos(world, x + 1, y, z, this.blockID) + 1;
        }
        if (compareID(world, x - 1, y, z, this.blockID)) {
            localCounter += checkXNeg(world, x - 1, y, z, this.blockID) + 1;
        }
        if (compareID(world, x, y + 1, z, this.blockID)) {
            localCounter += checkYPos(world, x, y + 1, z, this.blockID) + 1;
        }
        if (compareID(world, x, y - 1, z, this.blockID)) {
            localCounter += checkYNeg(world, x, y - 1, z, this.blockID) + 1;
        }
        printDebug("checking: " + String.valueOf(localCounter));
        if (localCounter < maxLink()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return checkSurrounding(world, x, y, z, 2);
    }
}
