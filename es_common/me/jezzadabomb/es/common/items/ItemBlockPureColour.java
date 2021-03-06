package me.jezzadabomb.es.common.items;

import java.util.List;

import me.jezzadabomb.es.common.api.ItemBlockES;
import me.jezzadabomb.es.common.blocks.BlockPureColour;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

public class ItemBlockPureColour extends ItemBlockES {

    public static final String[] dyeColorNames = new String[] { "white", "orange", "magenta", "lightBlue", "yellow", "lime", "pink", "gray", "silver", "cyan", "purple", "blue", "brown", "green", "red", "black" };

    public ItemBlockPureColour(int id) {
        super(id);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return super.getUnlocalizedName() + "." + dyeColorNames[BlockPureColour.getDyeFromBlock(par1ItemStack.getItemDamage())];
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            par3List.add("This colour has been designed and");
            par3List.add("built purely by machines, trying to");
            par3List.add("get that perfect colour that you");
            par3List.add("desire.");
        } else {
            par3List.add("Left Shift For More Info.");
        }
    }
}
