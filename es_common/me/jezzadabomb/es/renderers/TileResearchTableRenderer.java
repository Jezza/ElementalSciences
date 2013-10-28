package me.jezzadabomb.es.renderers;

import me.jezzadabomb.es.lib.Textures;
import me.jezzadabomb.es.renderers.models.ModelResearchTable;
import me.jezzadabomb.es.tileentity.TileResearchTable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileResearchTableRenderer extends TileEntitySpecialRenderer{
    
    private ModelResearchTable modelResearchTable = new ModelResearchTable();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        //modelStorageChamber.render((TileStorageChamber)tileEntity, x, y, z);
        if (tileEntity instanceof TileResearchTable) {
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_LIGHTING);
            
            //Hovering height
            double period = 24*Math.PI;
            double local = (period * (System.currentTimeMillis() & 0x3FFFL)/0x3FFFL);
            float hoverHeight = (float) ((0.4*(Math.sin(local)))/8);

            //Translations and Scales
            GL11.glTranslatef((float) x + 0.5f, (float) y + 0.35f + hoverHeight, (float) z + 0.5f);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            
            this.bindTexture(Textures.MODEL_RESEARCH_TABLE);
            modelResearchTable.render();
            
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glPopMatrix();
        }
    }
}
