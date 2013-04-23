package me.jezzadabomb.es;

import me.jezzadabomb.es.handlers.ServerHandler;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ElementalScience", name="Elemental Science", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ElementalSciences {

        // The instance of your mod that Forge uses.
        @Instance("ElementalScience")
        public static ElementalSciences instance;
        public static boolean CanInject = false;
        
        public static CreativeTabs tabGeneMachines = new CreativeTabs("tabGeneMachines") {
        	public int getTabIconItemIndex()
            {
                   return ElementalSciences.geneInjector.blockID;
            }
        };
        
        public final static Block geneInjector = new TileMultiBlockMachine(4001, "geneInjector", 4, 1);
        public final static Block geneViewerGlass = new BlockViewerGlass(4003, "geneViewerGlass", 3);
        public final static Block geneChamber = new TileMultiBlockMachine(4004, "geneChamber", 1, 3);
        public final static Block genePDetector = new TileMultiBlockMachine(4005,"genePDetector", 1,4);
        public final static Block geneChamberDoor = new BlockChamberDoor(4006, "geneChamberDoor");
        public final static Item geneChamberDoorItem = new GeneItem(4007, "geneChamberDoorItem");
        public final static Block geneMasterControl = new TileMultiBlockMachine(4008,"geneMasterControl",4,5);
        public final static Block geneScraper = new TileMultiBlockMachine(4009,"geneScraper",4,6);
        
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="net.jezzadabomb.me.es.handlers.ClientHandler", serverSide="net.jezzadabomb.me.es.handlers.ServerHandler")
        public static ServerHandler proxy;
                
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
        	
        }
        
        @Init
        public void load(FMLInitializationEvent event) {
        	setupItems();
        	setupBlocks();
        	addNames();
        	RegisterBlocks();
        	proxy.registerRenderers();
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
        
        public void setupItems(){
        	
        }
        
        public void setupBlocks(){
        	
        }
        
        public void addNames(){
        	 LanguageRegistry.addName(geneInjector, "Gene Injector");
        	 LanguageRegistry.addName(geneViewerGlass, "Glass Viewer");
        	 LanguageRegistry.addName(geneChamber, "Gene Chamber");
        	 LanguageRegistry.addName(genePDetector, "Player Detector - You shouldn't have this.");
        	 LanguageRegistry.addName(geneChamberDoor, "Gene Chamber Door - You shouldn't have this.");
        	 LanguageRegistry.addName(geneChamberDoorItem, "Chamber Door");
        	 LanguageRegistry.addName(geneMasterControl, "Master Control");
        	 LanguageRegistry.addName(geneScraper, "Genome Scraper");
        	 LanguageRegistry.instance().addStringLocalization("itemGroup.tabGeneMachines", "en_US", "Gene Machines");
        }
        
        public void RegisterBlocks(){
        	GameRegistry.registerBlock(geneInjector, "geneInjector");
        	GameRegistry.registerBlock(geneViewerGlass, "geneTankGlass");
        	GameRegistry.registerBlock(geneChamber, "geneChamber");
        	GameRegistry.registerBlock(genePDetector, "genePDetector");
        	GameRegistry.registerBlock(geneChamberDoor, "geneChamberDoor");
        	GameRegistry.registerItem(geneChamberDoorItem, "geneChamberDoorItem");
        	GameRegistry.registerBlock(geneMasterControl, "geneMasterControl");
        	GameRegistry.registerBlock(geneScraper, "geneScraper");
        }        
}