package me.jezzadabomb.es.items;

import me.jezzadabomb.es.lib.ItemIds;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.item.Item;

public class ModItems {

    public static Item gBow;
    
    
    public static void init() {
        gBow = new ItemGBow(ItemIds.GBOW_DEFAULT, Strings.GBOW);
    }
}
