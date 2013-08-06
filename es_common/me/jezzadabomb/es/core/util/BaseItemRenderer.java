package me.jezzadabomb.es.core.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public abstract class BaseItemRenderer implements IItemRenderer {

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY:
                renderEntity(item, data);
                break;
            case EQUIPPED:
                renderEquipped(item, data);
                break;
            case FIRST_PERSON_MAP:
                renderFirstPerson(item, data);
                break;
            case INVENTORY:
                renderInventory(item, data);
                break;
            default:
                break;
        }
    }

    protected void renderEntity(ItemStack item, Object... data) {
    }

    protected void renderEquipped(ItemStack item, Object... data) {
    }

    protected void renderFirstPerson(ItemStack item, Object... data) {
    }

    protected void renderInventory(ItemStack item, Object... data) {
    }
}