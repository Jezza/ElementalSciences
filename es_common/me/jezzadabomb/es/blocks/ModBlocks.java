package me.jezzadabomb.es.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import me.jezzadabomb.es.lib.BlockIds;
import me.jezzadabomb.es.lib.Names;
import me.jezzadabomb.es.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    /* Mod block instances */
    public static Block viewerGlass;
    public static Block chamberBlock;

    public static void init() {

        viewerGlass = new BlockViewerGlass(BlockIds.GLASS_VIEWER_DEFAULT,Strings.VIEWER_GLASS);
        chamberBlock = new BlockChamber(BlockIds.CHAMBER_BLOCK_DEFAULT,Strings.CHAMBER_WALL);

        GameRegistry.registerBlock(viewerGlass, Strings.VIEWER_GLASS);
        GameRegistry.registerBlock(chamberBlock, Strings.CHAMBER_WALL);

        LanguageRegistry.addName(viewerGlass, Names.GLASS_VIEWER);
        LanguageRegistry.addName(chamberBlock, Names.CHAMBER_WALL);
        
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(viewerGlass), new Object[] {"iii", "isi", "iii", Character.valueOf('i'), Block.glass, Character.valueOf('s'), Block.stone });
        GameRegistry.addRecipe(new ItemStack(chamberBlock), new Object[] {"isi", "sis", "isi", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
    }
}