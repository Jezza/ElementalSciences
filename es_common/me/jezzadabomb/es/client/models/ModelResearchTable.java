package me.jezzadabomb.es.client.models;

import me.jezzadabomb.es.common.lib.Models;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelResearchTable extends ModelBase {

    private IModelCustom modelResearchTable;

    public ModelResearchTable() {
        modelResearchTable = AdvancedModelLoader.loadModel(Models.RESEARCH_TABLE);
    }

    public void render() {
        modelResearchTable.renderAll();
    }
}
