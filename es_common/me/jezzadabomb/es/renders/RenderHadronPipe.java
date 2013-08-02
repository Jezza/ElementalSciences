package me.jezzadabomb.es.renders;

import me.jezzadabomb.es.blocks.BlockPipeComponent.PipeComponent;
import me.jezzadabomb.es.core.helpers.Helper;
import me.jezzadabomb.es.core.util.BaseBlockRenderer;
import me.jezzadabomb.es.core.util.IconRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class RenderHadronPipe extends BaseBlockRenderer {
    private static RenderHadronPipe INSTANCE = new RenderHadronPipe();

    public static RenderHadronPipe instance(){
        return INSTANCE;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer){
        float min = 0.5F - 0.1875F;
        float max = 0.5F + 0.1875F;
        block.setBlockBounds(min, 0.0F, min, max, 1.0F, max);
        renderer.setRenderBoundsFromBlock(block);
        renderAsItem(block, renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer){
        float coremin = 0.5F - 0.1875F;
        float coremax = 0.5F + 0.1875F;
        float bordermin = 0.0F;
        float bordermax = 1.0F;
        int joints = 0;

        if(Helper.getBlockInstance(world, x-1, y, z) instanceof PipeComponent){
            if(((PipeComponent)Helper.getBlockInstance(world, x-1, y, z)).canTubeConnectOnSide(world, x-1, y, z, Helper.dirXPos)){
                block.setBlockBounds(bordermin, coremin, coremin, coremin, coremax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
                joints++;
            }
        }
        if(Helper.getBlockInstance(world, x+1, y, z) instanceof PipeComponent){
            if(((PipeComponent)Helper.getBlockInstance(world, x+1, y, z)).canTubeConnectOnSide(world, x+1, y, z, Helper.dirXNeg)){
                block.setBlockBounds(coremax, coremin, coremin, bordermax, coremax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
                joints++;
            }
        }
        if(Helper.getBlockInstance(world, x, y-1, z) instanceof PipeComponent){
            if(((PipeComponent)Helper.getBlockInstance(world, x, y-1, z)).canTubeConnectOnSide(world, x, y-1, z, Helper.dirYPos)){
                block.setBlockBounds(coremin, bordermin, coremin, coremax, coremin, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
                joints++;
            }
        }
        if(Helper.getBlockInstance(world, x, y+1, z) instanceof PipeComponent){
            if(((PipeComponent)Helper.getBlockInstance(world, x, y+1, z)).canTubeConnectOnSide(world, x, y+1, z, Helper.dirYNeg)){
                block.setBlockBounds(coremin, coremax, coremin, coremax, bordermax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
                joints++;
            }
        }
        if(Helper.getBlockInstance(world, x, y, z-1) instanceof PipeComponent){
            if(((PipeComponent)Helper.getBlockInstance(world, x, y, z-1)).canTubeConnectOnSide(world, x, y, z-1, Helper.dirZPos)){
                block.setBlockBounds(coremin, coremin, bordermin, coremax, coremax, coremin);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
                joints++;
            }
        }
        if(Helper.getBlockInstance(world, x, y, z+1) instanceof PipeComponent){
            if(((PipeComponent)Helper.getBlockInstance(world, x, y, z+1)).canTubeConnectOnSide(world, x, y, z+1, Helper.dirZNeg)){
                block.setBlockBounds(coremin, coremin, coremax, coremax, coremax, bordermax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
                joints++;
            }
        }
        if(joints > 2){
            Icon joint = IconRegistry.colliderPipe_joint;
            coremin -= 0.0625F;
            coremax += 0.0625F;
            block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderFaceZNeg(block, x, y, z, joint);
            renderer.renderFaceZPos(block, x, y, z, joint);
            renderer.renderFaceXNeg(block, x, y, z, joint);
            renderer.renderFaceXPos(block, x, y, z, joint);
            renderer.renderFaceYNeg(block, x, y, z, joint);
            renderer.renderFaceYPos(block, x, y, z, joint);
        }else{
            block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
        }
        block.setBlockBoundsBasedOnState(world, x, y, z);
        return true;
    }
}
