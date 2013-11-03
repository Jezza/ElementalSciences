package me.jezzadabomb.es.common;

import cpw.mods.fml.common.registry.GameRegistry;
import me.jezzadabomb.es.common.items.ItemChainCatalyst;
import me.jezzadabomb.es.common.lib.ItemIds;
import me.jezzadabomb.es.common.lib.Strings;
import net.minecraft.item.Item;

public class ModItems {
    
    public static Item chainCatalyst;
    
    public static void init() {
        
        chainCatalyst = new ItemChainCatalyst(ItemIds.CHAIN_CATALYST_DEFAULT, Strings.CHAIN_CATALYST);
        
        GameRegistry.registerItem(chainCatalyst, Strings.CHAIN_CATALYST);
        
    }
}
