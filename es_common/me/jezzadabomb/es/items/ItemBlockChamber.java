package me.jezzadabomb.es.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

public class ItemBlockChamber extends ItemBlock{

    public static final String[] chamberNames = new String[] {"de", "st", "re", "con"};
    
    public ItemBlockChamber(int id){
        super(id);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public int getMetadata (int meta){
        return meta;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if(par1ItemStack.getItemDamage() == 3){
        if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
            par3List.add("The controller for the");           
            par3List.add("assembly chamber.");           
        }else{
            par3List.add("Left Shift For More Info.");
        }
        super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
        }
    }
    
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        return super.getUnlocalizedName() + "." + chamberNames[par1ItemStack.getItemDamage()];
    }
}
