package me.jezzadabomb.es.common.lib;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;

public class ConfigHandler {
    
    private static Configuration config;
    
    public static void init(String file){
        config = new Configuration(new File(file + "ElementalSciences.cfg"));
        
        try {
            config.load();
            
            /* Block configs */
            BlockIds.CHAMBER_BLOCK = config.getBlock(Strings.CHAMBER_BLOCK, BlockIds.CHAMBER_BLOCK_DEFAULT).getInt(BlockIds.CHAMBER_BLOCK_DEFAULT);
            BlockIds.CHAMBER_BLOCK_DUMMY = config.getBlock(Strings.CHAMBER_BLOCK_DUMMY, BlockIds.CHAMBER_BLOCK_DUMMY_DEFAULT).getInt(BlockIds.CHAMBER_BLOCK_DUMMY_DEFAULT);
            BlockIds.CONSTRUCTION_PLATE = config.getBlock(Strings.CONSTRUCTION_PLATE, BlockIds.CONSTRUCTION_PLATE_DEFAULT).getInt(BlockIds.CONSTRUCTION_PLATE_DEFAULT);
            BlockIds.STRENGTHENED_GLASS = config.getBlock(Strings.STRENGTHENED_GLASS, BlockIds.STRENGTHENED_GLASS_DEFAULT).getInt(BlockIds.STRENGTHENED_GLASS_DEFAULT);
            BlockIds.GRAV_COMPRESSOR = config.getBlock(Strings.GRAVITY_COMPRESSOR, BlockIds.GRAV_COMPRESSOR_DEFAULT).getInt(BlockIds.GRAV_COMPRESSOR_DEFAULT);
            BlockIds.LASER_EMITTER = config.getBlock(Strings.LASER_EMITTER, BlockIds.LASER_EMITTER_DEFAULT).getInt(BlockIds.LASER_EMITTER_DEFAULT);
            BlockIds.POWER_CONDUIT = config.getBlock(Strings.POWER_CONDUIT, BlockIds.POWER_CONDUIT_DEFAULT).getInt(BlockIds.POWER_CONDUIT_DEFAULT);
            BlockIds.POWER_EMITTER = config.getBlock(Strings.POWER_EMITTER, BlockIds.POWER_EMITTER_DEFAULT).getInt(BlockIds.POWER_EMITTER_DEFAULT);
            BlockIds.PURE_COLOUR = config.getBlock(Strings.PURE_COLOUR, BlockIds.PURE_COLOUR_DEFAULT).getInt(BlockIds.PURE_COLOUR_DEFAULT);
            BlockIds.RESEARCH_TABLE = config.getBlock(Strings.RESEARCH_TABLE, BlockIds.RESEARCH_TABLE_DEFAULT).getInt(BlockIds.RESEARCH_TABLE_DEFAULT);
            BlockIds.ENERGY_HANDLER = config.getBlock(Strings.ENERGY_HANDLER, BlockIds.ENERGY_HANDLER_DEFAULT).getInt(BlockIds.ENERGY_HANDLER_DEFAULT);
            /* Item configs */
            ItemIds.CHAIN_CATALYST = config.getItem(Strings.CHAIN_CATALYST, ItemIds.CHAIN_CATALYST_DEFAULT).getInt(ItemIds.CHAIN_CATALYST_DEFAULT);
        }
        catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its block configuration");
        }
        finally {
            config.save();
        }
    }
    
}
