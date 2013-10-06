package me.jezzadabomb.es.renderers.items;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import me.jezzadabomb.es.lib.Textures;
import me.jezzadabomb.es.renderers.models.ModelStorageChamber;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemStorageChamberRenderer implements IItemRenderer{
    private ModelStorageChamber modelStorageChamber;

    public ItemStorageChamberRenderer()
    {
        modelStorageChamber = new ModelStorageChamber();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }
     
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }
     
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch(type)
        {
            case ENTITY:{
                renderStorageChamber(0f, 0f, 0f, 0.5f);
                return;
            }
             
            case EQUIPPED:{
                renderStorageChamber(0f, 0f, 0f, 0.5f);
                return;
            }
                 
            case EQUIPPED_FIRST_PERSON: {
                renderStorageChamber(1.2F, 0F, 0F, 0.5F);
                break;
            }
            
            case INVENTORY:{
                renderStorageChamber(0f, 0f, 0f, 0.5f);
                return;
            }
             
            default:return;
        }
    }
    
    private void renderStorageChamber(float x, float y, float z, float scale){
        FMLClientHandler.instance().getClient().renderEngine.func_110628_a(Textures.MODEL_STORAGE_CHAMBER);
        
        GL11.glPushMatrix();
        
        GL11.glDisable(GL11.GL_LIGHTING);
        
        GL11.glTranslatef(x,  y,  z);
        
        GL11.glScalef(scale, scale, scale);
        
        GL11.glRotatef(180f, 0f, 1f, 0f);
        
        modelStorageChamber.render();
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
    }
}
