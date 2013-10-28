package me.jezzadabomb.es.renderers;

import me.jezzadabomb.es.common.BlockPowerComponent.PowerComponent;
import me.jezzadabomb.es.core.helpers.Helper;
import me.jezzadabomb.es.core.util.BaseBlockRenderer;
import me.jezzadabomb.es.core.util.IconRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class RenderPowerConduit extends BaseBlockRenderer {
    private static RenderPowerConduit INSTANCE = new RenderPowerConduit();

    public static RenderPowerConduit instance() {
        return INSTANCE;
    }

    protected static void renderAsItem(Block block, RenderBlocks renderer) {
        Icon[] tmap = new Icon[6];
        for (int i = 0; i < 6; i++) {
            if (block.getBlockTextureFromSide(i) != null) {
                tmap[i] = block.getBlockTextureFromSide(i);
            }
        }
        renderAsItem(block, renderer, tmap);
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
        float min = 0.5F - 0.1875F;
        float max = 0.5F + 0.1875F;
        block.setBlockBounds(min, 0.0F, min, max, 1.0F, max);
        renderer.setRenderBoundsFromBlock(block);
        renderAsItem(block, renderer);
    }

    public boolean getConnectedX(IBlockAccess world, int x, int y, int z) {
        int localId = world.getBlockId(x, y, z);
        int comparePos = world.getBlockId(x + 1, y, z);
        int compareNeg = world.getBlockId(x - 1, y, z);

        if (localId == comparePos && localId == compareNeg) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getConnectedZ(IBlockAccess world, int x, int y, int z) {
        int localId = world.getBlockId(x, y, z);
        int comparePos = world.getBlockId(x, y, z + 1);
        int compareNeg = world.getBlockId(x, y, z - 1);

        if (localId == comparePos && localId == compareNeg) {
            return true;
        } else {
            return false;
        }
    }

    public boolean getConnectedY(IBlockAccess world, int x, int y, int z) {
        int localId = world.getBlockId(x, y, z);
        int comparePos = world.getBlockId(x, y + 1, z);
        int compareNeg = world.getBlockId(x, y - 1, z);

        if (localId == comparePos && localId == compareNeg) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        float coremin = 0.5F - 0.1875F;
        float coremax = 0.5F + 0.1875F;
        float bordermin = 0.0F;
        float bordermax = 1.0F;
        float colourMultiplier = 1.0F;

        int joints = 0;

        if (Helper.getBlockInstance(world, x - 1, y, z) instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x - 1, y, z)).canTubeConnectOnSide(world, x - 1, y, z, Helper.dirXPos)) {
                block.setBlockBounds(bordermin, coremin, coremin, coremin, coremax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
                ++joints;
            }
        }
        if (Helper.getBlockInstance(world, x + 1, y, z) instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x + 1, y, z)).canTubeConnectOnSide(world, x + 1, y, z, Helper.dirXNeg)) {
                block.setBlockBounds(coremax, coremin, coremin, bordermax, coremax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
                ++joints;
            }
        }
        if (Helper.getBlockInstance(world, x, y - 1, z) instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y - 1, z)).canTubeConnectOnSide(world, x, y - 1, z, Helper.dirYPos)) {
                block.setBlockBounds(coremin, bordermin, coremin, coremax, coremin, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
                ++joints;
            }
        }
        if (Helper.getBlockInstance(world, x, y + 1, z) instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y + 1, z)).canTubeConnectOnSide(world, x, y + 1, z, Helper.dirYNeg)) {
                block.setBlockBounds(coremin, coremax, coremin, coremax, bordermax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
                ++joints;
            }
        }
        if (Helper.getBlockInstance(world, x, y, z - 1) instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y, z - 1)).canTubeConnectOnSide(world, x, y, z - 1, Helper.dirZPos)) {
                block.setBlockBounds(coremin, coremin, bordermin, coremax, coremax, coremin);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
                ++joints;
            }
        }
        if (Helper.getBlockInstance(world, x, y, z + 1) instanceof PowerComponent) {
            if (((PowerComponent) Helper.getBlockInstance(world, x, y, z + 1)).canTubeConnectOnSide(world, x, y, z + 1, Helper.dirZNeg)) {
                block.setBlockBounds(coremin, coremin, coremax, coremax, coremax, bordermax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
                ++joints;
            }
        }
        if (joints == 2) {
            Icon jointx = IconRegistry.powerConduit_xJoint;
            Icon jointz = IconRegistry.powerConduit_zJoint;
            Icon jointy = IconRegistry.powerConduit_yJoint;
//            if (getConnectedX(world, x, y, z)) {
//                block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
//                renderer.setRenderBoundsFromBlock(block);
//                renderer.renderFaceZNeg(block, x, y, z, jointz);
//                renderer.renderFaceZPos(block, x, y, z, jointz);
//                renderer.renderFaceYNeg(block, x, y, z, jointx);
//                renderer.renderFaceYPos(block, x, y, z, jointx);
////                 renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 0.5F, 0.5F, 0.5F);
//            } else if (getConnectedZ(world, x, y, z)) {
//                block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
//                renderer.setRenderBoundsFromBlock(block);
//                renderer.renderFaceXNeg(block, x, y, z, jointz);
//                renderer.renderFaceXPos(block, x, y, z, jointz);
//                renderer.renderFaceYNeg(block, x, y, z, jointy);
//                renderer.renderFaceYPos(block, x, y, z, jointy);
////                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
//            } else if (getConnectedY(world, x, y, z)) {
//                block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
//                renderer.setRenderBoundsFromBlock(block);
//                renderer.renderFaceZNeg(block, x, y, z, jointy);
//                renderer.renderFaceZPos(block, x, y, z, jointy);
//                renderer.renderFaceXNeg(block, x, y, z, jointy);
//                renderer.renderFaceXPos(block, x, y, z, jointy);
////                 renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
//            } else {
                block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
                renderer.setRenderBoundsFromBlock(block);
                renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
//            }
        } else {
            block.setBlockBounds(coremin, coremin, coremin, coremax, coremax, coremax);
            renderer.setRenderBoundsFromBlock(block);
            renderer.renderStandardBlockWithColorMultiplier(block, x, y, z, colourMultiplier, colourMultiplier, colourMultiplier);
        }
        block.setBlockBoundsBasedOnState(world, x, y, z);
        return true;
    }
}
