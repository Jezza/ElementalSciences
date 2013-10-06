package me.jezzadabomb.es.renderers;

import me.jezzadabomb.es.lib.Textures;
import me.jezzadabomb.es.renderers.models.ModelStorageChamber;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class TileStorageChamberRenderer extends TileEntitySpecialRenderer{
    
    private ModelStorageChamber modelStorageChamber = new ModelStorageChamber();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        //modelStorageChamber.render((TileStorageChamber)tileEntity, x, y, z);
        
        if (tileEntity instanceof TileStorageChamber) {
            this.bindTexture(Textures.MODEL_STORAGE_CHAMBER);
            
            GL11.glPushMatrix();

            GL11.glTranslatef((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);

            GL11.glScalef(0.5f, 0.5f, 0.5f);
            
            modelStorageChamber.render();
            
            GL11.glPopMatrix();
        }
    }
}
