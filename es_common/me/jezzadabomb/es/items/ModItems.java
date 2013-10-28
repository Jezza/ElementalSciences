package me.jezzadabomb.es.items;

import cpw.mods.fml.common.registry.GameRegistry;
import me.jezzadabomb.es.lib.ItemIds;
import me.jezzadabomb.es.lib.Strings;
import net.minecraft.item.Item;

public class ModItems {
    
    public static Item chainCatalyst;
    
    public static void init() {
        
        chainCatalyst = new ItemChainCatalyst(ItemIds.CHAIN_CATALYST_DEFAULT, Strings.CHAIN_CATALYST);
        
        GameRegistry.registerItem(chainCatalyst, Strings.CHAIN_CATALYST);
        
    }
}
