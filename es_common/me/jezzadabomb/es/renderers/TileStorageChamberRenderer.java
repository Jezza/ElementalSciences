package me.jezzadabomb.es.renderers;

import me.jezzadabomb.es.renderers.models.ModelStorageChamber;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileStorageChamberRenderer extends TileEntitySpecialRenderer{
    
    private ModelStorageChamber modelStorageChamber = new ModelStorageChamber();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        modelStorageChamber.render((TileStorageChamber)tileEntity, x, y, z);
    }

}
