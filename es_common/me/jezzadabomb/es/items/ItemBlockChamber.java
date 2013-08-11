package me.jezzadabomb.es.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemBlockChamber extends ItemBlockES {

    public static final String[] chamberNames = new String[] { "de", "st", "re", "case" };

    public ItemBlockChamber(int id) {
        super(id);
        setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return super.getUnlocalizedName() + "." + chamberNames[par1ItemStack.getItemDamage()];
    }

    @Override
    @SuppressWarnings("rawtypes")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
    }
}
