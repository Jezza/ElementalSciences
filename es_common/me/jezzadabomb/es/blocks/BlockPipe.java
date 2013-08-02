package me.jezzadabomb.es.blocks;

import me.jezzadabomb.es.blocks.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.core.helpers.Helper;
import me.jezzadabomb.es.core.util.IconRegistry;
import me.jezzadabomb.es.lib.Strings;
import me.jezzadabomb.es.renders.RenderHadronPipe;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPipe extends BlockES implements PipeComponent {

    public int blockID;
    public double pipeWidth;
    
    public BlockPipe(int id, String name, double pipeWidth) {
        super(id, Material.anvil);
        this.blockID = id;
        this.pipeWidth = pipeWidth;
        setBlockBounds(getMinX(), getMinZ(), getMinY(), getMaxX(), getMaxZ(), getMaxY());
        setUnlocalizedName(name);
    }
    
    public float getMinX(){
        return ((float)(16/pipeWidth)/10);
    }
    
    public float getMaxX(){
        return 1f - getMinX();
    }
    public float getMinZ(){
        return ((float)(16/pipeWidth)/10);
    }
    
    public float getMaxZ(){
        return 1f - getMinZ();
    }
    public float getMinY(){
        return ((float)(16/pipeWidth)/10);
    }
    
    public float getMaxY(){
        return 1f - getMinY();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        printDebug("Min X: " + getMinX());
        printDebug("Max X: " + getMaxX());
        printDebug(String.valueOf(par6));
        printDebug(String.valueOf(par7));
        printDebug(String.valueOf(par8));
        printDebug(String.valueOf(par9));
        return false;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
        float[] min = { getMinX(), getMinZ(), getMinY() };
        float[] max = { getMaxX(), getMaxZ(), getMaxY() };
        if (Block.blocksList[world.getBlockId(x - 1, y, z)] instanceof PipeComponent) {
            if (((PipeComponent) Helper.getBlockInstance(world, x - 1, y, z)).canTubeConnectOnSide(world, x - 1, y, z, Helper.dirXPos))
                min[0] = 0.0F;
        }
        if (Block.blocksList[world.getBlockId(x + 1, y, z)] instanceof PipeComponent) {
            if (((PipeComponent) Helper.getBlockInstance(world, x + 1, y, z)).canTubeConnectOnSide(world, x + 1, y, z, Helper.dirXNeg))
                max[0] = 1.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y - 1, z)] instanceof PipeComponent) {
            if (((PipeComponent) Helper.getBlockInstance(world, x, y - 1, z)).canTubeConnectOnSide(world, x, y - 1, z, Helper.dirYPos))
                min[1] = 0.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y + 1, z)] instanceof PipeComponent) {
            if (((PipeComponent) Helper.getBlockInstance(world, x, y + 1, z)).canTubeConnectOnSide(world, x, y + 1, z, Helper.dirYNeg))
                max[1] = 1.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y, z - 1)] instanceof PipeComponent) {
            if (((PipeComponent) Helper.getBlockInstance(world, x, y, z - 1)).canTubeConnectOnSide(world, x, y, z - 1, Helper.dirZPos))
                min[2] = 0.0F;
        }
        if (Block.blocksList[world.getBlockId(x, y, z + 1)] instanceof PipeComponent) {
            if (((PipeComponent) Helper.getBlockInstance(world, x, y, z + 1)).canTubeConnectOnSide(world, x, y, z + 1, Helper.dirZNeg))
                max[2] = 1.0F;
        }
        this.setBlockBounds(min[0], min[1], min[2], max[0], max[1], max[2]);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World w, int x, int y, int z) {
        this.setBlockBoundsBasedOnState(w, x, y, z);
        return AxisAlignedBB.getAABBPool().getAABB((double) x + this.minX, (double) y + this.minY, (double) z + this.minZ, (double) x + this.maxX, (double) y + this.maxY, (double) z + this.maxZ);
    }

    @Override
    public boolean canTubeConnectOnSide(IBlockAccess w, int x, int y, int z, int side) {
        return true;
    }

//    @Override
//    public void setBlockBoundsForItemRender() {
//        this.setBlockBounds(0.25F, 0.00F, 0.25F, 0.75F, 1.00F, 0.75F);
//    }

    @Override
    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
        return true;
    }
    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
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

    @Override
    public int getRenderType(){
        return RenderHadronPipe.instance().getRenderId();
    }
    
    @Override
    public void registerIcons(IconRegister register){
        IconRegistry.instance.loadAllBlocks(register);
    }
    
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return checkSurrounding(world, x, y, z, 2);
    }

    @Override
    public PipeComponentType getIonComponentType() {
        return PipeComponentType.TUBE;
    }
}
