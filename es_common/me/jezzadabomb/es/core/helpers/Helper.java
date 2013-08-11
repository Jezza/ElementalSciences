package me.jezzadabomb.es.core.helpers;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/**
 * Your everyday helper, with bits of common and useful code.
 * Mostly direction handling and Block class fetching.
 * @author LordFokas
 */
public final class Helper {
    // Cardinal Orientation
    public static final int dirBottom = 0;
    public static final int dirTop = 1;
    public static final int dirEast = 2;
    public static final int dirWest = 3;
    public static final int dirNorth = 4;
    public static final int dirSouth = 5;

    // Axial Orientation
    public static final int dirYNeg = 0;
    public static final int dirYPos = 1;
    public static final int dirZNeg = 2;
    public static final int dirZPos = 3;
    public static final int dirXNeg = 4;
    public static final int dirXPos = 5;

    // Orientation Override value
    public static final int dirIgnore = 999;

    // Adjacent Block Cycler
    public static final int[][]
        adjacentBlockCoords = {
        { 0, -1,  0}, // Y Neg : Bottom
        { 0,  1,  0}, // Y Pos : Top
        { 0,  0, -1}, // Z Neg : East
        { 0,  0,  1}, // Z Pos : West
        {-1,  0,  0}, // X Neg : North
        { 1,  0,  0}  // X Pos : South
    };

    public final static double deg2rad = 180/Math.PI;

    public final static int SETBLOCK_NO_UPDATE = 0;
    public final static int SETBLOCK_UPDATE = 2;

    private Helper(){}
    
    public static Block getBlockInstance(IBlockAccess w, int x, int y, int z){
        return Block.blocksList[w.getBlockId(x, y, z)];
    }
    
    public static Block getBlockInstance(World w, int x, int y, int z){
        return Block.blocksList[w.getBlockId(x, y, z)];
    }

    public static boolean isSolid(World w, int x, int y, int z, int side){
        ForgeDirection dir = ForgeDirection.getOrientation(side);
        Block block = getBlockInstance(w, x, y, z);
        return block == null ? false : block.isBlockSolidOnSide(w, x, y, z, dir);
    }

    public static int oppositeDirection(int dir){
        switch(dir){
            case dirXPos: return dirXNeg;
            case dirXNeg: return dirXPos;
            case dirYPos: return dirYNeg;
            case dirYNeg: return dirYPos;
            case dirZPos: return dirZNeg;
            case dirZNeg: return dirZPos;
            default: return -1;
        }
    }

    public static int yaw2dir(float yaw){
        int dir = (MathHelper.floor_double((double)(yaw * 4.0F / 360.0F) + 0.5D) & 3)+3;
        if(dir > 4) dir -= 4;
        switch(dir){
            case 1: return dirZPos;
            case 2: return dirXNeg;
            case 3: return dirZNeg;
            case 4: return dirXPos;
            default: return 0;
        }
    }
}