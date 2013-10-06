package me.jezzadabomb.es.renderers.models;

import me.jezzadabomb.es.lib.Models;
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
}
