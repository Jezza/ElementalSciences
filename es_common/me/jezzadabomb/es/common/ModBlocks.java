package me.jezzadabomb.es.common;

import me.jezzadabomb.es.common.blocks.BlockChamber;
import me.jezzadabomb.es.common.blocks.BlockChamberDummy;
import me.jezzadabomb.es.common.blocks.BlockPureColour;
import me.jezzadabomb.es.common.blocks.BlockStrengthenedGlass;
import me.jezzadabomb.es.common.items.ItemBlockChamber;
import me.jezzadabomb.es.common.items.ItemBlockPureColour;
import me.jezzadabomb.es.common.lib.BlockIds;
import me.jezzadabomb.es.common.lib.Strings;
import me.jezzadabomb.es.common.machines.BlockConstructionPlate;
import me.jezzadabomb.es.common.machines.BlockEnergyHandler;
import me.jezzadabomb.es.common.machines.BlockEnergyOutput;
import me.jezzadabomb.es.common.machines.BlockGravityCompressor;
import me.jezzadabomb.es.common.machines.BlockLaserEmitter;
import me.jezzadabomb.es.common.machines.BlockResearchTable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    /* Mod block instances */
    public static Block strGlass;
    public static Block chamberBlock;
    public static Block chamberBlockdummy;
    public static Block stchamberBlock;
    public static Block rechamberBlock;
    public static Block pureColour;
    public static Block gravCompressor;
    public static Block laserEmitter;
    public static Block constructionPlate;
    public static Block researchTable;
    public static Block energyHandler;
    public static Block energyOutput;

    public static void init() {

        strGlass = new BlockStrengthenedGlass(BlockIds.STRENGTHENED_GLASS, Strings.STRENGTHENED_GLASS);
        gravCompressor = new BlockGravityCompressor(BlockIds.GRAV_COMPRESSOR, Strings.GRAVITY_COMPRESSOR);
        chamberBlock = new BlockChamber(BlockIds.CHAMBER_BLOCK, Strings.CHAMBER_BLOCK);
        chamberBlockdummy = new BlockChamberDummy(BlockIds.CHAMBER_BLOCK_DUMMY, Strings.CHAMBER_BLOCK_DUMMY);
        pureColour = new BlockPureColour(BlockIds.PURE_COLOUR, Strings.PURE_COLOUR);
        laserEmitter = new BlockLaserEmitter(BlockIds.LASER_EMITTER, Strings.LASER_EMITTER);
        constructionPlate = new BlockConstructionPlate(BlockIds.CONSTRUCTION_PLATE, Strings.CONSTRUCTION_PLATE);
        researchTable = new BlockResearchTable(BlockIds.RESEARCH_TABLE, Strings.RESEARCH_TABLE);
        energyHandler = new BlockEnergyHandler(BlockIds.ENERGY_HANDLER, Strings.ENERGY_HANDLER);
        energyOutput = new BlockEnergyOutput(BlockIds.ENERGY_OUTPUT, Strings.ENERGY_OUTPUT);
        
        // Single Data Blocks
        
        GameRegistry.registerBlock(strGlass, Strings.STRENGTHENED_GLASS);
        GameRegistry.registerBlock(gravCompressor, Strings.GRAVITY_COMPRESSOR);
        GameRegistry.registerBlock(laserEmitter, Strings.LASER_EMITTER);
        GameRegistry.registerBlock(constructionPlate, Strings.CONSTRUCTION_PLATE);
        GameRegistry.registerBlock(researchTable, Strings.RESEARCH_TABLE);
        GameRegistry.registerBlock(energyHandler, Strings.ENERGY_HANDLER);
        GameRegistry.registerBlock(energyOutput, Strings.ENERGY_OUTPUT);

        // Meta Blocks
        
        GameRegistry.registerBlock(pureColour, ItemBlockPureColour.class, Strings.PURE_COLOUR);
        GameRegistry.registerBlock(chamberBlock, ItemBlockChamber.class, Strings.CHAMBER_BLOCK);
        GameRegistry.registerBlock(chamberBlockdummy, ItemBlockChamber.class, Strings.CHAMBER_BLOCK_DUMMY);

        // Recipes
        initBlockRecipes();
    }

    private static void initBlockRecipes() {

        GameRegistry.addRecipe(new ItemStack(strGlass), new Object[] {  "iii",
                                                                        "isi",
                                                                        "iii",
                                                                        Character.valueOf('i'), Block.glass,
                                                                        Character.valueOf('s'), Block.stone });
        GameRegistry.addRecipe(new ItemStack(chamberBlock), new Object[] {  "isi",
                                                                            "sis",
                                                                            "isi",
                                                                            Character.valueOf('i'), Item.ingotIron,
                                                                            Character.valueOf('s'), Block.stone });

    }
}