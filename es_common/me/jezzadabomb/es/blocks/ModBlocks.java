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
    public static Block strengthenedGlass;
    public static Block chamberBlock;
    public static Block stchamberBlock;
    public static Block rechamberBlock;

    public static void init() {

        strengthenedGlass = new BlockStrengthenedGlass(BlockIds.GLASS_VIEWER_DEFAULT,Strings.STRENGTHENED_GLASS);
        chamberBlock = new BlockChamber(BlockIds.CHAMBER_BLOCK_DEFAULT,Strings.CHAMBER_WALL);
        stchamberBlock = new BlockChamber(BlockIds.ST_CHAMBER_BLOCK_DEFAULT,Strings.ST_CHAMBER_WALL);
        rechamberBlock = new BlockChamber(BlockIds.RE_CHAMBER_BLOCK_DEFAULT,Strings.RE_CHAMBER_WALL);
        Block dyedQuartz = new BlockDyedQuartz(BlockIds.DYED_QUARTZ);
        
        GameRegistry.registerBlock(strengthenedGlass, Strings.STRENGTHENED_GLASS);
        GameRegistry.registerBlock(chamberBlock, Strings.CHAMBER_WALL);
        GameRegistry.registerBlock(stchamberBlock, Strings.ST_CHAMBER_WALL);
        GameRegistry.registerBlock(rechamberBlock, Strings.RE_CHAMBER_WALL);
        GameRegistry.registerBlock(dyedQuartz, BlockItemES.class, Strings.DYED_QUARTZ_NAME);

        LanguageRegistry.addName(strengthenedGlass, Names.GLASS_VIEWER);
        LanguageRegistry.addName(chamberBlock, Names.CHAMBER_WALL);
        LanguageRegistry.addName(stchamberBlock, Names.ST_CHAMBER_WALL);
        LanguageRegistry.addName(rechamberBlock, Names.RE_CHAMBER_WALL);
        
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(strengthenedGlass), new Object[] {"iii", "isi", "iii", Character.valueOf('i'), Block.glass, Character.valueOf('s'), Block.stone });
        GameRegistry.addRecipe(new ItemStack(chamberBlock), new Object[] {"isi", "sis", "isi", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
        
    }
}