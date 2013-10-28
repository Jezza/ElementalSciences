package me.jezzadabomb.es.renderers.items;

import me.jezzadabomb.es.lib.Textures;
import me.jezzadabomb.es.renderers.models.ModelResearchTable;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemResearchTableRenderer implements IItemRenderer{
    private ModelResearchTable modelResearchTable;

    public ItemResearchTableRenderer()
    {
        modelResearchTable = new ModelResearchTable();
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
                renderResearchTable(0F, 0F, 0F, 1F);
                return;
            }
             
            case EQUIPPED:{
                renderResearchTable(0F, 0F, 0F, 1F);
                return;
            }
                 
            case EQUIPPED_FIRST_PERSON: {
                renderResearchTable(1.2F, 0F, 0F, 1F);
                break;
            }
            
            case INVENTORY:{
                renderResearchTable(0F, -0.4F, 0F, 0.7F);
                return;
            }
             
            default:return;
        }
    }
    
    private void renderResearchTable(float x, float y, float z, float scale){
        
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        
        //Translate and Scale
        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);
        //Bind the texture
        Minecraft.getMinecraft().renderEngine.bindTexture(Textures.MODEL_RESEARCH_TABLE);
        //Render the model
        modelResearchTable.render();
        
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
    }
}
