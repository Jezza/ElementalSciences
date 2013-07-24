package me.jezzadabomb.es.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import me.jezzadabomb.es.items.ItemBlockChamber;
import me.jezzadabomb.es.items.ItemBlockPureColour;
import me.jezzadabomb.es.lib.BlockIds;
import me.jezzadabomb.es.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    /* Mod block instances */
    public static Block strengthenedGlass;
    public static Block chamberBlock;
    public static Block stchamberBlock;
    public static Block rechamberBlock;
    public static Block pureColour;
    public static Block gravCompressor;

    public static void init() {

        strengthenedGlass = new BlockStrengthenedGlass(BlockIds.GLASS_VIEWER_DEFAULT,Strings.STRENGTHENED_GLASS);
        gravCompressor = new BlockGravityCompressor(BlockIds.GRAVITY_COMPRESSOR_DEFAULT);
        chamberBlock = new BlockChamber(BlockIds.CHAMBER_BLOCK_DEFAULT);
        pureColour = new BlockPureColour(BlockIds.DYED_QUARTZ);
        
        GameRegistry.registerBlock(strengthenedGlass, Strings.STRENGTHENED_GLASS);
        GameRegistry.registerBlock(gravCompressor, Strings.GRAVITY_COMPRESSOR);
        GameRegistry.registerBlock(chamberBlock, ItemBlockChamber.class ,Strings.CHAMBER_WALL);
        GameRegistry.registerBlock(pureColour, ItemBlockPureColour.class, Strings.DYED_QUARTZ_NAME);
        
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(strengthenedGlass), new Object[] {"iii", "isi", "iii", Character.valueOf('i'), Block.glass, Character.valueOf('s'), Block.stone });
        GameRegistry.addRecipe(new ItemStack(chamberBlock), new Object[] {"isi", "sis", "isi", Character.valueOf('i'), Item.ingotIron, Character.valueOf('s'), Block.stone });
        
    }
}