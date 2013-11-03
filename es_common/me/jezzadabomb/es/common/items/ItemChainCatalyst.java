package me.jezzadabomb.es.common.items;

import java.util.List;

import me.jezzadabomb.es.common.WorldTicker;
import me.jezzadabomb.es.common.api.ItemES;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChainCatalyst extends ItemES {
    
    public ItemChainCatalyst(int id, String name) {
        super(id, name);
        setMaxDamage(127);
    }
    
    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int sideHit, float hitVecX, float hitVecY, float hitVecZ) {
        if(FMLCommonHandler.instance().getEffectiveSide().isServer()){
            WorldTicker.addSwapper(world, x, y, z, world.getBlockId(x, y, z), world.getBlockMetadata(x,y,z), world.getBlockId(x, y, z), world.getBlockMetadata(x,y,z), 3, player);
            itemStack.damageItem(1, player);
        }
        return true;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack)
    {
        return EnumRarity.epic;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Creates destructive energy wave,");
        list.add("propagates it through a medium,");
        list.add("destroying the medium.");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }
}
