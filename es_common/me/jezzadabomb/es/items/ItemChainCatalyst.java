package me.jezzadabomb.es.items;

import cpw.mods.fml.common.FMLCommonHandler;
import me.jezzadabomb.es.ElementalSciences;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemChainCatalyst extends ItemES {

    int id = 0;
    int meta = 0;
    
    int charge = 1;
    boolean firstClick = true;
    boolean secondClicked = false;
    int firstXPos;
    int firstYPos;
    int firstZPos;
    int secondXPos;
    int secondYPos;
    int secondZPos;
    
    public ItemChainCatalyst(int id, String name) {
        super(id, name);
    }
    
    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
        id = world.getBlockId(x, y, z);
        meta = world.getBlockMetadata(x, y, z);
        //FMLCommonHandler.instance().getEffectiveSide().isServer()
        startChain(player,world,x,y,z);
        return true;
    }
    
    public void startChain(EntityPlayer player, World world, int x, int y, int z){
        ElementalSciences.proxy.startChain(player, world, x, y, z, id, meta,charge);
    }
    
    public void beginSelection(EntityPlayer player, World world, int firstXPos, int firstYPos, int firstZPos, int secondXPos, int secondYPos, int secondZPos){
        ElementalSciences.proxy.beginSelection(player, world, firstXPos, firstYPos, firstZPos, secondXPos, secondYPos, secondZPos);
    }
    
}
