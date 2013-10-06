package me.jezzadabomb.es.renderers.models;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import me.jezzadabomb.es.lib.Models;
import me.jezzadabomb.es.lib.Textures;
import me.jezzadabomb.es.tileentity.TileStorageChamber;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelStorageChamber extends ModelBase {

    private IModelCustom modelStorageChamber;

    public ModelStorageChamber() {
        modelStorageChamber = AdvancedModelLoader.loadModel(Models.STORAGE_CHAMBER);
    }

    public void render() {
        modelStorageChamber.renderAll();
    }

    public void render(TileStorageChamber storageChamber, double x, double y, double z) {
        GL11.glPushMatrix();

        GL11.glTranslatef((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);

        GL11.glScalef(0.5f, 0.5f, 0.5f);

        this.bindTexture(Textures.MODEL_STORAGE_CHAMBER);

        this.render();

        GL11.glPopMatrix();
    }
}
